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

	String nombre
	int anio
	
	@PersistentField
	String getNombre() {
		nombre
	}
	
	@PersistentField
	int getAnio() {
		anio
	}
	
}
