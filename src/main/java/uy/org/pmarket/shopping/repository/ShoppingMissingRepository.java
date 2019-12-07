package uy.org.pmarket.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import uy.org.pmarket.shopping.model.ShoppingMissing;

public interface ShoppingMissingRepository extends MongoRepository<ShoppingMissing, String> {
	
}
