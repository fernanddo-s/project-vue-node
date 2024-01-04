import mysql from "mysql";

const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "mysql",
    database: "db_vue_node"
})

export default db;