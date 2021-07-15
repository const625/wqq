package com.simon.controller;

import com.simon.entity.Product;
import com.simon.entity.Sale;
import com.simon.service.ProductService;
import com.simon.service.SaleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Sale)表控制层
 *
 * @author makejava
 * @since 2021-07-02 10:20:48
 */
@RestController
@RequestMapping("sale")
public class SaleController {
    /**
     * 服务对象
     */
    @Resource
    private SaleService saleService;

    @Resource
    private ProductService productService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sale selectOne(Integer id) {
        return this.saleService.queryById(id);
    }

    @RequestMapping("queryAll")
    public List<Sale> queryAll(Sale sale){
        return this.saleService.queryAll(null);
    }

    @RequestMapping("insert")
    public Sale insert(Sale sale){
        Product product = this.productService.queryById(sale.getPid());
        Double price=product.getPrice();
        if(product.getQuantity()>= sale.getCount()){
            //商品库存数量-count
            product.setQuantity(product.getQuantity()- sale.getCount());
            this.productService.update(product);
            //销售总价=count*商品单价
            Integer count=sale.getCount();
            Double totalprice=count*price;
            //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateHire =new Date();
            Integer uid=sale.getUid();
            Integer pid=sale.getPid();
            Sale sale1=new Sale(count,totalprice,dateHire,uid,pid);
            this.saleService.insert(sale1);
            System.out.println(sale1);

        }else {
            System.out.println(product.getProductname()+"库存不足");
        }
        //System.out.println(sale.getPid()+"--"+sale.getUid()+"--"+sale.getCount());
        return sale;
    }

    @RequestMapping("deleteById")
    public List<Sale> deleteById(Integer sid){
        if(this.saleService.deleteById(sid)==true){
            return this.saleService.queryAll(null);
        }else {
            System.out.println("删除销售记录失败");
            return null;
        }
    }
}