angular.module('app.services', []).factory('Pet', function ($resource) {
    return $resource('/api/v1/pets/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
}).service('popupService', function ($window) {
    this.showPopup = function (message) {
        return $window.confirm(message);
    }
});
