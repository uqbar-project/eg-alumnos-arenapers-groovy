package org.uqbar.alumnos.domain

import org.uqbar.alumnos.home.HomeAlumnos

import uqbar.arena.persistence.Configuration

class App {

	static main(args) {
		println "Configurando homes"
		Configuration.configure()
		println "¡Homes configuradas!"
		HomeAlumnos.instance.createIfNotExists(leandroBarragan)
		println "Estos son los alumnos: " + HomeAlumnos.instance.allInstances() 
	}

	static def getLeandroBarragan() {
		new Alumno(nombre: "Leandro Barragan",
			cursadas: [ new Cursada(materia: new Materia(nombre: "Design", anio: 3), comision: "K3052"),
				new Cursada(materia: new Materia(nombre: "SysOp", anio: 3), comision: "K3011")
			])
	}
}
