package com.example.demo.modelo;

import java.time.LocalDate;

public class MatriculaDTO {
	
	private String cedulaEstudiante;
	
	private String codigoMateria;
	
	private LocalDate fechaMatricula;
	
	private Integer id;
	
	

	public MatriculaDTO() {
	}



	public MatriculaDTO(String cedulaEstudiante, String codigoMateria, LocalDate fechaMatricula, Integer id) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.codigoMateria = codigoMateria;
		this.fechaMatricula = fechaMatricula;
		this.id = id;
	}



	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}



	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}



	public String getCodigoMateria() {
		return codigoMateria;
	}



	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}



	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}



	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "MatriculaDTO [cedulaEstudiante=" + cedulaEstudiante + ", codigoMateria=" + codigoMateria
				+ ", fechaMatricula=" + fechaMatricula + ", id=" + id + "]";
	}
	
	
	

}
