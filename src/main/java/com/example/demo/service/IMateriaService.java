package com.example.demo.service;

import com.example.demo.modelo.Materia;

public interface IMateriaService {
	
	public void agregar(Materia materia);
	
	public Materia buscarPorCodigo(String codigo);

}
