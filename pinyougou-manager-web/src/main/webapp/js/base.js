var app = angular.module('pinyougou');

app.filter('encodeUrl',function () {
    return $window.encodeURIComponment;
});

app.filter('escape',function () {
    return window.escape;
});
