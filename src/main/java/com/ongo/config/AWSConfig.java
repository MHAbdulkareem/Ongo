package com.ongo.config;

import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.cloud.aws.jdbc.config.annotation.RdsInstanceConfigurer;
import org.springframework.cloud.aws.jdbc.datasource.TomcatJdbcDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
@EnableRdsInstance(
        dbInstanceIdentifier = "aa81q0orj9dm23",
        password = "OnTheGo247", username = "ongoukgo")
public class AWSConfig {

    @Bean
    public RdsInstanceConfigurer instanceConfigurer() {
        return () -> {
            TomcatJdbcDataSourceFactory dataSourceFactory
                    = new TomcatJdbcDataSourceFactory();
            dataSourceFactory.setInitialSize(10);
            dataSourceFactory.setValidationQuery("SELECT 1");
            return dataSourceFactory;
        };
    }

}
