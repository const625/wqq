package com.simon.dao;

import com.simon.entity.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-01 13:59:50
 */
public interface UsersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    Users queryById(Integer uid);

    /*通过用户名密码查询用户*/
    Users queryByUP(@Param("userName") String userName,@Param("password") String password);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Users> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param users 实例对象
     * @return 对象列表
     */
    List<Users> queryAll(Users users);

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 影响行数
     */
    int deleteById(Integer uid);

}