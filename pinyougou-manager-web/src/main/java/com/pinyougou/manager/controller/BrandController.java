package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        System.out.println("-------------");
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int pageNum,int pageSize){
       return brandService.findPage(pageNum,pageSize);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return  new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result(false,"增加失败");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        System.out.println("controller----ids = "+ids);
        try {
            brandService.delete(ids);
            return  new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result(false,"删除失败");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand,int pageNum,int pageSize){
        return brandService.findPage(brand,pageNum,pageSize);
    }
}
