package org.uqbar.alumnos.domain

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Transactional

import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation
import org.uqbar.commons.utils.Observable

@Transactional
@Observable
@PersistentClass
class Alumno extends Entity {
	
	String nombre
	List<Cursada> cursadas
	TipoAlumno tipoAlumno
	
	enum TipoAlumno {
		ESTUDIOSO, VAGONETA, COMUN
	}
	
	Alumno() {
		nombre = ""
		cursadas = []
		tipoAlumno = TipoAlumno.COMUN	
	}
	
	@PersistentField
	TipoAlumno getTipoAlumno() {
		tipoAlumno
	}
	
	@PersistentField
	String getNombre() {
		nombre
	}
	
	@Relation
	List<Cursada> getCursadas() {
		cursadas
	}

	@Override
	String toString() {
		nombre + " (" + tipoAlumno + ") - cursando " + cursadas.materia.nombre
	}
		
}
