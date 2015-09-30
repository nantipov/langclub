angular.module('userService', ['ngResource']).factory('userSettings', ['$resource', function($resource) {
    var getSettings = function() {
        return $resource('rest/user/settings', {}, {
            get: {method: 'GET'}
        }).get();
    };

    var setSettings = function(settings) {
        return $resource('rest/user/settings', {}, {
            save: {method: 'POST'}
        }).save({}, settings);
    };

    return {
        getSettings: getSettings,
        setSettings: setSettings
    };
}]);