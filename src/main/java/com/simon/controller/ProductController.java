package com.simon.controller;

import com.simon.entity.Product;
import com.simon.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2021-07-02 10:20:08
 */
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Product selectOne(Integer id) {
        return this.productService.queryById(id);
    }

    /*查询所有的产品*/
    @RequestMapping("queryAll")
    public List<Product> queryAll(Product product){
        if(product.getProductname()!=""){
            return this.productService.queryAll(product);
        }else {
            return this.productService.queryAll(null);
        }

    }

    //根据pname查询相关产品--暂时弃用
    @RequestMapping("queryByPname")
    public List<Product> queryByPname(String productname){
        System.out.println("-----------------"+productname);
        return this.productService.queryByPname(productname);
    }

    @RequestMapping("deleteById")
    public List<Product> deleteById(Integer pid){
        if(this.productService.deleteById(pid)==true){
            return this.productService.queryAll(null);
        }else {
            System.out.println("删除商品失败");
            return null;
        }
    }

    @RequestMapping("queryById")
    public Product queryById(Integer pid){
        return this.productService.queryById(pid);
    }

    @RequestMapping("update")
    public Product update(Product product){
        return this.productService.update(product);
    }

    @RequestMapping("insert")
    public Product insert(Product product){
        return this.productService.insert(product);
    }
}