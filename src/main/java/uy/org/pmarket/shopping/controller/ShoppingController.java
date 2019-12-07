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

import uy.org.pmarket.shopping.dto.ShoppingMissingDTO;
import uy.org.pmarket.shopping.exception.ShoppingMissingException;
import uy.org.pmarket.shopping.service.ShoppingMissingService;

@RestController
@RequestMapping(value= "/shoppings")
public class ShoppingController {

	@Autowired
	private ShoppingMissingService shoppingMissingService;
	
	@PostMapping(value= "/save")
	public ShoppingMissingDTO save(@Valid @RequestBody ShoppingMissingDTO dto) throws ShoppingMissingException {	
		return shoppingMissingService.save(dto);
	}
	
	@GetMapping(value= "/audience/search/{name}")
	public List<ShoppingMissingDTO> audience(@RequestParam String name){
		return shoppingMissingService.search(name);
	}
}
