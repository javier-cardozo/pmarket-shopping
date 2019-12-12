package uy.org.pmarket.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.org.pmarket.shopping.dto.AudienceDTO;
import uy.org.pmarket.shopping.dto.ShoppingCartDTO;
import uy.org.pmarket.shopping.dto.ShoppingCartPromotionDTO;
import uy.org.pmarket.shopping.dto.ShoppingItemDTO;
import uy.org.pmarket.shopping.dto.ShoppingMissingDTO;
import uy.org.pmarket.shopping.dto.ShoppingPromotionItemDTO;
import uy.org.pmarket.shopping.integration.ProductService;
import uy.org.pmarket.shopping.integration.PromotionService;
import uy.org.pmarket.shopping.mapper.ShoppingCartMapper;
import uy.org.pmarket.shopping.mapper.ShoppingItemMapper;
import uy.org.pmarket.shopping.model.ShoppingCart;
import uy.org.pmarket.shopping.model.ShoppingItem;
import uy.org.pmarket.shopping.model.ShoppingMissing;
import uy.org.pmarket.shopping.repository.ShoppingCartRepository;
import uy.org.pmarket.shopping.repository.ShoppingMissingRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartMapper cartMapper;
	@Autowired
	private ShoppingItemMapper itemMapper;
	@Autowired
	private ShoppingMissingRepository shoppingMissingRepository;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private PromotionService promotionService;
	@Autowired
	private ProductService productService;
	
	public ShoppingCartPromotionDTO enterInStore(ShoppingMissingDTO dto, String chain, String store) {
		ShoppingCartDTO cartDTO = convert(dto, chain, store);
		ShoppingCart shoppingCart = shoppingCartRepository.save(cartMapper.mapToEntity(cartDTO));
		List<ShoppingPromotionItemDTO> promotions = promotionService.getPromotions(shoppingCart.getItems());
		return new ShoppingCartPromotionDTO(cartMapper.mapToDTO(shoppingCart), promotions);
	}
	
	public ShoppingPromotionItemDTO searchProductCart(ShoppingItemDTO dto, String chain, String store) {
		ShoppingItem item = itemMapper.mapToEntity(dto);
		return productService.getProduct(item, chain, store);
	}
	
	private ShoppingCartDTO convert(ShoppingMissingDTO dto, String chain, String store) {
		ShoppingCartDTO cartDTO = new ShoppingCartDTO();
		Optional<ShoppingMissing> op = shoppingMissingRepository.findById(dto.getId());
		if(op.isPresent()) {
			ShoppingMissing shoppingMissing = op.get();
			cartDTO.setChain(chain);
			cartDTO.setStore(store);
			cartDTO.setName(shoppingMissing.getName());
			cartDTO.setEliminated(shoppingMissing.getEliminated());
			cartDTO.setShoppingMissingId(dto.getId());
			cartDTO.setItems(shoppingMissing.getItems());
			
			List<AudienceDTO> audiences = new ArrayList<AudienceDTO>();
			audiences.add(dto.getAudience());
			cartDTO.setAudiences(audiences);
		}
		
		return cartDTO;
	}
}
