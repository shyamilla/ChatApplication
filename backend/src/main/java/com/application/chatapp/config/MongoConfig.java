package com.application.chatapp.config;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    // @Value("${spring.data.mongodb.database}")
    // private String databaseName;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoDatabase mongoDatabase(MongoClient client) {
        return client.getDatabase("chatapp");
    }

    @Bean
    public GridFSBucket gridFSBucket(MongoDatabase database) {
        return GridFSBuckets.create(database, "attachments");
    }
}
