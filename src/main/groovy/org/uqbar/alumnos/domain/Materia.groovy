package org.uqbar.alumnos.domain

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.utils.Transactional

import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField

@Transactional
@Observable
@PersistentClass
class Materia extends Entity {

	@PersistentField String nombre
	@PersistentField int anio
	
	public Materia() {
	
	}

	public Materia(String unNombre, int unAnio) {
		nombre = unNombre
		anio = unAnio
	}

	
	String getNombre() {
		nombre
	}
	
	int getAnio() {
		anio
	}
	
}
