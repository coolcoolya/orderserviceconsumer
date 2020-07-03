package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 *      1）、导入dubbo依赖、操作zookeeper的客户端curator
 *      2）、配置服务提供者
 *
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserService userService;
    @Override
    public void initOrder(String userId) {
        //1.查询用户的收获地址,需要调用用户服务的接口
        System.out.println("用户id :"+userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        for (UserAddress useraddress:userAddressList) {
            System.out.println(useraddress.getUserAddress());
        }

    }
}
