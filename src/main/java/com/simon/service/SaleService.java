package com.simon.service;

import com.simon.entity.Sale;
import java.util.List;

/**
 * (Sale)表服务接口
 *
 * @author makejava
 * @since 2021-07-02 10:20:48
 */
public interface SaleService {

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    Sale queryById(Integer sid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Sale> queryAllByLimit(int offset, int limit);

    List<Sale> queryAll(Sale sale);

    /**
     * 新增数据
     *
     * @param sale 实例对象
     * @return 实例对象
     */
    Sale insert(Sale sale);

    /**
     * 修改数据
     *
     * @param sale 实例对象
     * @return 实例对象
     */
    Sale update(Sale sale);

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sid);



}