package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.MatriculaDTO;

public interface IMatriculaService {
	
	public void agregar(Matricula matricula);
	
	public List<MatriculaDTO> buscartodosDTO();

}
