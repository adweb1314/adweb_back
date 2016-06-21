angular.module('app.controller', [])

  .controller('PlaceCtrl', function($scope, $http, $ionicPopup) {
    $scope.noResult=false;
    $scope.hasResult=false;
    $scope.loading=false;
    $scope.searchPlace=function() {
      var queryText=$("#place-input").attr("value");
      $scope.noResult=false;
      $scope.hasResult=false;
      $scope.loading=true;
      $http.get("http://localhost:8080/place/"+queryText)
        .success(function(ret) {
          $scope.loading=false;
          $scope.ret=ret;
          if (ret.result.length<1){
            $scope.noResult=true;
            $scope.hasResult=false;
          }else{
            $scope.noResult=false;
            $scope.hasResult=true;

          }
        })
        .error(function(){
          $scope.loading=false;
          $ionicPopup.alert({
            title: '系统提示',
            template: '搜索失败，因网络原因无法搜索'
          });
        });
    };
  })

  .controller('MapCtrl', function($scope, $stateParams, $http, $ionicPopup) {

    var lati,longi,zoom;
    $scope.loading=true;

    var getMap=function(){
      $scope.loading=true;
      $http.get("http://localhost:8080/map/"+lati+"/"+longi+"/"+zoom)
        .success(function(ret) {
          $scope.loading=false;
          if (ret!=null) {
            $scope.realPath = "http://localhost:8080/"+ret.fileName;
          } else {
            $scope.realPath = "";
            $ionicPopup.alert({
              title: '系统提示',
              template: '因网络原因无法取得地图'
            });
            $ionicHistory.goBack();
          }
        })
        .error(function(){
          $scope.loading=false;
          $ionicPopup.alert({
            title: '系统提示',
            template: '因网络原因无法取得地图'
          });
          $ionicHistory.goBack();
        });
    };

    $scope.toNorth=function(){
      lati=Number(lati)+0.000003*((30-zoom)*(30-zoom)*(30-zoom));
      getMap();
    };
    $scope.toSouth=function(){
      lati=Number(lati)-0.000003*((30-zoom)*(30-zoom)*(30-zoom));
      getMap();
    };
    $scope.toWest=function(){
      longi=Number(longi)-0.000003*((30-zoom)*(30-zoom)*(30-zoom));
      getMap();
    };
    $scope.toEast=function(){
      longi=Number(longi)+0.000003*((30-zoom)*(30-zoom)*(30-zoom));
      getMap();
    };
    $scope.toBig=function(){
      zoom=Number(zoom)+1;
      if (Number(zoom)>16){
        zoom=Number(zoom)-1;
        $ionicPopup.alert({
          title: '系统提示',
          template: '无法显示更大地图'
        });
      }else {
        getMap();
      }
    };
    $scope.toSmall=function(){
      zoom=Number(zoom)-1;
      if (Number(zoom)<13){
        zoom=Number(zoom)+1;
        $ionicPopup.alert({
          title: '系统提示',
          template: '无法显示更小地图'
        });
      }else {
        getMap();
      }
    };

    lati=$stateParams.latitude;
    longi=$stateParams.longitude;
    zoom=$stateParams.zoom;
    getMap();

  });
