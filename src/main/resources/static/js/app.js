angular.module('app', ['ionic','app.controller'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);

    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleDefault();
    }
  });
})

.config(function($stateProvider, $urlRouterProvider, $ionicConfigProvider) {

  // 解决 Android tab 样式问题
  $ionicConfigProvider.tabs.position('bottom'); // Tab位置
  $ionicConfigProvider.navBar.alignTitle('center'); // 标题位置

  // 定义页面及states
  $stateProvider
    .state('place', {
      url: '/place',
      //cache:'false',
      templateUrl: 'templates/place.html',
      controller: 'PlaceCtrl'
    })
    .state('map', {
      url: '/map/:latitude/:longitude/:zoom',
      cache:'false',
      templateUrl: 'templates/map.html',
      controller: 'MapCtrl'
    });

  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/place');

})
