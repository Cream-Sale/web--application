var app = angular.module("Search", []);

app.controller("SearchCtrl", function ($scope, $http) {

    $scope.results = [];

    $http.get('http://localhost:8090/api/search').then(function(response) {
            $scope.results = response.data;
        });
})