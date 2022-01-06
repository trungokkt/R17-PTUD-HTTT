
var buyerRepository = require('../repository/BuyerRepository')
class BuyerController {
    //[GET] /
    async showHome(req, res, next) {
        res.render("buyer-layout/sites/index", {
            layout: "../buyer-layout/layout",
        });
    }
    //[GET] /store-detail
    async showShopDetail(req, res, next) {
        const storeid = req.params.storeid

        const producttype = await buyerRepository.getProductTypeOfStore(storeid);

        const products = await buyerRepository.getProductOfStore(storeid)
        products.forEach(product => {
            const isProductType = (element) => element.productTypeId == product.productType.productTypeId;
            var product_type_index = producttype.findIndex(isProductType)
            if (!producttype[product_type_index].products) {
                producttype[product_type_index].products = []
            }
            producttype[product_type_index].products.push(product)
        });
        res.render("buyer-layout/sites/store-detail", {
            layout: "../buyer-layout/layout",
            ProductType: producttype
        });
    }
    //[POST] /api/store
    async getStoreNear(req, res, next) {
        try {
            const local = req.body.local;
            const stores = await buyerRepository.getNearbyStore(local)
            res.json(stores)
        } catch (error) {
            console.error(error);
        }
    }

}

module.exports = new BuyerController();
