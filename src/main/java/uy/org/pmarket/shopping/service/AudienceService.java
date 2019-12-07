package uy.org.pmarket.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.org.pmarket.shopping.model.ShoppingAudience;
import uy.org.pmarket.shopping.model.ShoppingMissing;
import uy.org.pmarket.shopping.repository.ShoppingAudienceRepository;

@Service
public class AudienceService {
	
	@Autowired
	private ShoppingAudienceRepository audienceRepository;
	
	public void saveAudienceShoppingMissing(ShoppingMissing shopping) {
		ShoppingAudience entity = getShoppingAudience(shopping.getAudience().getName());
		if (entity == null) {
			entity = new ShoppingAudience();
			entity.setAudience(shopping.getAudience());	
		}
		
		entity.add(shopping.getId());
		audienceRepository.save(entity);
	}
	
	public ShoppingAudience getShoppingAudience(String user) {
		 return audienceRepository.findByAudienceName(user);
	}
}
