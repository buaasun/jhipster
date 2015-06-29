'use strict';

angular.module('jhipsterApp')
    .controller('NavbarController', function ($scope, $location, $state, Auth, Principal) {
        $scope.isAuthenticated = Principal.isAuthenticated;
        $scope.$state = $state;
        console.log($state);
        $scope.logout = function () {
            Auth.logout();
            $state.go('home');
        };
    });
