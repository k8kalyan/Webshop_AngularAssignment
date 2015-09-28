// store contains the products
function store($http) {

	var productObject = [];
	$http({
		method : 'GET',
		url : 'getProduct'
	}).success(
			function(data, status, headers, config) {
				for (var i = 0; i < data.length; i++) {
					productObject[i] = new product(data[i].id,
							data[i].name, data[i].price,
							data[i].pcid);
				}
			}).error(function(data, status, headers, config) {
		// error page
	});

	//this.products = productObject;
}