package org.sunny.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class JdbcConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(this.url);
        ds.setUser(this.user);
        ds.setPassword(this.password);
        return ds;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource ds) {
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        dstm.setDataSource(ds);
        return dstm;
    }
}
