angular.module('products', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

     $scope.fillTable = function () {
         $http.get(contextPath + '/products')
             .then(function (response) {
                 console.log(response);
                 $scope.ProductsList = response.data;
             });
     };

    $scope.submitCreateNewProductDto = function () {
        $http.post(contextPath + '/products', $scope.newProductDto)
            .then(function (response) {
                $scope.newProductDto = null;
                $scope.fillTable();
            });
    };

    $scope.deleteProductById = function (id) {
         $http({
             url: contextPath + '/products',
             method: 'DELETE',
             params: {
             id: id
             }
         }).then($scope.fillTable);
    };

    $scope.fillTable();
});