package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.MatriculaDTO;
import com.example.demo.repository.IMatriculaRepo;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private IMatriculaRepo iMatriculaRepo;
	
	@Autowired
	private IEstudianteService estudianteService;

	@Override
	public void agregar(Matricula matricula) {
		// TODO Auto-generated method stub
		matricula.setFecha(LocalDate.now());
		Estudiante e=this.estudianteService.buscarPorCedula(matricula.getEstudiante().getCedula());
		matricula.setEstudiante(e);
		
		
		this.iMatriculaRepo.insertar(matricula);
	}

	@Override
	public List<MatriculaDTO> buscartodosDTO() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepo.buscartodosDTO();
	}

}
