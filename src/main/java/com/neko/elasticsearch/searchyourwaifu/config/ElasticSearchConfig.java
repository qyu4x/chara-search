package com.neko.elasticsearch.searchyourwaifu.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class ElasticSearchConfig {

    @Value("${elastic.username}")
    private String username;

    @Value("${elastic.password}")
    private String password;

}
