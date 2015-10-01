var langClubApp = angular.module( "langClubApp", ['ngRoute', 'ngMaterial', 'userService'] );
	
langClubApp.controller('generalController', function($scope, $mdSidenav) {

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

	$scope.tabs = [{name: 'tab1'}, {name: 'tab2'}];

	$scope.openLeftMenu = function() {
		$mdSidenav('left').toggle();
		};

    $scope.menu = {};
    $scope.menu.sections = [
        {name: "section1", type: 'heading'},
        {name: "section2", children: [
            {type: 'link'},
            {type: 'toggle'}
        ], type: 'toggle'},
        {name: "section3", type: 'link'}
    ];

    $scope.users = [
        {name: 'u1', selected: 'true', avatar: 'av1'},
        {name: 'u2', avatar: 'av2'},
        {name: 'u3', avatar: 'av3'}
    ];

    $scope.selected = $scope.users[0];

});

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