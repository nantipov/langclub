var langClubApp = angular.module( "langClubApp", ['ngRoute'/*, 'ngView'*/, 'ngMaterial'] );
	
langClubApp.controller('generalController', function($scope, $mdSidenav) {
	$scope.tabs = [{name: 'tab1'}, {name: 'tab2'}];
	
	$scope.openLeftMenu = function() {
		$mdSidenav('left').toggle();
		};
});

/*
langClubApp.config(function($routeProvider) {

    $routeProvider

    // route for the home page
    .when('/h', {
        templateUrl : 'views/home.html',
        controller  : 'mainController'
    })

    // route for the about page
    .when('/about', {
        templateUrl : 'pages/about.html',
        controller  : 'aboutController'
    })

    // route for the contact page
    .when('/contact', {
        templateUrl : 'pages/contact.html',
        controller  : 'contactController'
    });
    
});*/