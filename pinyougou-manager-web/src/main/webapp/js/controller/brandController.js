 //商品列表 控制层
 app.controller('brandController', function ($scope, $http,brandService) {
     //查询品牌列表
     $scope.findAll = function () {
         $brandService.findAll().success(function (response) {
             $scope.list = response;
         });
     };

     //angularjs 分页控制
     $scope.paginationConf = {
         currentPage: 1,
         totalItems: 10,
         itemsPerPage: 10,
         perPageOptions: [10, 20, 30, 40, 50],
         onChange: function () {
             $scope.reloadList();
         }
     }

     $scope.reloadList = function () {
         $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
     };

     $scope.findPage = function (pageNum, pageSize) {
         $scope.findPage(pageNum, pageSize).success(
             function (response) {
                 $scope.list = response.rows;
                 $scope.paginationConf.totalItems = response.total;
             }
         );
     }

     //新增 品牌类型
     $scope.save = function () {
         var object=null;
         if($scope.entity.id!=null){
             object = brandService.update($scope.entity);
         }else {
             object =  brandService.add($scope.entity);
         }
         object.success(
             function (reponse) {
                 console.log(reponse);
                 if (reponse.success) {
                     $scope.reloadList();
                 } else {
                     alert(reponse.message)
                 }
             });
     }

     //查询实体
     $scope.findOne=function(id){
         brandService.findOne().success(
             function (response) {
                 $scope.entity=response;
             });
     }


     //用户勾选的删除集合;
     $scope.selectIds = [];
     //用户勾选的复选框
     $scope.updateSelection = function ($event, id) {
         var check = $event.target.checked;
         if (check) {
             $scope.selectIds.push(id);
         } else {
             var index = $scope.selectIds.indexOf(id);
             if (index >= 0) {
                 $scope.selectIds.splice(index, 1);
             }
         }
     }

     //删除
     $scope.del = function () {
         brandService.delete($scope.selectIds).success(
             function (response) {
                 if (response.success) {
                     $scope.reloadList();
                 } else {
                     alert(response.message);
                 }
                 $scope.selectIds= [];
             }
         )
     }

     $scope.searchEntity={};
     //条件查询
     $scope.search=function(pageNum,pageSize){
         brandService.search(pageNum,pageSize,$scope.searchEntity).success(
             function(response){
                 $scope.list=response.rows;//显示当前页数据
                 $scope.paginationConf.totalItems=response.total;//更新总记录数
             }
         );
     }
 });