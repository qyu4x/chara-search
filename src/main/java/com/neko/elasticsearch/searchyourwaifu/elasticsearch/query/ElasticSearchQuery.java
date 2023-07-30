package com.neko.elasticsearch.searchyourwaifu.elasticsearch.query;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchQuery {

    public String fuzzyQueryNGram(String query) {
        return String.format("{\n" +
                " \"query\": {\n" +
                "   \"match\": {\n" +
                "    \"full_name\":{\n" +
                "    \"query\": \"%s\",\n" +
                "    \"fuzziness\": \"AUTO\"\n" +
                "   }\n" +
                "  }\n" +
                " }\n" +
                "}", query);
    }

}
