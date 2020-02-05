package com.ucr.algoritmos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MostrarProductosController {

	@RequestMapping(value = "/mostrar", method = RequestMethod.GET)
	public String iniciar(Model model){
		
		return "mostrarProductos";
	}	
	
	
	
}
