package com.yhh.springcloud.service.impl;

import java.util.List;

import com.yhh.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhh.springcloud.dao.DeptDao;
import com.yhh.springcloud.entities.Dept;
import com.yhh.springcloud.service.DeptService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 直接在这里加上 @RestController 当controller用
 * ps:
 * 1. 方法的 @RequestMapping可以不用加了， 但是 方法参数的注解 @PathVariable("id") 必须加上，否则参数映射不进来。
 * 2. 我这里打个断点 稍微延时一点， consumer工程就timeout了,应该可以配置超时时间。
 */
@RestController
//@Service
public class DeptServiceImpl
        implements DeptClientService {
        //implements DeptService {


    @Autowired
    private DeptDao dao;

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(@PathVariable("id") Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }

}
