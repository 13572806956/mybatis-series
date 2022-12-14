package com.me.chat02;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class UserTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void sqlSession(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        log.info("{}", sqlSession);
    }

    @Test
    public void insertUser(){
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession(false);) {
            //创建UserModel对象
            UserModel userModel = UserModel.builder().name("javacode2018").age(30).salary(50000D).sex(1).build();
            //执行插入操作
            int result = sqlSession.insert("com.me.chat02.UserMapper.insertUser", userModel);
            log.info("插入影响行数：{}", result);
            //提交事务
            sqlSession.commit();
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            //创建UserModel对象
            UserModel userModel = UserModel.builder().id(2L).name("路人甲Java，你好").age(18).salary(5000D).sex(0).build();
            //执行更新操作
            int result = sqlSession.update("com.me.chat02.UserMapper.updateUser", userModel);
            log.info("影响行数：{}", result);
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            //定义需要删除的用户id
            Long userId = 2L;
            //执行删除操作
            int result = sqlSession.delete("com.me.chat02.UserMapper.deleteUser", userId);
            log.info("影响行数：{}", result);
        }
    }

    @Test
    public void getUserList() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            //执行查询操作
            List<UserModel> userModelList = sqlSession.selectList("com.me.chat02.UserMapper.getUserList");
            log.info("结果：{}", userModelList);
        }
    }
}
