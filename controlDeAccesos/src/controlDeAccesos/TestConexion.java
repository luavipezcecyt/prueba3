package controlDeAccesos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestConexion {

	@Test
	void testConsultarReg() {
		RegistroDAO rd = new RegistroDAO();
		Registro r = rd.consultarReg(58);
		assertNull(r);
	}
	@Test
	void testConsultarRegError() {
		RegistroDAO rd = new RegistroDAO();
		Registro r = rd.consultarReg(5);
		assertNull(r);
	}

}
