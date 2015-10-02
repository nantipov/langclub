angular.module('userService', ['ngResource']).factory('userData', ['$resource', function($resource) {

    // resource class
    var UserDataResource = $resource('rest/user/data', {}, {
        get: {method: 'GET'},
        save: {method: 'POST'}
    });

    var getData = function (successEvent) {
        UserDataResource.get({}, successEvent);
    };

    var setData = function (data) {
        UserDataResource.save({}, data);
    };

    return {
    	getData: getData,
    	setData: setData
    };
}]);