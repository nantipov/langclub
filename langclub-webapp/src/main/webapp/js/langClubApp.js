var langClubApp = angular.module( "langClubApp", ['ngRoute', 'ngMaterial', 'ngMessages', 'userService'] );
	
langClubApp.controller('generalController', ['$scope', '$mdSidenav', '$mdMedia', function($scope, $mdSidenav, $mdMedia) {

    $scope.navigationItems = [
        {id: '#navViewDashboard', name: 'Dashboard'},
        {id: '#navViewAccount', name: 'Account'},
        {id: '#navViewConference', name: 'Conference'},
        {id: '#navViewWhiteScreen', name: 'White screen'},
        {id: '#navViewDonate', name: 'Donate'}
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

    $scope.setStubUserSettings = function() {
        var data = {
            userId: '0',
            userPersonalData: {
                email: 'myemail@mail.com',
                fullName: 'Jerry Pearson',
                nickname: 'jer'
            },
            userLanguages: [
                {language: 'ENGLISH', level: 'ADVANCED'},
                {language: 'RUSSIAN', level: 'NATIVE'}
            ]
        };
        userData.setData(data);
    };

    $scope.saveUserData = function() {
        userData.setData($scope.user);
    };

    var loadUserData = function() {
    	userData.getData(function(data) {
            $scope.user = {
                userPersonalData: data.userPersonalData,
                userLanguages: data.userLanguages
            };
        });
    };

    var prepareLanguagesList = function() {
        //$scope.user.preparedLanguageList
    };

    $scope.addLanguageChip = function($chip) {
        var splitData = ('' + $chip).split(':', 2);
        if (splitData && splitData.length == 2) {
            return {
                language: splitData[0].trim(),
                level: splitData[1].trim()
            };
        } else {
            return {
                language: 'Unrecognized language',
                level: 'Unrecognized level'
            };
        }
    };

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