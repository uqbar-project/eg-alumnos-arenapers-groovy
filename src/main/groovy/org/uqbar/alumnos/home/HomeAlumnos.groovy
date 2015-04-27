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
		def alumnoDB = this.get(alumno.nombre)
		if (alumnoDB == null) {
			this.create(alumno)
			alumnoDB = alumno
		} 
		alumnoDB
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
