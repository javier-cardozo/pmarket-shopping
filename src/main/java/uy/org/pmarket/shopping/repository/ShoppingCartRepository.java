package uy.org.pmarket.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import uy.org.pmarket.shopping.model.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
    
}
