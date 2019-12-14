package uy.org.pmarket.shopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uy.org.pmarket.shopping.dto.ShoppingCartPromotionDTO;
import uy.org.pmarket.shopping.dto.ShoppingItemDTO;
import uy.org.pmarket.shopping.dto.ShoppingMissingDTO;
import uy.org.pmarket.shopping.dto.ShoppingPromotionItemDTO;
import uy.org.pmarket.shopping.exception.ShoppingException;
import uy.org.pmarket.shopping.service.ShoppingCartService;
import uy.org.pmarket.shopping.service.ShoppingMissingService;

@RestController
@RequestMapping(value= "/shoppings")
public class ShoppingController {

	@Autowired
	private ShoppingMissingService shoppingMissingService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PostMapping(value= "/missing/save")
	public ShoppingMissingDTO save(@Valid @RequestBody ShoppingMissingDTO dto) throws ShoppingException {	
		return shoppingMissingService.save(dto);
	}
	
	@GetMapping(value= "/missing/audience/search/{user}")
	public List<ShoppingMissingDTO> audience(@RequestParam String user){
		return shoppingMissingService.search(user);
	}
	
	@PutMapping(value= "/missing/item/{shoppingMissingId}/")
	public ShoppingMissingDTO saveItem(@RequestParam String shoppingMissingId, @Valid @RequestBody ShoppingItemDTO dto) throws ShoppingException {	
		return shoppingMissingService.saveItem(shoppingMissingId, dto);
	}
	
	@DeleteMapping(value= "/missing/item/{shoppingMissingId}/")
	public ShoppingMissingDTO deleteItem(@RequestParam String shoppingMissingId, @Valid @RequestBody ShoppingItemDTO dto) throws ShoppingException {	
		return shoppingMissingService.deleteItem(shoppingMissingId, dto);
	}
	
	@PostMapping(value= "/enter/chain/{chain}/store/{store}/user/{user}")
	public ShoppingCartPromotionDTO enterInStore(@RequestParam String chain, @RequestParam String store, 
			@Valid @RequestBody ShoppingMissingDTO dto, @RequestParam String user) {	
		return shoppingCartService.enterInStore(dto, chain, store);
	}
	
	@PostMapping(value= "/cart/chain/{chain}/store/{store}/product/search")
	public ShoppingPromotionItemDTO searchProductCart(@RequestParam String chain, @RequestParam String store, 
			@Valid @RequestBody ShoppingItemDTO dto) {
		return shoppingCartService.searchProductCart(dto, chain, store);
	}
	
	@PutMapping(value= "/cart/chain/{chain}/store/{store}/shopping/{shoppingCartId}/product/save")
	public ShoppingItemDTO saveProductCart(@RequestParam String chain, @RequestParam String store, 
			@RequestParam String shoppingCartId, @Valid @RequestBody ShoppingItemDTO dto) {
		return null;
	}
}
