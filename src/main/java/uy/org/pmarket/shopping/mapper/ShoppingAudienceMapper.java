package uy.org.pmarket.shopping.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import uy.org.pmarket.shopping.dto.ShoppingAudienceDTO;
import uy.org.pmarket.shopping.model.ShoppingAudience;

@Component
public class ShoppingAudienceMapper extends AbstractMapper<ShoppingAudience, ShoppingAudienceDTO>{

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public ShoppingAudience mapToEntity(ShoppingAudienceDTO s) {
		return objectMapper.convertValue(s, ShoppingAudience.class);
	}

	@Override
	public ShoppingAudienceDTO mapToDTO(ShoppingAudience t) {
		return objectMapper.convertValue(t, ShoppingAudienceDTO.class);
	}

}
