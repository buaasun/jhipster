'use strict';

angular.module('jhipsterApp')
    .controller('EnvController', function ($scope, MonitoringService) {

                    $scope.refresh = function () {
                        MonitoringService.getEnv().then(function (data){

                            $scope.envs=data;
                            angular.forEach(data, function (value, key){

                            });

                        })
                    };

                    $scope.refresh();
                });
