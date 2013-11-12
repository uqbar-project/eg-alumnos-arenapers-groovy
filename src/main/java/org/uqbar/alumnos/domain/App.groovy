package org.uqbar.alumnos.domain

import org.uqbar.alumnos.domain.Alumno.TipoAlumno
import org.uqbar.alumnos.home.HomeAlumnos

import uqbar.arena.persistence.Configuration

class App {

	static main(args) {
		println "Configurando homes"
		Configuration.configure()
		println "¡Homes configuradas!"
		HomeAlumnos.instance.createIfNotExists(leandroBarragan)
		leandroBarragan.tipoAlumno = TipoAlumno.ESTUDIOSO
		println "Alumno ahora es " + leandroBarragan.tipoAlumno
		println "Estos son los alumnos: " + HomeAlumnos.instance.allInstances() 
	}

	static def getLeandroBarragan() {
		new Alumno(nombre: "Leandro Barragan", tipoAlumno: TipoAlumno.COMUN,
			cursadas: [ new Cursada(materia: new Materia(nombre: "Design", anio: 3), comision: "K3052"),
				new Cursada(materia: new Materia(nombre: "SysOp", anio: 3), comision: "K3011")
			])
	}
}
