angular.module('app.controllers', []).controller('PetListController', function ($scope, $state, popupService, $window, Pet) {
    $scope.pets = Pet.query(); //fetch all pets. Issues a GET to /api/vi/pet

    // Delete a pet
    // Issues a DELETE to /api/v1/pets/:id
    $scope.deletePet = function (pet) {
        if (popupService.showPopup('Really delete this?')) {
            pet.$delete(function () {
                $scope.pets = Pet.query();
                $state.go('pets');
            });
        }
    };
    // Get a single pet
    // Issues a GET to /api/v1/pets/:id
}).controller('PetViewController', function ($scope, $stateParams, Pet) {
    $scope.pet = Pet.get({id: $stateParams.id});

}).controller('PetFindController', function ($scope, $stateParams, Pet) {

    // Create new pet instance.
    // Properties will be set via ng-model on UI
    // Issues a POST to /api/v1/pets
}).controller('PetCreateController', function ($scope, $state, $stateParams, Pet) {
    $scope.pet = new Pet();
    $scope.addPet = function () {
        $scope.pet.$save(function () {
            $state.go('pets'); // on success go back to the list i.e. pets state.
        });
    };
});
