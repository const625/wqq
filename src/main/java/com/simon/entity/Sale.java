package com.simon.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Sale)实体类
 *
 * @author makejava
 * @since 2021-07-02 10:20:48
 */
public class Sale implements Serializable {
    private static final long serialVersionUID = -41317991832658288L;
    
    private Integer sid;
    
    private Integer count;
    
    private Double totalprice;
    
    private Date saledate;
    
    private Integer uid;
    
    private Integer pid;

    public Sale() {
    }

    public Sale(Integer count, Double totalprice, Date saledate, Integer uid, Integer pid) {
        this.count = count;
        this.totalprice = totalprice;
        this.saledate = saledate;
        this.uid = uid;
        this.pid = pid;
    }

    public Sale(Integer sid, Integer count, Double totalprice, Date saledate, Integer uid, Integer pid) {
        this.sid = sid;
        this.count = count;
        this.totalprice = totalprice;
        this.saledate = saledate;
        this.uid = uid;
        this.pid = pid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Date getSaledate() {
        return saledate;
    }

    public void setSaledate(Date saledate) {
        this.saledate = saledate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "sid=" + sid +
                ", count=" + count +
                ", totalprice=" + totalprice +
                ", saledate=" + saledate +
                ", uid=" + uid +
                ", pid=" + pid +
                '}';
    }
}