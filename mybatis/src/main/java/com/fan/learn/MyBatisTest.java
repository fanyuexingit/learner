package com.fan.learn;

import com.fan.learn.mapper.TbUserMapper;
import com.fan.learn.model.TbUser;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import sun.nio.cs.Surrogate;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis使用
 * 读取配置的两种方式：xml配置文件 java代码
 *
 */
public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //1、读取xml文件方式
        //由于当前是子模块 所以需要写绝对路径
//        String resource = "/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
        //这样可以不用写绝对路径
        InputStream inputStream = Surrogate.Generator.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2、java代码方式
        getConfiguration();

        try {
            //操作方式1
            TbUserMapper mapper = sqlSession.getMapper(TbUserMapper.class);
            TbUser tbUser = mapper.selectByPrimaryKey(1);

            //操作方式2
//            TbUser tbUser = sqlSession.selectOne("com.fan.learn.mapper.TbUserMapper.selectByPrimaryKey", 1);

            System.out.println(tbUser.getName());
        } finally {
            sqlSession.close();
        }
    }

    public static Configuration getConfiguration(){
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
        pooledDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/database1?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true");
        pooledDataSource.setUsername("root");
        pooledDataSource.setPassword("123456");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, pooledDataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(TbUserMapper.class);
        return configuration;
    }
}
