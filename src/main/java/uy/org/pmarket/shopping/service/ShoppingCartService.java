package uy.org.pmarket.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.org.pmarket.shopping.dto.AudienceDTO;
import uy.org.pmarket.shopping.dto.ShoppingCartDTO;
import uy.org.pmarket.shopping.dto.ShoppingCartPromotionDTO;
import uy.org.pmarket.shopping.dto.ShoppingPromotionItemDTO;
import uy.org.pmarket.shopping.integration.PromotionService;
import uy.org.pmarket.shopping.mapper.ShoppingCartMapper;
import uy.org.pmarket.shopping.model.ShoppingCart;
import uy.org.pmarket.shopping.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartMapper cartMapper;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private PromotionService promotionService;
	
	public ShoppingCartPromotionDTO enterInStore(ShoppingCartDTO dto) {
		ShoppingCart shoppingCart = shoppingCartRepository.save(cartMapper.mapToEntity(dto));
		List<ShoppingPromotionItemDTO> promotions = promotionService.getPromotions(shoppingCart.getItems());
		return new ShoppingCartPromotionDTO(cartMapper.mapToDTO(shoppingCart), promotions);
	}
}
