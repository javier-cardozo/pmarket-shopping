package uy.org.pmarket.shopping.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import uy.org.pmarket.shopping.dto.ShoppingMissingDTO;
import uy.org.pmarket.shopping.model.ShoppingMissing;

@Component
public class ShoppingMissingMapper extends AbstractMapper<ShoppingMissing, ShoppingMissingDTO>{

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public ShoppingMissing mapToEntity(ShoppingMissingDTO s) {
		return objectMapper.convertValue(s, ShoppingMissing.class);
	}

	@Override
	public ShoppingMissingDTO mapToDTO(ShoppingMissing t) {
		return objectMapper.convertValue(t, ShoppingMissingDTO.class);
	}

}
