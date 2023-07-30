package com.neko.elasticsearch.searchyourwaifu.elasticsearch.query;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchQuery {

    public String fuzzyQueryNGram(String query) {
        return String.format("{\n" +
                "    \"query\" : {\n" +
                "        \"bool\" : {\n" +
                "            \"must\" : {\n" +
                "                \"wildcard\" : {\n" +
                "                   \"full_name\" : {\n" +
                "                       \"value\" : \"*%s*\"\n" +
                "                   }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}", query);
    }

}
