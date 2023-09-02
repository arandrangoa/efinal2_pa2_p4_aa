package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Materia;
import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.MatriculaDTO;
import com.example.demo.modelo.MatriculaTemporal;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping("/registrarMatricula")
	private String registrarMatricula(MatriculaTemporal matriculaTemporal) {
		
		return "vistaNuevaMatricula";
	}
	
	@PostMapping("/insertarMatricula")
	private String insertarMatricula(MatriculaTemporal matriculaTemporal) {
		Estudiante e=this.estudianteService.buscarPorCedula(matriculaTemporal.getCedula());
		Materia m1=this.iMateriaService.buscarPorCodigo(matriculaTemporal.getM1());
		Materia m2=this.iMateriaService.buscarPorCodigo(matriculaTemporal.getM2());
		Materia m3=this.iMateriaService.buscarPorCodigo(matriculaTemporal.getM3());
		Materia m4=this.iMateriaService.buscarPorCodigo(matriculaTemporal.getM4());
		
		List<Materia> materias=new ArrayList<>();
		materias.add(m1);
		materias.add(m2);
		materias.add(m3);
		materias.add(m4);
		
		for(Materia mat:materias) {
			Matricula matricula=new Matricula();
			matricula.setEstudiante(e);
			matricula.setMateria(mat);
			matricula.setFecha(LocalDate.now());
			this.iMatriculaService.agregar(matricula);
		}
		return "redirect:/matriculas/registrarMatricula";
	}
	
	@GetMapping("/listaMatriculas")
	private String listaMateriaDTO(Model modelo) {
		List<MatriculaDTO> matriculas=this.iMatriculaService.buscartodosDTO();
		modelo.addAttribute("matriculas", matriculas);
		return "vistaListaMatriculas";
	}
	
	

}
