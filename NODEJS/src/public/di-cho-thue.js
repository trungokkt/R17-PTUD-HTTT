var x = document.getElementById("buyer-address");
var localSearch = []

function getLocation() {
    var position = JSON.parse(localStorage.getItem('position'))
    if (!position) {
        if (navigator.geolocation) {
            navigator.geolocation.watchPosition(showPosition,showError)

        } else {
            window.alert("Geolocation is not supported by this browser");
        }
    }
    else {
        var address = JSON.parse(localStorage.getItem('address'))
        x.innerHTML = address.formatted_address
        getStore();
    }

}
function showPosition(position) {
    $.ajax({
        url: `https://rsapi.goong.io/Geocode?latlng=${position.coords.latitude},${position.coords.longitude}&api_key=DRrVm7GwoRNp4gEDSIKp6E2rEJFzzB4jeHaL5Ns0`,
        success: function (result) {
            x.innerHTML = result.results[0].formatted_address
            localStorage.setItem('position', JSON.stringify(position))
            localStorage.setItem('address', JSON.stringify(result.results[0]))
            getStore();
        }
    });
}

function showError(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED:
            x.innerHTML = "User denied the request for Geolocation."
            break;
        case error.POSITION_UNAVAILABLE:
            x.innerHTML = "Location information is unavailable."
            break;
        case error.TIMEOUT:
            x.innerHTML = "The request to get user location timed out."
            break;
        case error.UNKNOWN_ERROR:
            x.innerHTML = "An unknown error occurred."
            break;
    }
}

function getStore(address) {
    var address = JSON.parse(localStorage.getItem('address'))
    var local = address.address_components[parseInt(address.address_components.length / 2)].short_name
    console.log(address)
    $.ajax({
        method: 'POST',
        url: `/api/stores`,
        data: { local: local },
        success: function (result) {
            result.sort((a, b) => {
                var m1 = getDistanceFromLatLonInKm(parseFloat(a.storeLat), parseFloat(a.storeLng), address.geometry.location.lat, address.geometry.location.lng)
                var m2 = getDistanceFromLatLonInKm(parseFloat(b.storeLat), parseFloat(b.storeLng), address.geometry.location.lat, address.geometry.location.lng)
                return m1 - m2
            })
            $('#list-store').empty();
            result.forEach((element) => {
                $('#list-store').append(
                    `
                    <div class="col-xl-3 col-lg-4 col-md-4 col-6">
                        <div class="single-product">
                            <div class="product-img">
                                <a href="/store-detail/${element.storeId}">
                                    <img class="default-img" src="https://via.placeholder.com/550x600"
                                        alt="#">
                                    <img class="hover-img" src="https://via.placeholder.com/550x600"
                                        alt="#">
                                </a>
                                <div class="button-head">
                                    <div class="product-action">
                                        <a title="Wishlist" href="#"><i class=" ti-heart "></i><span>Add
                                                to Wishlist</span></a>
                                    </div>
                                    <div class="product-action-2">
                                        <a title="Store Info" href="#">Store Info</a>
                                    </div>
                                </div>
                            </div>
                            <div class="product-content">
                                <h3><a href="product-details.html" >${element.storeName} (${getDistanceFromLatLonInKm(parseFloat(element.storeLat), parseFloat(element.storeLng), address.geometry.location.lat, address.geometry.location.lng).toFixed(2)} km)</a></h3>
                                <div class="product-price">
                                    <span class="text-ellipsis" title="${element.storeAddress}" >${element.storeAddress}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    `
                )
            })
        }
    })
}
function searchLocation() {
    var address = $("#txtAddress").val()
    $.ajax({
        url: `https://rsapi.goong.io/geocode?api_key=DRrVm7GwoRNp4gEDSIKp6E2rEJFzzB4jeHaL5Ns0&address=${address}`,
        success: function (result) {
            localSearch = result.results
            $('#result-address').empty()
            result.results.forEach((element, index) => {
                $('#result-address').append(
                    `<div><span class="buyer-address fix-weight" title="${element.formatted_address}">${element.formatted_address}</span> <button onclick="selectAdress(${index})" class="btn" data-dismiss="modal">chọn</button></div>`
                );
            });

        }
    })
}
function selectAdress(i) {
    localStorage.setItem('address', JSON.stringify(localSearch[i]))
    getLocation();
}
window.onload = function () {
    getLocation();
};
$("#txtAddress").on("keypress", function (e) {
    if (e.key === 'Enter') {
        searchLocation();
    }
});

function getDistanceFromLatLonInKm(lat1, lon1, lat2, lon2) {
    var R = 6371; // Radius of the earth in km
    var dLat = deg2rad(lat2 - lat1);  // deg2rad below
    var dLon = deg2rad(lon2 - lon1);
    var a =
        Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
        Math.sin(dLon / 2) * Math.sin(dLon / 2)
        ;
    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    var d = R * c; // Distance in km
    return d;
}
function deg2rad(deg) {
    return deg * (Math.PI / 180)
}

function goToByScroll(id) {
    console.log(id)
    // Scroll
    $('html,body').animate({
        scrollTop: $("#" + id).offset().top - $(window).height()/3
    }, 'slow');
}