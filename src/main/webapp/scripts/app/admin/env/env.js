angular.module('jhipsterApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('env', {
                parent: 'admin',
                url: '/env',
                data: {
                    roles: ['ROLE_ADMIN'],
                    pageTitle: 'env.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/admin/env/env.html',
                        controller: 'EnvController'
                    }
                },
                resolve: {
                    mainTranslatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                       // $translatePartialLoader.addPart('env');
                        return $translate.refresh();
                    }]
                }

            });
    });
