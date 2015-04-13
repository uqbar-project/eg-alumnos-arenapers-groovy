package org.uqbar.alumnos.domain

import org.uqbar.alumnos.domain.Alumno.TipoAlumno
import org.uqbar.alumnos.home.HomeAlumnos

import uqbar.arena.persistence.Configuration

class App {

	static main(args) {
		println "Configurando homes"
		Configuration.configure()
		println "¡Homes configuradas!"
		def leandro = HomeAlumnos.instance.createIfNotExists(leandroBarragan)
		println "Alumno es " + leandro.tipoAlumno
		leandro.tipoAlumno = TipoAlumno.ESTUDIOSO
		println "Alumno ahora es " + leandro.tipoAlumno
		HomeAlumnos.instance.update(leandro)
		println "Estos son los alumnos: " + HomeAlumnos.instance.allInstances()
		// Exception in thread "main" java.lang.Exception: No se puede hacer query by example con relaciones entre objetos.
		println "¿Qué alumnos cursan Design?"
		def Alumno alumnoPrueba = new Alumno(nombre: "Leandro Barragan")
		println HomeAlumnos.instance.searchByExample(leandroBarragan) 
	}

	static def getLeandroBarragan() {
		new Alumno(nombre: "Leandro Barragan", tipoAlumno: TipoAlumno.COMUN,
			cursadas: [ new Cursada(materia: new Materia(nombre: "Design", anio: 3), comision: "K3052"),
				new Cursada(materia: new Materia(nombre: "SysOp", anio: 3), comision: "K3011")
			])
	}
}
