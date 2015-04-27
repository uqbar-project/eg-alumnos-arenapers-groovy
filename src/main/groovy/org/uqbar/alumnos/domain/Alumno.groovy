package org.uqbar.alumnos.domain

import groovy.transform.EqualsAndHashCode
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
	
	@PersistentField String nombre
	@Relation List<Cursada> cursadas 
	@PersistentField TipoAlumno tipoAlumno
	
	enum TipoAlumno {
		ESTUDIOSO, VAGONETA, COMUN
	}
	
	public Alumno() {
		nombre = ""
		cursadas = []
		tipoAlumno = TipoAlumno.COMUN	
	}
	
	TipoAlumno getTipoAlumno() {
		tipoAlumno
	}
	

	String getNombre() {
		nombre
	}
	
	
	List<Cursada> getCursadas() {
		cursadas
	}

	
	
	@Override
	String toString() {
		nombre + " (" + tipoAlumno + ") - cursando " + cursadas.materia.nombre
	}
	
	def esEstudioso() {
		tipoAlumno.equals(Alumno.TipoAlumno.ESTUDIOSO)
	}
		
}
