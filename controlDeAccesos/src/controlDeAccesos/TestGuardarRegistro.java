package controlDeAccesos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGuardarRegistro {

	@Test
	void testGuardarRegistro() {
		RegistroDAO rd = new RegistroDAO();
		Registro r = new Registro();
		r.setCodAcc(5);
		r.setNombre("Alex2");
		r.setFecha("17/03/2006");
		r.setHora("15:17");
		boolean real = rd.guardarRegistro(r);
		assertNotEquals(false, real);
	}
	
	@Test
	void testGuardarRegistroError() {
		RegistroDAO rd = new RegistroDAO();
		Registro r = new Registro();
		r.setCodAcc(5);
		r.setNombre("Alex3");
		r.setFecha("17/03/2006");
		r.setHora("15:17");
		boolean real = rd.guardarRegistro(r);
		assertNotEquals(true, real);
	}

}
