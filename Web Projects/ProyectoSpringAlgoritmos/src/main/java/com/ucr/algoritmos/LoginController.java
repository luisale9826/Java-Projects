package com.ucr.algoritmos;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Domain.Cliente;
import Domain.Gerente;

@ Controller
public class LoginController {

	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String iniciar(Model model){
		
		return "login";
	}	
	
	
	@RequestMapping(value = "/gerente", method = RequestMethod.GET)
	public String iniciarGerente(Model model, HttpServletRequest request){
				
		try	{
		
			Gerente gerente = (Gerente) request.getSession().getAttribute("usuario");
			model.addAttribute("Nombre", gerente.getNombre());
			
		}catch(NullPointerException npe){
			return "login";
		}catch(ClassCastException cast){
			return "usuarioIncorrecto";
		}
			
		return "gerente";
	}	
	
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String iniciarUsuario(Model model, HttpServletRequest request){
				
		try	{
			Cliente usuario = (Cliente) request.getSession().getAttribute("usuario");
			model.addAttribute("Nombre", usuario.getNombre());
			
		}catch(NullPointerException npe){
			return "login";
		}catch(ClassCastException cast){
			return "usuarioIncorrecto";
		}
			
		return "usuario";
	}	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String recibirDatos(@RequestParam Map<String, String> requestParams, Model model, HttpServletRequest request){
		
		String contrseña = requestParams.get("psw");
		String usuario = requestParams.get("email");
		
		if(usuario.equals(ProyectoSpringAlgoritmosApplication.juan.getUsuario())){			
			request.getSession().putValue("usuario", ProyectoSpringAlgoritmosApplication.juan);			
			if(ProyectoSpringAlgoritmosApplication.juan instanceof Gerente){
				return "gerente";
			}
		}else if(usuario.equals(ProyectoSpringAlgoritmosApplication.daniel.getUsuario())){
			request.getSession().putValue("usuario", ProyectoSpringAlgoritmosApplication.daniel);			
			if(ProyectoSpringAlgoritmosApplication.daniel instanceof Cliente){
				return "usuario";
			}
		}
		return "error";
	}
	
	
}
