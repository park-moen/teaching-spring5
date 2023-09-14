package com.teachingspring5.config;

import com.teachingspring5.spring.*;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class AppContext {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/spring5fs?CharacterEncoding=utf8mb");
        dataSource.setUsername("spring5");
        dataSource.setPassword("00000000");
        dataSource.setInitialSize(2);
        dataSource.setTestWhileIdle(true);
        dataSource.setMinEvictableIdleTimeMillis(60000 * 3);
        dataSource.setTimeBetweenEvictionRunsMillis(10 * 1000);

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());

        return transactionManager;
    }


    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService changePasswordServiceInstance = new ChangePasswordService();
        changePasswordServiceInstance.setMemberDao(memberDao());

        return changePasswordServiceInstance;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter memberListPrinter() {
        return new MemberListPrinter(memberDao(), memberPrinter());
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter() {
        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();

        memberInfoPrinter.setMemberDao(memberDao());
        memberInfoPrinter.setPrinter(memberPrinter());

        return memberInfoPrinter;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMajorVersion(0);

        return versionPrinter;
    }
}
