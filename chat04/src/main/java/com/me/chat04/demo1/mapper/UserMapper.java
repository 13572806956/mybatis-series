package com.me.chat04.demo1.mapper;

import com.me.chat04.demo1.model.UserModel;

/**
 * @author ME
 * @create 2022-08-02 20:22
 */
public interface UserMapper {
    /**
     * 插入用户信息，返回影响行数
     *
     * @param model
     * @return
     */
    int insertUser(UserModel model);

    /**
     * 更新用户信息，返回影响行数
     *
     * @param model
     * @return
     */
    long updateUser(UserModel model);

    /**
     * 根据用户id删除用户信息，返回删除是否成功
     *
     * @param userId
     * @return
     */
    boolean deleteUser(Long userId);

    int insertUser1(UserModel userModel);

    int insertUser2(UserModel userModel);
}
