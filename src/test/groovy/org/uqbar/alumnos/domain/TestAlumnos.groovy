package org.uqbar.alumnos.domain

import org.junit.After
import org.junit.Test
import org.junit.Assert
import org.junit.Before
import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Transaction
import org.neo4j.test.TestGraphDatabaseFactory
import uqbar.arena.persistence.Configuration
import uqbar.arena.persistence.SessionManager
import org.uqbar.alumnos.home.HomeAlumnos;

class TestAlumnos {
	def GraphDatabaseService graphDb
	def Transaction transaction

	def Alumno leandro
	def Alumno fede
	
	@Test
	def void actualizacionDeUnEnum() {
		leandro.tipoAlumno = Alumno.TipoAlumno.ESTUDIOSO
		Assert.assertTrue(leandro.esEstudioso())
		HomeAlumnos.getInstance().update(leandro)
		def leandroActualizado = HomeAlumnos.getInstance().get("Leandro Barragan")
		Assert.assertEquals(Alumno.TipoAlumno.ESTUDIOSO, leandroActualizado.tipoAlumno)
	}

	@Test
	def void searchByExamplePorNombreAlumnoFunciona() {
		def alumnoExample = new Alumno (nombre: "Leandro Barragan")
		def result = HomeAlumnos.instance.searchByExample(alumnoExample) as ArrayList
		Assert.assertEquals(1, result.size() )
	}
	
	@Test(expected=Exception)
	def void searchByExampleQueAlumnosCursanDesignFalla() {
		def alumnoExample = new Alumno(cursadas: newArrayList(new Cursada("Design")))
		HomeAlumnos.getInstance().searchByExample(alumnoExample)
	}

	@Before
	def void init() {
		graphDb = new TestGraphDatabaseFactory().newImpermanentDatabaseBuilder().newGraphDatabase()
		SessionManager.testMode(graphDb)
		Configuration.configure()
		transaction = graphDb.beginTx()
		leandro = HomeAlumnos.getInstance().createIfNotExists(leandroBarragan)
		fede = HomeAlumnos.getInstance().createIfNotExists(fedeCano)
	}
	
	@After
	def void end() {
		HomeAlumnos.getInstance().delete(leandro)
		HomeAlumnos.getInstance().delete(fede)
		transaction.finish()
		graphDb.shutdown()
		Configuration.clear()
	}
	
	def getLeandroBarragan() {
		new Alumno(
			nombre: "Leandro Barragan",
			tipoAlumno: Alumno.TipoAlumno.COMUN,
			cursadas: [
				new Cursada(
					materia: new Materia("Design", 3),
					comision: "K3052"
				),
				new Cursada(
					materia: new Materia("SysOp", 3),
					comision: "K3011"
				)
			]
		)
	}

	def getFedeCano() {
		new Alumno (
			nombre: "Fede Cano",
			tipoAlumno: Alumno.TipoAlumno.ESTUDIOSO,
			cursadas: [
				new Cursada (
					materia: new Materia("Matematica Discreta", 1),
					comision: "K3052"
				),
				new Cursada (
					materia: new Materia("Análisis Matemático I", 1),
					comision: "K3011"
				)
			]
		)
	}
	
}
