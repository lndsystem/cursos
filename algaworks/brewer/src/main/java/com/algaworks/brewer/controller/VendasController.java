package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/vendas")
public class VendasController {
	
	
	@RequestMapping("/nova")
	public ModelAndView nova() {
		ModelAndView mv = new ModelAndView("/venda/CadastroVenda");
		return mv;
	}
}
