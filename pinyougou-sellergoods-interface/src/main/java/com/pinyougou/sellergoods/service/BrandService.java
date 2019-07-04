package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;
import entity.Result;
import java.util.List;

public interface BrandService {

    /**
    * @Description: 查询所欲的品牌数据
    * @params      * @param null
    * @return
    * @exception
    * @date        2019/7/3 9:48
    */
    public List<TbBrand> findAll();

    /**
     * @Description: 分页查询
     * @params      * pageNum 当前页数 pageSize 页码大小
     * @return
     * @exception
     * @date        2019/7/3 9:47
     */
    public PageResult findPage(int pageNum,int pageSize);


    /**
     * @Description: 分页查询
     * @params      * pageNum 当前页数 pageSize 页码大小
     * @return
     * @exception
     * @date        2019/7/3 9:47
     */
    public PageResult findPage(TbBrand brand,int pageNum,int pageSize);



    /**
    * @Description: 增加品牌列表
    * @params      * @param null
    * @return      
    * @exception   
    * @date        2019/7/3 10:54
    */
    public void add(TbBrand brand);

    /**
    * @Description: 批量删除品牌
    * @params      * @param null
    * @return
    * @exception
    * @date        2019/7/3 14:17
    */
    public void delete(Long[] ids);

    /**
    * @Description: 查询品牌
    * @params      * @param null
    * @return
    * @exception
    * @date        2019/7/4 23:32
    */
    public TbBrand findOne(Long id);

    /**
    * @Description: 更新品牌
    * @params      * @param null
    * @return
    * @exception
    * @date        2019/7/4 23:32
    */
    public void update(TbBrand brand);





}
