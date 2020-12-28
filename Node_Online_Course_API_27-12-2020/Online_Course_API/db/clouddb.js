

const DB_USER = "root";
const DB_PASSWORD = "rootpassword";
const DB_NAME = "onlinecoursesplatform";
const CLUSTER_HOST = "ustdemo.qzlec.mongodb.net";
//mongodb+srv://root:<password>@ustdemo.qzlec.mongodb.net/<dbname>?retryWrites=true&w=majority


exports.DB_URI= `mongodb+srv://${DB_USER}:${DB_PASSWORD}@${CLUSTER_HOST}/${DB_NAME}?retryWrites=true&w=majority`;

