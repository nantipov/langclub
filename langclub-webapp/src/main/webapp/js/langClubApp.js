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
            userId: '1',
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
        $scope.user.userLanguages = [];
        $scope.user.preparedLanguageList.forEach(function(value) {
            var splitData = value.split(':', 2);
            if (splitData && splitData.length == 2) {
                $scope.user.userLanguages.push(
                    {
                        language: splitData[0].trim(),
                        level: splitData[1].trim()
                    }
                );
            }
        });
        userData.setData($scope.user);
    };

    $scope.user = {
        preparedLanguageList: []
    };

    var loadUserData = function() {
    	userData.getData(function(data) {
            $scope.user = {
                userPersonalData: data.userPersonalData,
                userLanguages: data.userLanguages,
                preparedLanguageList: []
            };
            data.userLanguages.forEach(function(value) {
                $scope.user.preparedLanguageList.push(value.language + ": " + value.level);
            });
        });
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

    $scope.suggestedLanguages = [
        "ENGLISH: NATIVE", "ENGLISH: BEGINNER",
        "RUSSIAN: NATIVE", "RUSSIAN: BEGINNER"
    ];
    
    $scope.LIST_ACCOUNT_TYPES = [
        {id: 'g', title: 'Google Plus', iconName: 'icon1'},
        {id: 'm', title: 'Microsoft Live', iconName: 'icon2'}
    ];

    $scope.$on('$viewContentLoaded', function() {
        loadUserData();
    });

}]);

langClubApp.controller('conferenceController', ['$scope', function($scope) {
	
	$scope.searchCriteria = {
		searchText: '',
		dateRange: {
			from: 10,
			to: 20
		}
	};
	
	$scope.confIndex = 0;
	
	$scope.conferences = [
         {id: 'card1'},
         {id: 'card2'}
	];
	
	$scope.newConference = {
			whenDate: new Date()
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
            when('/navViewConference', {
                templateUrl: 'partials/club-conference.html',
                controller: 'conferenceController'
            }).
            otherwise({
                redirectTo: '/partials/dashboard_def.html'
            });
    }]);