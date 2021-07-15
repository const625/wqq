package com.simon.controller;

import com.simon.entity.Users;
import com.simon.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2021-07-01 13:59:51
 */
@RestController
@RequestMapping("users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public Users selectOne(Integer id) {
        return this.usersService.queryById(id);
    }

    @RequestMapping("queryByUP")
    public String queryByUP(String userName, String password) {
        if(this.usersService.queryByUP(userName,password)!=null){
            return "success";
        }else {
            return "fail";
        }
    }
}