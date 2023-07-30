package com.neko.elasticsearch.searchyourwaifu.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


@SpringBootTest
public class ElasticSearchClient {


    @Autowired
    com.neko.elasticsearch.searchyourwaifu.elasticsearch.client.ElasticSearchClient elasticSearchClient;

    @Test
    public void testGetNgramClient() {
        String query = "{\n" +
                " \"query\": {\n" +
                "   \"match\": {\n" +
                "    \"full_name\":{\n" +
                "    \"query\": \"ffu cha\",\n" +
                "    \"fuzziness\": \"AUTO\"\n" +
                "   }\n" +
                "  }\n" +
                " }\n" +
                "}";
        ResponseEntity<String> response = elasticSearchClient.findByTitleNgram(query);
        System.out.println(response.getBody());

    }
}
