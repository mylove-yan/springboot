package com.emrubik.springboot.springbootshiro;

import com.emrubik.springboot.springbootshiro.bean.Role;
import com.emrubik.springboot.springbootshiro.mapper.RoleMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    private RoleMapper roleMapper;
    @Test
    public void testGetRole(){
        List<Role> roleList = roleMapper.queryByUserId(Integer.valueOf(1));
        Assert.assertEquals(2,roleList.size());
    }
}
