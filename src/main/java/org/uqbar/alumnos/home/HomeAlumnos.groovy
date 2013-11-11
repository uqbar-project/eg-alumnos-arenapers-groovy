package org.uqbar.alumnos.home

import org.uqbar.alumnos.domain.Alumno

import uqbar.arena.persistence.PersistentHome

class HomeAlumnos extends PersistentHome<Alumno> {

	@Override
	def Class<Alumno> getEntityType() {
		return Alumno.class
	}

	@Override
	def Alumno createExample() {
		return new Alumno()
	}

	def createIfNotExists(alumno) {
		println "Busco al alumno"
		if (this.get(alumno.nombre) == null) {
			println "No existe, creo al alumno"
			this.create(alumno)
		} else {
			println "Ya existe el alumno"
		}
	}

	def Alumno get(String descripcion) {
		allInstances().find { alumno -> alumno.nombre.equalsIgnoreCase(descripcion) }
	}
	
	static instance

	static def getInstance() {
		if (instance == null) {
			instance = new HomeAlumnos()
		}
		instance
	}
}
