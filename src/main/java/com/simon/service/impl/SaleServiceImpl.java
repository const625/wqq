package com.simon.service.impl;

import com.simon.entity.Sale;
import com.simon.dao.SaleDao;
import com.simon.service.SaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sale)表服务实现类
 *
 * @author makejava
 * @since 2021-07-02 10:20:48
 */
@Service("saleService")
public class SaleServiceImpl implements SaleService {
    @Resource
    private SaleDao saleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    @Override
    public Sale queryById(Integer sid) {
        return this.saleDao.queryById(sid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Sale> queryAllByLimit(int offset, int limit) {
        return this.saleDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Sale> queryAll(Sale sale) {
        return this.saleDao.queryAll(sale);
    }

    /**
     * 新增数据
     *
     * @param sale 实例对象
     * @return 实例对象
     */
    @Override
    public Sale insert(Sale sale) {
        this.saleDao.insert(sale);
        return sale;
    }

    /**
     * 修改数据
     *
     * @param sale 实例对象
     * @return 实例对象
     */
    @Override
    public Sale update(Sale sale) {
        this.saleDao.update(sale);
        return this.queryById(sale.getSid());
    }

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sid) {
        return this.saleDao.deleteById(sid) > 0;
    }
}