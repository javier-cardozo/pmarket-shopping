package uy.org.pmarket.shopping.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import uy.org.pmarket.shopping.dto.ShoppingItemDTO;
import uy.org.pmarket.shopping.model.ShoppingItem;

@Component
public class ShoppingItemMapper extends AbstractMapper<ShoppingItem, ShoppingItemDTO>{

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public ShoppingItem mapToEntity(ShoppingItemDTO s) {
		return objectMapper.convertValue(s, ShoppingItem.class);
	}

	@Override
	public ShoppingItemDTO mapToDTO(ShoppingItem t) {
		return objectMapper.convertValue(t, ShoppingItemDTO.class);
	}

}
