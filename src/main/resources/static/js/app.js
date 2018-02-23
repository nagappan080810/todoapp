var app = angular.module('app', ['ngRoute', 'ngResource']);
app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/classicview', {
			templateUrl: '/views/classicalview.html',
			controller: 'classicalViewController'
		})
		.otherwise({
			templateUrl: '/views/classicalview.html',
			controller: 'classicalViewController'
		});
	console.log($routeProvider);
}]);
