const siteRouter = require('./sites');
const siteBuyer = require('./buyer')
function route(app) {
    app.use('/', siteBuyer);
    app.use('/', siteRouter);
}

module.exports = route;