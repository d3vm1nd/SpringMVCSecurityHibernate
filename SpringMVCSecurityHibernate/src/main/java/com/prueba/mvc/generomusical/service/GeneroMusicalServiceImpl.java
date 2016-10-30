package com.prueba.mvc.generomusical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.mvc.generomusical.dao.GeneroMusicalDAO;
import com.prueba.mvc.generomusical.domain.GeneroMusical;

@Service
public class GeneroMusicalServiceImpl implements GeneroMusicalService{
	
	@Autowired
	private GeneroMusicalDAO generoMusicalDAO;

	@Override
	@Transactional
	public GeneroMusical createGeneroMusical(GeneroMusical generoMusical) {
		generoMusicalDAO.createGeneroMusical(generoMusical);
		return generoMusical;
	}

	@Override
	@Transactional
	public GeneroMusical updateGeneroMusical(GeneroMusical generoMusical) {
		GeneroMusical current_generoMusical = generoMusicalDAO.getGeneroMusicalById(generoMusical.getId());
		
		if(current_generoMusical != null){
			current_generoMusical.setNombre(generoMusical.getNombre());
			current_generoMusical.setHistoria(generoMusical.getHistoria());
			generoMusicalDAO.updateGeneroMusical(current_generoMusical);
		}
		
		return current_generoMusical;
	}

	@Override
	@Transactional
	public List<GeneroMusical> listGenerosMusicales() {
		return generoMusicalDAO.listGenerosMusicales();
	}

	@Override
	@Transactional
	public void removeGeneroMusical(int id) {
		generoMusicalDAO.removeGeneroMusical(id);
	}

	@Override
	@Transactional
	public GeneroMusical getGeneroMusicalById(int id) {
		return generoMusicalDAO.getGeneroMusicalById(id);
	}
	
	@Override
	@Transactional
	public void deleteAllGenerosMusicales(){
		generoMusicalDAO.deleteAllGenerosMusicales();
	}
	
	

}
