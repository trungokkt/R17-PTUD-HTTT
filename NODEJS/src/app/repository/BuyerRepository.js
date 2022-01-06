const axios = require("axios");
const httpJava = "http://localhost:8080/api/v1";

class BuyerRepository {
    async getNearbyStore(local) {
        const stores = await axios.get(httpJava + "/stores", {
            params: {
                local: local,
            },
        });
        return stores.data
    }
    async getProductTypeOfStore(storeid) {
        const producttype = await axios.get(httpJava + '/producttype/' + storeid)
        return producttype.data
    }
    async getProductOfStore(storeid) {
        const products = await axios.get(httpJava + '/products', {
            params: {
                storeid: storeid
            }
        })
        return products.data
    }
}

module.exports = new BuyerRepository();