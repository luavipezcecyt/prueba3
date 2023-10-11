package controlDeAccesos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PruebaEliminarRegistro {

	@Test
	void testEliminarRegistro() {
		RegistroDAO rd = new RegistroDAO();
		boolean real = rd.eliminarRegistro(3);
		boolean esperado = true;
		assertEquals(esperado, real);		
	}

	@Test
	void testEliminarRegistroError() {
		RegistroDAO rd = new RegistroDAO();
		boolean real = rd.eliminarRegistro(1);
		boolean esperado = true;
		assertEquals(esperado, real);		
	}
}
