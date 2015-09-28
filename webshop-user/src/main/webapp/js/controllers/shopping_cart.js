﻿// shopping cart
function shoppingCart(cartName) {
	this.cartName = cartName;
	this.clearCart = false;
	this.checkoutParameters = {};
	this.items = [];

	// load items from local storage when initializing
	this.loadItems();

	// save items to local storage when unloading
	var self = this;
	$(window).unload(function() {
		if (self.clearCart) {
			self.clearItems();
		}
		self.saveItems();
		self.clearCart = false;
	});
}

// load items from local storage
shoppingCart.prototype.loadItems = function() {
	var items = localStorage != null ? localStorage[this.cartName + "_items"]
			: null;
	if (items != null && JSON != null) {
		try {
			var items = JSON.parse(items);
			for (var i = 0; i < items.length; i++) {
				var item = items[i];
				if (item.sku != null && item.name != null && item.price != null
						&& item.quantity != null) {
					item = new cartItem(item.sku, item.name, item.price,
							item.quantity);
					this.items.push(item);
				}
			}
		} catch (err) {
			// ignore errors while loading...
		}
	}
}

// save items to local storage
shoppingCart.prototype.saveItems = function() {
	if (localStorage != null && JSON != null) {
		localStorage[this.cartName + "_items"] = JSON.stringify(this.items);
	}
}

// adds an item to the cart
shoppingCart.prototype.addItem = function(sku, name, price, quantity) {
	quantity = this.toNumber(quantity);
	if (quantity != 0) {
		// update quantity for existing item
		var found = false;
		for (var i = 0; i < this.items.length && !found; i++) {
			var item = this.items[i];
			if (item.sku == sku) {
				found = true;
				item.quantity = this.toNumber(item.quantity + quantity);
				if (item.quantity <= 0) {
					this.items.splice(i, 1);
				}
			}
		}
		// new item, add now
		if (!found) {
			var item = new cartItem(sku, name, price, quantity);
			this.items.push(item);
		}
		// save changes
		this.saveItems();
	}
}

// get the total price for all items currently in the cart
shoppingCart.prototype.getTotalPrice = function(sku) {
	var total = 0;
	for (var i = 0; i < this.items.length; i++) {
		var item = this.items[i];
		if (sku == null || item.sku == sku) {
			total += this.toNumber(item.quantity * item.price);
		}
	}
	return total;
}

// get the total price for all items currently in the cart
shoppingCart.prototype.getTotalCount = function(sku) {
	var count = 0;
	for (var i = 0; i < this.items.length; i++) {
		var item = this.items[i];
		if (sku == null || item.sku == sku) {
			count += this.toNumber(item.quantity);
		}
	}
	return count;
}

// clear the cart
shoppingCart.prototype.clearItems = function() {
	this.items = [];
	this.saveItems();
}

shoppingCart.prototype.toNumber = function(value) {
	value = value * 1;
	return isNaN(value) ? 0 : value;
}

// items in the cart
function cartItem(sku, name, price, quantity) {
	this.sku = sku;
	this.name = name;
	this.price = price * 1;
	this.quantity = quantity * 1;
}

// product class
function product(id, name, price, pcid) {
	this.id = id;
	this.name = name;
	this.price = price;
	this.pcid = pcid;
	//this.productPicture = productPicture;
}

// category class
function category(id, name) {
	this.id = id;
	this.name = name;
//	this.categoryPicture = categoryPicture;
}

// user class
function user(userLoginId, firstName, lastName, emailId, phoneNumber, address,
		pinCode) {
	this.userLoginId = userLoginId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.phoneNumber = phoneNumber;
	this.address = address;
	this.pinCode = pinCode;
}

// product class
function purchaseOrder(purchaseOrderId, purchaseOrderNo, userLoginId,
		shippingAddress, totalAmount) {
	this.purchaseOrderId = purchaseOrderId;
	this.userLoginId = userLoginId;
	this.purchaseOrderNo = purchaseOrderNo;
	this.shippingAddress = shippingAddress;
	this.totalAmount = totalAmount;
}
