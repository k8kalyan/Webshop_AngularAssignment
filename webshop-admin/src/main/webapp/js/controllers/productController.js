'use strict';

// the LoginController contains two objects:
// - store: contains the product list
// - cart: the shopping cart object
function productController($scope, $routeParams, DataService, $http, $location) {

	// get store and cart from service
	$scope.store = DataService.store;
	$scope.cart = DataService.cart;

	$scope.DisplaySave = true;
	$scope.DisplayUpdate = false;

	var productId = 0;
	var categoryId = 0;

	$scope.getProducts = function() {
		$http({
			method : 'GET',
			url : 'getProduct'
		}).success(function(data, status, headers, config) {
			$scope.products = data
		}).error(function(data, status, headers, config) {
			// error page
		});
	}

	$scope.getCategory = function() {
		$http({
			method : 'POST',
			url : 'getCategory'
		}).success(function(data, status, headers, config) {
			$scope.categories = data
		}).error(function(data, status, headers, config) {
			// error page
		});
	}

	$scope.getUsers = function() {
		$http({
			method : 'GET',
			url : 'getUserList'
		}).success(function(data, status, headers, config) {
			$scope.user = data
		}).error(function(data, status, headers, config) {
			
		});
	}

	$scope.getPurchaseOrder = function() {
		$http({
			method : 'GET',
			url : 'getPurchaseOrder'
		}).success(function(data, status, headers, config) {
			$scope.purchaseOrders = data
		}).error(function(data, status, headers, config) {
			
		});
	}

	$scope.addUser = function(UserEntity) {
		$http(
				{
					method : 'GET',
					url : 'addUser' + '/' + UserEntity.fname + '/'
							+ UserEntity.lname + '/' + UserEntity.email + '/'
							+ UserEntity.username + '/' + UserEntity.password
							+ '/' + UserEntity.address + '/' + UserEntity.city
							+ '/' + UserEntity.pincode,
				}).success(function(data) {
			if (data != null) {
				$scope.user = data;
				document.getElementById('reg').style.display = "none";
				document.getElementById('abc').style.display = "none";
			}
		}).error(function(data, status, headers, config) {
			
		});
	};
	var username = [];
	$scope.getAuthenticted = function(UserEntity, items,orderShip) {
		$http(
				{
					method : 'GET',
					url : 'getAuthenticted' + '/' + UserEntity.username + '/'
							+ UserEntity.password,
				}).success(function(data) {

			if (data != null) {
				username = data.username;
				$scope.cart.userDetails = username;
				$scope.user = data;
				document.getElementById('abc').style.display = "none";
				if (orderShip){
					$location.path("item_ordered");
					$scope.addOrder(orderShip, items, UserEntity)
			}
			}
		}).error(function(data, status, headers, config) {
			alert("User is not registered. Please register")
			
		});
	};

	
	$scope.addOrder = function(OrderShipment, items, user) {
	 $scope.cart.orderShip = OrderShipment;
		if (user != null) {
			$http(
					{
						method : 'GET',
						url : 'addOrder' + '/' + OrderShipment.shippingAddress
								+ '/' + OrderShipment.shippingCity + '/'
								+ OrderShipment.pin + '/'
								+ OrderShipment.status + '/'
								+ JSON.stringify(items),
					}).success(function(data) {
				if (data != null) {
					$scope.user = data;
					$scope.status = "Order Successful!!";
				
				}
			}).error(function(data, status, headers, config) {
				
			});
		} else {
			$location.path("adminLoginPage");
		}
	};
	$scope.addCategory = function(ProductCategories) {

		$http({
			method : 'GET',
			url : 'addCategory' + '/' + ProductCategories.name,
		}).success(function(data) {
			$scope.getCategory();
		}).error(function(data, status, headers, config) {
			// error status.
		});

		var person = {
			name : ProductCategories.name,
		
		};
		$scope.categories.push(person);
		$scope.resetCategory();
	};

	$scope.deletePlaceOrder = function(item) {
		var productObject = [];
		$http({
			method : 'GET',
			url : 'deleteProduct' + '/' + JSON.stringify(item),
		}).success(function(data) {
			$scope.products.splice($scope.products.indexOf(item));
			$scope.getProducts();
		}).error(function(data, status, headers, config) {
						
		});
		this.products = productObject;
	};

	$scope.deleteCategory = function(category) {
	var categoryObject = [];
		$http({
			method : 'GET',
			url : 'deleteCategory' + '/' + JSON.stringify(category),
		})
				.success(
						function(data) {
							$scope.categories.splice($scope.categories
									.indexOf(category));
							$scope.getCategory();
						})
				.error(
						function(data, status, headers, config) {
							alert("Cannot delete or update a parent row: a foreign key constraint fails")
							
						});
		this.category = categoryObject;
	};

	$scope.addItem = function(item) {
		$http(
				{
					
					method : 'GET',
					url : 'addProducts' + '/' + item.name + '/' + item.pcid.id
							+ '/' + item.quantity+ '/' + item.price,
				}).success(function(data, status, headers, config) {
			$scope.getProducts();
			$scope.user = data;
			$scope.status = "The Item added Successfully!!!";
		}).error(function(data, status, headers, config) {
			
		});

		var person = {
			id : item.id,
			name : item.name,
		};
		
		$scope.resetProducts();
	};

	$scope.updateItem = function(item) {
     	$http(
				{
					method : 'GET',
					url : 'addProducts' + '/' + item.name + '/' + item.id + '/'
							+ item.price,
				}).success(function(data) {
			$scope.getProducts();
			$scope.user = data;
			$scope.status = "The Item updated Successfully!!!";
		}).error(function(data, status, headers, config) {
			
		});
		$scope.resetProducts();
	};

	$scope.updateCategory = function(cat) {
		$http({
			method : 'GET',
			url : 'addCategory' + '/' + cat.id + '/' + cat.name,
		}).success(function(data, status, headers, config) {
			$scope.getCategory();
			$scope.user = data;
			$scope.status = "The Category updated Successfully!!!";
		}).error(function(data, status, headers, config) {
			
		});
		$scope.resetCategory();
	};

	$scope.resetCategory = function() {
		$scope.category.id = "";
		$scope.category.name = "";
		$scope.category.categoryPicture = "";
		$scope.DisplaySave = true;
		$scope.DisplayUpdate = false;
	}

	$scope.resetProducts = function() {
		$scope.item.id = "";
		$scope.item.name = "";
		$scope.item.price = "";
		$scope.item.pcid = "--select Item--";
		$scope.DisplaySave = true;
		$scope.DisplayUpdate = false;
	}

	$scope.editItem = function(item) {
		$scope.item = {};
		$scope.item1 = {};
		$scope.item.id = item.pcid;
		$scope.item.name = item.name;
		$scope.item.price = item.price;
		productId = $scope.item.id;
		$scope.DisplaySave = false;
		$scope.DisplayUpdate = true;
	};

	$scope.editCategory = function(category) {

		$scope.ProductCategories = {};
    	$scope.ProductCategories.id = category.id;
		$scope.ProductCategories.name = category.name;	
		$scope.DisplaySave = false;
		$scope.DisplayUpdate = true;
	};

	$scope.div_show = function() {
		document.getElementById('abc').style.display = "block";
	};

	$scope.div_showReg = function() {
		document.getElementById('reg').style.display = "block";
	};

	$scope.div_hide = function() {
		document.getElementById('abc').style.display = "none";
	};

	$scope.div_hideReg = function() {
		document.getElementById('reg').style.display = "none";
		document.getElementById('abc').style.display = "none";
	};
}
