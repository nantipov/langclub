var langClubApp = angular.module( "langClubApp", ['ngRoute', 'ui.bootstrap'] );
	
langClubApp.controller('generalController', function($scope) {
	$scope.tabs = [{name: 'tab1'}, {name: 'tab2'}];
});

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
    
});