const express = require('express');
const router = express.Router();

const buyerController = require('../app/controllers/BuyerController')

//define route
router.get('/', buyerController.showHome);
router.get('/store-detail/:storeid', buyerController.showShopDetail);
router.post('/api/stores', buyerController.getStoreNear)
module.exports = router;