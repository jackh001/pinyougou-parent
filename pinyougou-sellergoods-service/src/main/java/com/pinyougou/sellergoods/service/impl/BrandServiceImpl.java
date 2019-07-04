package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
    * @Description: 查询所有的商品名称
    * @params      * @param null
    * @return
    * @exception
    * @date        2019/7/3 17:10
    */
    @Override
    public List<TbBrand> findAll() {
        final List<TbBrand> tbBrands = tbBrandMapper.selectByExample(null);
        return tbBrands;
    }

    /**
    * @Description:分页查询
    * @params      * @param null
    * @return
    * @exception
    * @date        2019/7/3 17:11
    */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        final Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
    * @Description: 带条件的分页查询
    * @params      * @param null
    * @return      
    * @exception   
    * @date        2019/7/3 17:10
    */
    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);//分页

        TbBrandExample example=new TbBrandExample();

        final TbBrandExample.Criteria criteria = example.createCriteria();
        if(brand!=null){
            if(brand.getName()!=null && brand.getName().length()>0){
                System.out.println("brand.getName() = "+brand.getName());
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
                System.out.println("brand.getFirstChar() = "+brand.getFirstChar());
                criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
            }
        }

        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
    * @Description: 添加商品名称
    * @params      * @param null
    * @return
    * @exception
    * @date        2019/7/3 17:11
    */
    @Override
    public void add(TbBrand brand) {
        tbBrandMapper.insert(brand);
    }


    /**
    * @Description:删除商品名称
    * @params
    * @return
    * @exception
    * @date        2019/7/3 17:11
    */
    @Override
    public void delete(Long[] ids) {
        System.out.println("impl----ids = " + ids);
        for (long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }


    @Override
    public void update(TbBrand brand) {
        tbBrandMapper.updateByPrimaryKey(brand);
    }



}
