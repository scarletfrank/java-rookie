angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:3000/greetings').
        then(function(response) {
            var inx = Math.floor(Math.random() * 10);
            var greet = response.data[inx]
            $scope.greeting = greet;
        });
});