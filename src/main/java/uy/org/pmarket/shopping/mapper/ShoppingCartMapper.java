package uy.org.pmarket.shopping.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import uy.org.pmarket.shopping.dto.ShoppingCartDTO;
import uy.org.pmarket.shopping.model.ShoppingCart;

@Component
public class ShoppingCartMapper extends AbstractMapper<ShoppingCart, ShoppingCartDTO>{

	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public ShoppingCart mapToEntity(ShoppingCartDTO s) {
		return objectMapper.convertValue(s, ShoppingCart.class);
	}

	@Override
	public ShoppingCartDTO mapToDTO(ShoppingCart t) {
		return objectMapper.convertValue(t, ShoppingCartDTO.class);
	}

}
