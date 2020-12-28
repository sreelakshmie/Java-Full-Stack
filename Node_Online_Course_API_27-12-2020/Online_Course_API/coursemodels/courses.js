
var settings = require('../db/settings')


var CoursesSchema = settings.mongoose.Schema(
    {
        "code":{type:String, required:[true,'code is needed']},
        "name" : {type:String, required:[true,'Name is needed']},
        "description" : {type:String, required:true},
        "category" : {type:String, required:[true,'Category is needed']},
        "keywords" : {type:[String],required:false},
        "contents" : [{
            "title" :{type:String, required:true},
            "description" :{type:String, required:false},
            "video"  : {type:String, required:false}
        }],
        "durationInHours" :{type: Number, required:true, min:1},
        "price" :{type: Number, required:true, min:0},
        "offer" : {
            "discount" : Number,
            "expires" :{type:Date, required:false}
        },
        "authors" : {type:[String]},
        "rating" : {type: Number, required:true, min:0 , max:5},
        "reviews" : [{
            "name" : {type:String, required:true},
            "comment" : {type:String , required:true}
        }]
    }
);


exports.Courses = settings.mongoose.model('onlinecourses', CoursesSchema)