/**
 * @description:
 * @author: Andy
 * @time: 2020/12/09 16:01
 */
package com.fan.learn;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import sun.nio.cs.Surrogate;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mybatis.generator.config.ModelType.FLAT;

/**
 * Created by fanyuexin on 2020/12/09
 */
public class Generator {

    public static void main(String[] args) throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {
        generateCodeWithXmlFile();
    }
    //使用 generatorConfig.xml 文件
    public static void generateCodeWithXmlFile() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //需要写绝对路径
//        File configFile = new File("D:\\workspace_learn\\learner\\mybatis-generator\\src\\main\\resources\\generatorConfig.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);

        //不用写绝对路径了
        InputStream inputStream = Surrogate.Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(inputStream);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    //不使用 generatorConfig.xml 文件    纯java
    public static void generateCodeWithoutXmlFile() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = new Configuration();
        config.addClasspathEntry("D:\\repository\\mysql\\mysql-connector-java\\8.0.11\\mysql-connector-java-8.0.11.jar");
        Context context = new Context(FLAT);
        context.setId("simple");
        context.setTargetRuntime("MyBatis3Simple");
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://127.0.0.1/database1?serverTimezone=UTC");
        jdbcConnectionConfiguration.setDriverClass("com.mysql.cj.jdbc.Driver");
        jdbcConnectionConfiguration.setUserId("root");
        jdbcConnectionConfiguration.setPassword("123456");
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage("example.model");
        javaModelGeneratorConfiguration.setTargetProject("src/main/java");
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetPackage("example.mapper");
        javaClientGeneratorConfiguration.setTargetProject("src/main/java");
        //生成xml式还是annotation式
        javaClientGeneratorConfiguration.setConfigurationType("ANNOTATEDMAPPER");
        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName("tb_user");
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
        context.addTableConfiguration(tableConfiguration);
        config.addContext(context);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
