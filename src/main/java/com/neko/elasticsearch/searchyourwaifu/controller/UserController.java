package com.neko.elasticsearch.searchyourwaifu.controller;

import com.neko.elasticsearch.searchyourwaifu.elasticsearch.client.ElasticSearchClient;
import com.neko.elasticsearch.searchyourwaifu.elasticsearch.query.ElasticSearchQuery;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user/_search")
public class UserController {

    private final ElasticSearchClient elasticSearchClient;

    private final ElasticSearchQuery elasticSearchQuery;

    public UserController(ElasticSearchClient elasticSearchClient, ElasticSearchQuery elasticSearchQuery) {
        this.elasticSearchClient = elasticSearchClient;
        this.elasticSearchQuery = elasticSearchQuery;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findByTitle(@RequestParam("query") String query) {
        return elasticSearchClient.findByTitleNgram(
                elasticSearchQuery.fuzzyQueryNGram(query));
    }
}
