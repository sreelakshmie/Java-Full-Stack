var RESOURCE_NAME = 'courses';
var VERSION = 'v1';
var URI = '/' + VERSION + '/' + RESOURCE_NAME; 
var apiErrors = require('../../util/errors')
var apiMessages = require('../../util/messages')
var db = require('../../db/courses')

module.exports = function(router){
    'use strict';

    router.route(URI).get(function(req, res,next){
        console.log("GET Courses")



        var reqBody=req.body;
         var criteria = reqBody;
//req.body (to pass request along with request body) and req.query (to pass request along with URI)

         var fields ={}
        if(reqBody && reqBody.fields !== undefined){
           fields =  createFields(reqBody.fields)
        }
        var pagination = {limit:0, offset:0}
        
        if(reqBody && reqBody.limit !== undefined){
            pagination.limit = reqBody.limit
        }
        if(reqBody && reqBody.offset !== undefined){
            pagination.offset = reqBody.offset
        }

 var options = {fields:fields, pagination:pagination}
        console.log(options)

        db.select( options,function(err,docs){
      
       // db.select(criteria,function(err,docs){
         //db.select(function(err,docs){
            if(err){
                console.log(err)
                res.status(500)
                res.send("Error connecting to db")
            } else {
                if(docs.length == 0){
                    res.status(404)
                }
                console.log("Retrieved courses = %d",docs.length)
                res.send(docs)
            }
        });
    });

    
    router.route(URI).post(function(req, res,next){
        console.log("POST  courses")

      
        var reqBody = req.body;

     
        db.save(reqBody, function(err,saved){
            if(err){
               
                var userError = processMongooseErrors(apiMessages.errors.API_MESSAGE_CREATE_FAILED, "POST", URI, err,{});
                res.setHeader('content-type', 'application/json')
                res.status(400).send(userError)
            } else {
                res.send(saved)
            }
        });
    });


    router.route(URI).delete(function(req,res,next){
        var reqBody=req.body;
        console.log("Remove data")
        var criteria = reqBody;
        db.delete(criteria,function(err,deleted){
            if(err){
                console.log(err)
                res.status(500)
                res.send("Error connecting to db")
            } else {
                console.log("Deleted courses = %d",deleted.length)
                res.send(deleted)
            }
        });
    });
    

    router.route(URI).put(function(req,res,next){
        console.log("update data")
        var criteria = {_id:'5fe953c6f4c31d1cfc9376c2'}
        var reqBody = req.body;
        db.update(criteria,reqBody,function(err,updated){
            if(err){
                console.log(err)
                res.status(500)
                res.send("Error connecting to db")
            } else {
                console.log("updated courses = %d",updated.length)
                res.send(updated)
            }
        });
    });
}


var processMongooseErrors = function (message, method, endpoint, err,payload) {
    var errorList = []

    if (err.name === 'ValidationError'){
        errorList = processValidationErrors(err)
    } else if(err.code == 11000){
      
        errorList.push(apiErrors.errors.PACKAGE_ALREADY_EXISTS)
    } else {
        var errUnknown = apiErrors.errors.UNKNOWN_ERROR
        errUnknown.payload = err
        errorList = [apiErrors.errors.UNKNOWN_ERROR]
    }
    return apiErrors.create(message, method, endpoint, errorList, payload)
}

var processValidationErrors = function (err) {
    var errorList = []
  
    if (err.errors.durationInHours) {
        if (err.errors.durationInHours.kind === apiErrors.kinds.MIN_ERROR 
        || err.errors.durationInHours.kind === apiErrors.kinds.NUMBER_ERROR ) {
            errorList.push(apiErrors.errors.FORMAT_DURATION)
        }
    }
    if (err.errors.price) {
        if (err.errors.price.kind === apiErrors.kinds.MIN_ERROR 
        || err.errors.price.kind === apiErrors.kinds.NUMBER_ERROR ) {
            errorList.push(apiErrors.errors.FORMAT_PRICE)
        }
    }

    if (err.errors.name) {
        if (err.errors.name.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_NAME)
        }
    }
    if (err.errors.code) {
        if (err.errors.code.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_CODE)
        }
    }
   
    if (err.errors.description) {
        if (err.errors.description.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_DESCRIPTION)
        }
    }
    if (err.errors.category) {
        if (err.errors.category.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_CATEGORY)
        }
    }
    if (err.errors.durationInHours) {
        if (err.errors.durationInHours.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_dURATION_IN_HOURS)
        }
    }
    if (err.errors.price) {
        if (err.errors.price.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_PRICE)
        }
    }
    if (err.errors.authors) {
        if (err.errors.authors.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_AUTHORS)
        }
    }
    return errorList;
}