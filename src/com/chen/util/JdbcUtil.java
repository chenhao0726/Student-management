package com.chen.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class JdbcUtil {
    private static SqlSessionFactory factory = null;

    // 读取配置文件
    static {
        String config = "mybatis-config.xml";
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(config));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Session并返回Session
     * @return
     */
    public static SqlSession getSession() {
        if (factory == null) {
            throw new RuntimeException("SqlSessionFactory创建失败");
        }
        return factory.openSession();
    }
}
