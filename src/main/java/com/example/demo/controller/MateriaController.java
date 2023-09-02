package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@GetMapping("/registrarMateria")
	private String registrarMateria(Materia materia) {
		return "vistaNuevaMateria";
	}
	
	@PostMapping("/insertarMateria")
	public String insertarMateria(Materia materia) {
		this.iMateriaService.agregar(materia);
		return"redirect:/materias/registrarMateria";
	}

}
