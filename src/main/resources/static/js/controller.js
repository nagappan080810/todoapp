/**
 * app module controller which gives value to the template.
 */
app.controller('classicalViewController', function($scope, $http){
	$scope.headingTitle='Classical View';
	console.log("executing controller");
	var loadItems = function() {
		$http.get('/todos')
		.success(function(data, status, headers) {
			$scope.items = data;
		})
		.error(function(data, status, headers) {
			$scope.restresponse = "Not able to get the todo items from server <code="+status+">";
		});
	}
	loadItems();
	$scope.addItem = function() {
		var todoDataObj = {
				todoItem: $scope.todoItem,
			    status: $scope.status
		};
		console.log(todoDataObj);
		$http.post('/todos', todoDataObj)
		.success(function(data, status, headers) {
			$scope.restresponse = "Successfully Posted Data";
			loadItems();
		})
		.error(function(data,status,headers) {
			$scope.restresponse = "Add was not successfull <code=" + status+ ">"; 
		});
	}
	$scope.searchItem = function() {
		
		var parameters = {
				todoItem: $scope.todoItem,
			    status: $scope.status
		};
		var config = {
				params: parameters
		};
		console.log(config);
		$http.get('/todos/filter', config)
		.success(function (data, status, headers) {
			$scope.items = data;
		})
		.error(function (data, status, headers) {
			$scope.restresponse = "Search was not successfull <code=" + status+ ">";
		})
		
	}
	
	$scope.findItemStyle = function(status) {
		console.log("determing status"+status);
		if (status==="NOT_STARTED") {
			return "danger";
		}
		if (status==="IN_PROGRESS") {
			return "warning";
		}
		if (status==="COMPLETED") {
			return "success";
		}
	}
	
});
