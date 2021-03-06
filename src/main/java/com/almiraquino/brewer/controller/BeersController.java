package com.almiraquino.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almiraquino.brewer.model.Beer;

@Controller
@RequestMapping("/beers")
public class BeersController {
	
	@RequestMapping("/new")
	public String newBeer(Beer beer) {
		System.out.println(System.getProperty("classpath"));
		return "beer/add-beer";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newBeer(@Valid Beer beer, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return newBeer(beer);
		}			
		
		attributes.addFlashAttribute("message", "Beer inserted!");
		System.out.println(">>>> Sku: " + beer.getSku());
		System.out.println(">>>> Name: " + beer.getName());
		return "redirect:/beers/new";
	}

}
