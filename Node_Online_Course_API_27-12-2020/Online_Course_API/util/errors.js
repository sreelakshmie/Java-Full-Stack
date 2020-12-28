
exports.errors = {
  
    UNKNOWN_ERROR : {
        code:500,
        text:"Unknown error !!!",
        hints:["Please contact development team wit information on 'how to reproduce this error'. Thank you for your help and support."],
        info:"http://developer.acme.com/unknownerror"
    },

    PACKAGE_ALREADY_EXISTS :{
        code:600,
        text:"Course package with the provided 'name' already exist",
        hints:["Please use PUT for update instead of POST"],
        info:"http://developer.acme.com/errors#6000"
    },

    
    MISSING_PACKAGE_NAME : {
        code:800,
        text:"Required field Course 'name' is missing",
        hints:["Please check that user has provided the non null value for 'name'"],
        info:"http://developer.acme.com/error#RequiredFields"
    },
    MISSING_PACKAGE_CODE : {
        code:801,
        text:"Required field Course 'code' is missing",
        hints:["Please check that user has provided the non null value for 'code'"],
        info:"http://developer.acme.com/error#RequiredFields"
    },
    MISSING_PACKAGE_DESCRIPTION :  {
        code:802,
        text:"Required field Course 'description' is missing",
        hints:["Please check that user has provided the non null value for description"],
        info:"http://developer.acme.com/error#RequiredFields"
    }  ,
    
    MISSING_PACKAGE_CATEGORY : 
    {
        code:803,
        text:"Required field Course 'category' is missing",
        hints:["Please check that user has provided the non null value for category"],
        info:"http://developer.acme.com/error#RequiredFields"
    },
    MISSING_PACKAGE_dURATION_IN_HOURS : 
    {
        code:804,
        text:"Required field Course 'duration' is missing",
        hints:["Please check that user has provided the non null value for duration"],
        info:"http://developer.acme.com/error#RequiredFields"
    },
    MISSING_PACKAGE_PRICE : 
    {
        code:805,
        text:"Required field Course 'price' is missing",
        hints:["Please check that user has provided the non null value for price"],
        info:"http://developer.acme.com/error#RequiredFields"
    },
    MISSING_PACKAGE_AUTHORS : 
    {
        code:806,
        text:"Required field Course 'Author/Authors' is missing",
        hints:["Please check that user has provided the non null value for Authors"],
        info:"http://developer.acme.com/error#RequiredFields"
    },

    
    FORMAT_DURATION : {
        code:900,
        text:"Duration MUST be a number (greater then 1)",
        hints:["Please check that user has provided a numeric value for 'duration'"],
        info:"http://developer.acme.com/error#RequiredFields"
    },

    FORMAT_PRICE : {
        code:901,
        text:"Price MUST be a number (must be greater than or equal to 0)",
        hints:["Please check that user has provided a numeric value for 'price'"],
        info:"http://developer.acme.com/error#RequiredFields"
    }
}


exports.create = function(message,httpMethod,endpointInformation,errorList,receivedPayload){
    return    {
       
        text:message,
        timestamp:new Date(),
        
        method:httpMethod,
       
        endpoint:endpointInformation,
       
        errors : errorList,
      
        payload: receivedPayload
    }
}


exports.kinds = {
    REQUIRED:"required",
    NOT_VALID:"notvalid",
    NUMBER_ERROR:"Number",
    MIN_ERROR:"min",
    MAX_ERROR:"max",
}

