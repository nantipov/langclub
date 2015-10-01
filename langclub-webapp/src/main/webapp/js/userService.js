angular.module('userService', ['ngResource']).factory('userSettings', ['$resource', function($resource) {

    // resource class
    var UserSettingsResource = $resource('rest/user/settings', {}, {
        get: {method: 'GET'},
        save: {method: 'POST'}
    });

    return UserSettingsResource;
}]);