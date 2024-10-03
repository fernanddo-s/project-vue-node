module.exports = {
    database: process.env.DB_NAME || 'db_vue_node',
    username: process.env.DB_USERNAME || 'postgres',
    password: process.env.DB_PASSWORD || 'postgres',
    host: process.env.DB_HOST || 'localhost',
    dialect: process.env.DB_DIALECT || 'postgres',
    port: process.env.APP_PORT || 8000
}