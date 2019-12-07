package uy.org.pmarket.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uy.org.pmarket.shopping.model.ShoppingAudience;

public interface ShoppingAudienceRepository extends MongoRepository<ShoppingAudience, String> {
 
	@Query("{'audience.name': ?0}")
	ShoppingAudience findByAudienceName(final String name);
}
