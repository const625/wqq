package com.simon.test;

import com.simon.entity.Users;
import com.simon.service.UsersService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class testDao {
    @Autowired
    private UsersService usersService;

    @Test
    public void testQueryByUP(){
        Users user = usersService.queryByUP("张三", "1234567");
        System.out.println(user);
    }
}
