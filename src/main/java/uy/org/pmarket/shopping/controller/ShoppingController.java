package uy.org.pmarket.shopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uy.org.pmarket.shopping.dto.ShoppingCartDTO;
import uy.org.pmarket.shopping.dto.ShoppingCartPromotionDTO;
import uy.org.pmarket.shopping.dto.ShoppingItemDTO;
import uy.org.pmarket.shopping.dto.ShoppingMissingDTO;
import uy.org.pmarket.shopping.dto.ShoppingPromotionItemDTO;
import uy.org.pmarket.shopping.exception.ShoppingMissingException;
import uy.org.pmarket.shopping.service.ShoppingCartService;
import uy.org.pmarket.shopping.service.ShoppingMissingService;

@RestController
@RequestMapping(value= "/shoppings")
public class ShoppingController {

	@Autowired
	private ShoppingMissingService shoppingMissingService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PostMapping(value= "/save")
	public ShoppingMissingDTO save(@Valid @RequestBody ShoppingMissingDTO dto) throws ShoppingMissingException {	
		return shoppingMissingService.save(dto);
	}
	
	@GetMapping(value= "/audience/search/{user}")
	public List<ShoppingMissingDTO> audience(@RequestParam String user){
		return shoppingMissingService.search(user);
	}
	
	@PostMapping(value= "/enter/chain/{chain}/store/{store}/user/{user}")
	public ShoppingCartPromotionDTO enterInStore(@RequestParam String chain, @RequestParam String store, 
			@Valid @RequestBody ShoppingMissingDTO dto, @RequestParam String user) {	
		return shoppingCartService.enterInStore(dto);
	}
	
	@PostMapping(value= "/cart/chain/{chain}/store/{store}/product/search")
	public ShoppingPromotionItemDTO searchProductCart(@RequestParam String chain, @RequestParam String store, 
			@Valid @RequestBody ShoppingItemDTO dto) {
		return null;
	}
	
}
