package com.neko.elasticsearch.searchyourwaifu.elasticsearch.client;


import com.neko.elasticsearch.searchyourwaifu.config.ElasticSearchConfig;
import com.neko.elasticsearch.searchyourwaifu.config.RestTemplateConfig;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchClient {

    private final ElasticSearchConfig elasticSearchConfig;
    private final RestTemplateConfig restTemplateConfig;

    public ElasticSearchClient(ElasticSearchConfig elasticSearchConfig, RestTemplateConfig restTemplateConfig) {
        this.elasticSearchConfig = elasticSearchConfig;
        this.restTemplateConfig = restTemplateConfig;
    }

    public ResponseEntity<String> findByTitleNgram(String query) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBasicAuth(elasticSearchConfig.getUsername(), elasticSearchConfig.getPassword());

        HttpEntity<String> httpEntity = new HttpEntity<>(query, httpHeaders);
        return restTemplateConfig.restTemplate().exchange("http://localhost:9200/voxify_user/_search", HttpMethod.POST, httpEntity, String.class);
    }
}
