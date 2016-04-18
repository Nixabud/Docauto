package com.sysview.docauto;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;

//@Configuration
public class OracleConfiguration {

//    @Bean
    DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL("jdbc:oracle:thin:@//localhost:1521/orcl");
        dataSource.setUser("dapresentaciones12");
        dataSource.setPassword("sysview12");
        return dataSource;
    }
}
