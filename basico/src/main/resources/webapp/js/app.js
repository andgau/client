var app = angular.module("app", ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {

    $routeProvider.when('/login', {
        templateUrl: "pages/login.html",
        controller: "LoginController"
    });

    $routeProvider.when('/application', {
        templateUrl: "pages/application.html",
        controller: "ApplicationController"
    });

    $routeProvider.when('/upload-version', {
        templateUrl: "pages/upload-version.html",
        controller: "UploadVersionController"
    });

    $routeProvider.when('/devices', {
        templateUrl: "pages/devices.html",
        controller: "DevicesController"
    });

    $routeProvider.when('/show-logs', {
        templateUrl: "pages/show-logs.html",
        controller: "ShowLogsController"
    });

    $routeProvider.when('/routes', {
        templateUrl: "pages/routes.html",
        controller: "RoutesController"
    });

    $routeProvider.otherwise({
        redirectTo: '/404'
    });

}]);

app.controller("LoginController", ["$scope", "$log", function($scope, $log) {
    $scope.mensaje = "Texto cargado desde el controlador LoginController";
}]);

app.controller("ApplicationController", ["$scope", "$log", "$http", function($scope, $log, $http) {
    // Obtener version actual
    $http.jsonp(
        'http://localhost:8080/pikolin/api/pml/application/currentVersion?callback=JSON_CALLBACK'
    ).success(function(data, status, headers, config) {
        $scope.currentVersion = data;
    }).error(function(data, status, headers, config) {
        alert("Ha fallado la petición. Estado HTTP: " + status);
    });


    // Obtener listado de versiones
    $http.jsonp(
        'http://localhost:8080/pikolin/api/pml/application/versions?callback=JSON_CALLBACK'
    ).success(function(data, status, headers, config) {
        $scope.versions = data;
    }).error(function(data, status, headers, config) {
        alert("Ha fallado la petición. Estado HTTP: " + status);
    });

    $scope.showVersionDetail = function(version) {
        $scope.versionDetail = $scope.versions[version];
        $('#modalVersionDetail').modal();
    }

}]);

app.controller("UploadVersionController", ["$scope", function($scope) {
    $scope.mensaje = "Texto cargado desde el controlador UploadVersionController";
}]);

app.controller("DevicesController", ["$scope", function($scope) {
    $scope.mensaje = "Texto cargado desde el controlador DevicesController";
}]);

app.controller("ShowLogsController", ["$scope", function($scope) {
    $scope.mensaje = "Texto cargado desde el controlador ShowLogsController";
}]);

app.controller("RoutesController", ["$scope", function($scope) {
    $scope.mensaje = "Texto cargado desde el controlador Pagina3Controller";
}]);
