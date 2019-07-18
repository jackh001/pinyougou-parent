//服务层
app.service('sellerService', function ($http) {


    //读取列表数据绑定到表单中
    this.findAll = function () {
        return $http.get('../seller/findAll.do');
    }
    //分页
    this.findPage = function (page, rows) {
        return $http.get('../seller/findPage.do?page=' + page + '&rows=' + rows);
    }
    //查询实体
    this.findOne = function (id) {
        // var url = '../seller/findOne.do',
        //     data = {
        //         'id': id
        //     }
        // transFn = function (data) {
        //    return $.param(data);
        // }
        //
        // getCfg={
        //     headers:{'Context-Type':'application/x-www-form-urllencoded;charset=UTF-8'},
        //     transformRequest:transFn
        // }


        // return $http.get(url,data,getCfg);
        // return $http.get('../seller/findOne.do?id=' + id);
        return $http.get('../seller/findOne.do?id=' + encodeURI(encodeURI(id)));
        // return $http({
        //     method:'GET',
        //     url:'../seller/findOne.do',
        //     params:id,
        //     headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
        // });
    }
    //增加
    this.add = function (entity) {
        return $http.post('../seller/add.do', entity);
    }
    //修改
    this.update = function (entity) {
        return $http.post('../seller/update.do', entity);
    }
    //删除
    this.dele = function (ids) {
        return $http.get('../seller/delete.do?ids=' + ids);
    }
    //搜索
    this.search = function (page, rows, searchEntity) {
        return $http.post('../seller/search.do?page=' + page + "&rows=" + rows, searchEntity);
    }

    this.updateStatus=function (sellerId,status) {
        return $http.get('../seller/updateStatus.do?sellerId='+encodeURI(encodeURI(sellerId))+'&status='+status);
    }
});
