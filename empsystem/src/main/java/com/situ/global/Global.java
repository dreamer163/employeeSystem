package com.situ.global;


import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

public class Global {
    private static DataSource ds;
    public static final String USER_LOGIN_KEY = "#user_login_key";
    static void createDataSource(String driver, String url, String user, String password) {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        try {

            Class<? extends Driver> clazz = (Class<? extends Driver>) Class.forName(driver);
            dataSource.setDriverClass(clazz);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            ds = dataSource;//向上转型
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
