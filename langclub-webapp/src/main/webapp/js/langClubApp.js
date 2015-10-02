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

langClubApp.controller('accountController', ['$scope', 'userSettings', function($scope, userSettings) {

    $scope.getUserSettings = function() {
        userSettings.getSettings(function(settingsData) {
            $scope.languages = settingsData.userLanguages;
        });
    };

    $scope.setStubUserSettings = function() {
        var settings = {
            userId: '0',
            userLanguages: [
                {language: 'ENGLISH', level: 'ADVANCED'},
                {language: 'RUSSIAN', level: 'NATIVE'}
            ]
        };
        userSettings.setSettings(settings);
    };

    $scope.user = {
        nickname: "Hey"
    };

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