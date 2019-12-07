package uy.org.pmarket.shopping.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig {
    
	@Value("${mongo.host}")
    String host;
    @Value("${mongo.port}")
    int port;
    @Value("${mongo.database}")
    String databaseName;

    @Bean
    public MongoClient mongo() throws Exception {
        return new MongoClient(new ServerAddress(host, port),
                MongoClientOptions.builder()
                        .maxConnectionIdleTime(60*1000)
                        .maxConnectionLifeTime(60*1000)
                        .build());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), databaseName);
    }
    

}
