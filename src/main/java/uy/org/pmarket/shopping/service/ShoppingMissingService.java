package uy.org.pmarket.shopping.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.org.pmarket.shopping.dto.ShoppingMissingDTO;
import uy.org.pmarket.shopping.exception.ShoppingMissingException;
import uy.org.pmarket.shopping.mapper.ShoppingMissingMapper;
import uy.org.pmarket.shopping.model.ShoppingAudience;
import uy.org.pmarket.shopping.model.ShoppingMissing;
import uy.org.pmarket.shopping.repository.ShoppingMissingRepository;

@Service
public class ShoppingMissingService extends MessageService<ShoppingMissing> {

	@Autowired
	private ShoppingMissingMapper missingMapper;
	@Autowired
	private ShoppingMissingRepository missingRepository;
	@Autowired
	private AudienceService audienceService;
	
	public ShoppingMissingDTO save(ShoppingMissingDTO dto) throws ShoppingMissingException {
		ShoppingMissing entity = missingMapper.mapToEntity(dto);
		try {
			entity = missingRepository.save(entity);
			audienceService.saveAudienceShoppingMissing(entity);
		} catch (Exception e) {
			send(entity);
			throw new ShoppingMissingException(e);
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
	
}
