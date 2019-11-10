angular.module("Search", []).controller("SearchCtrl", function ($scope, $http) {

    console.log("Search controller");

    $scope.clearSearchField = function() {
        console.log("Clear");
        console.log($scope.searchField);
        _clearFormData();
    };

    $scope.findAll = function() {
        console.log("Find all");
        $http.get('http://localhost:8090/api/search').then(_success, _error);
    };

    $scope.search = function() {
        console.log("Search: "+$scope.searchField);
        $http.get('http://localhost:8090/api/search/product/'+$scope.searchField).then(_success, _error);
    };

    function _refreshSearchResults(res) {
        $scope.results = res.data;
    }

    function _success(res) {
        _refreshSearchResults(res);
    }

    function _error(res) {
        console.log("Error: "+res);
        var data = res.data;
        var status = res.status;
        alert("Error: " + status + ":" + data);
    }

    function _clearFormData() {
        $scope.searchField = "";
        $scope.results = [];
    }
});