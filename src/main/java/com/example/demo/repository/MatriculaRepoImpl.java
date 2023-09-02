package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepoImpl implements IMatriculaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	public List<MatriculaDTO> buscartodosDTO() {
		// TODO Auto-generated method stub
		TypedQuery<MatriculaDTO> query=this.entityManager.createQuery("select new com.example.demo.modelo.MatriculaDTO(m.estudiante.cedula, m.materia.codigo, m.fecha, m.id) m from Matricula m", MatriculaDTO.class);
		return query.getResultList();
	}

}
