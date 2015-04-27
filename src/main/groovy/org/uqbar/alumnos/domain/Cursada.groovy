package org.uqbar.alumnos.domain

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.utils.Transactional

import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation

@Transactional
@Observable
@PersistentClass
class Cursada extends Entity {

	@PersistentField String comision
	@Relation Materia materia
	
	
	String getComision() {
		comision
	}
	
	
	Materia getMateria() {
		materia
	}
	
}
