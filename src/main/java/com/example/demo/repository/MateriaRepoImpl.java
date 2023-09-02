package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query=this.entityManager.createQuery("select m from Materia m where m.codigo= :datoCodigo", Materia.class);
		query.setParameter("datoCodigo", codigo);
		return query.getSingleResult();
	}

}
