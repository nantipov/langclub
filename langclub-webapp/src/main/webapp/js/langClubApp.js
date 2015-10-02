var langClubApp = angular.module( "langClubApp", ['ngRoute', 'ngMaterial', 'ngMessages', 'userService'] );
	
langClubApp.controller('generalController', ['$scope', '$mdSidenav', '$mdMedia', function($scope, $mdSidenav, $mdMedia) {

    $scope.navigationItems = [
        {id: '#navViewDashboard', name: 'Dashboard'},
        {id: '#navViewAccount', name: 'Account'},
        {id: 'navViewConference', name: 'Conference'},
        {id: 'navViewWhiteScreen', name: 'White screen'},
        {id: 'navViewDonate', name: 'Donate'}
    ];

    $scope.currentNavItem = $scope.navigationItems[0];

    $scope.switchNavView = function(navView) {
        $scope.currentNavItem = navView;
    };

    $scope.toggleNavMenu = function() {
        $mdSidenav('left').toggle();
    };

    $scope.mdMediaWrapper = function() {
        return $mdMedia('gt-sm');
    };

}]);

langClubApp.controller('accountController', ['$scope', 'userData', function($scope, userData) {

    $scope.getUserData = function() {
        userData.getData(function(data) {
            $scope.languages = data.userLanguages;
        });
    };

    $scope.setStubUserSettings = function() {
        var data = {
            userId: '0',
            userLanguages: [
                {language: 'ENGLISH', level: 'ADVANCED'},
                {language: 'RUSSIAN', level: 'NATIVE'}
            ]
        };
        userData.setData(data);
    };

    var loadUserData = function() {
    	userData.getData(function(data) {
            $scope.user = {
            		personalData: data.personalData,
            		languages: data.userLanguages
            };
        });
    }
    
    $scope.$on('$viewContentLoaded', function() {
        loadUserData();
    });

}]);

langClubApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/navViewDashboard', {
                templateUrl: 'partials/dashboard.html',
                controller: 'generalController'
            }).
            when('/navViewAccount', {
                templateUrl: 'partials/account.html',
                controller: 'accountController'
            }).
            otherwise({
                redirectTo: '/partials/dashboard_def.html'
            });
    }]);