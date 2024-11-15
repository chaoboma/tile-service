package com.application.service;

import com.application.domain.dao.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @program: UserService
 * @author:
 * @create: 2023-06-29 14:01
 **/
public interface UserService extends IService<User>{
    User findUserById(Integer userId);
}
