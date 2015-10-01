angular.module('userService', ['ngResource']).factory('userSettings', ['$resource', function($resource) {

    // resource class
    var UserSettingsResource = $resource('rest/user/settings', {}, {
        get: {method: 'GET'},
        save: {method: 'POST'}
    });

    var getSettings = function (successEvent) {
        UserSettingsResource.get({}, successEvent);
    };

    var setSettings = function (settings) {
        UserSettingsResource.save({}, settings);
    };

    return {
        getSettings: getSettings,
        setSettings: setSettings
    };
}]);