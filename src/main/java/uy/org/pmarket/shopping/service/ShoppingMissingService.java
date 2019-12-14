package uy.org.pmarket.shopping.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.org.pmarket.shopping.dto.ShoppingItemDTO;
import uy.org.pmarket.shopping.dto.ShoppingMissingDTO;
import uy.org.pmarket.shopping.exception.ShoppingException;
import uy.org.pmarket.shopping.mapper.ShoppingItemMapper;
import uy.org.pmarket.shopping.mapper.ShoppingMissingMapper;
import uy.org.pmarket.shopping.model.ShoppingAudience;
import uy.org.pmarket.shopping.model.ShoppingItem;
import uy.org.pmarket.shopping.model.ShoppingMissing;
import uy.org.pmarket.shopping.repository.ShoppingMissingRepository;

@Service
public class ShoppingMissingService extends MessageService<ShoppingMissing> {

	@Autowired
	private ShoppingMissingMapper missingMapper;
	@Autowired
	private ShoppingItemMapper itemMapper;
	@Autowired
	private ShoppingMissingRepository missingRepository;
	@Autowired
	private AudienceService audienceService;
	
	public ShoppingMissingDTO save(ShoppingMissingDTO dto) throws ShoppingException {
		ShoppingMissing entity = missingMapper.mapToEntity(dto);
		try {
			entity = missingRepository.save(entity);
			audienceService.saveAudienceShoppingMissing(entity);
		} catch (Exception e) {
			send(entity);
			throw new ShoppingException(e);
		}
		return missingMapper.mapToDTO(entity);
	}
	
	public List<ShoppingMissingDTO> search(String user){
		ShoppingAudience audience = audienceService.getShoppingAudience(user);
		return audience.getShoppings().stream().map( id -> {
			ShoppingMissingDTO dto = null;
			Optional<ShoppingMissing> optional = missingRepository.findById(id);
			if (optional.isPresent()) {
				dto = missingMapper.mapToDTO(optional.get());
			}
			return dto;
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}
	
	public ShoppingMissingDTO saveItem(String shoppingMissingId, ShoppingItemDTO dto) throws ShoppingException {	
		ShoppingMissing shoppingMissing = getShoppingMissingById(shoppingMissingId);
		Optional<ShoppingItem> optional = shoppingMissing.getItems().stream().filter(item -> item.getCode().equals(dto.getCode())).findFirst();
		ShoppingItem item = null;
		if (!optional.isPresent()) {
			item = itemMapper.mapToEntity(dto);
			shoppingMissing.getItems().add(item);
		} else {
			item = optional.get();
			item.setQuantity(dto.getQuantity());
			item.setPromotionId(dto.getPromotionId());
		}
		
		return missingMapper.mapToDTO(missingRepository.save(shoppingMissing));
	}
	
	public ShoppingMissingDTO deleteItem(String shoppingMissingId, ShoppingItemDTO dto) throws ShoppingException {	
		ShoppingMissing shoppingMissing = getShoppingMissingById(shoppingMissingId);
		shoppingMissing.getItems().removeIf(item -> item.getCode().equals(dto.getCode()));
		return missingMapper.mapToDTO(missingRepository.save(shoppingMissing));
	}
	
	private ShoppingMissing getShoppingMissingById(String shoppingMissingId) throws ShoppingException {
		return missingRepository.findById(shoppingMissingId).orElseThrow(() -> new ShoppingException("Resource not found " + shoppingMissingId)); 
	}
}
