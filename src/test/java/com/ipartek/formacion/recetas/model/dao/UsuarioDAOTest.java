package com.ipartek.formacion.recetas.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.recetas.pojo.Usuario;

public class UsuarioDAOTest {

	static UsuarioDAO dao = null;
	static int contador = -1;
	static int contatorInicial = -1;
	static Usuario u = null;

	static final int LIMITE_SELECT = 500;

	static final String EMAIL_EXISTE = "dummy@dummy.com";
	static final String EMAIL_NO_EXISTE = "a@a.aa";
	static final String DNI_EXISTE = "12345678L";
	static final String DNI_NO_EXISTE = "111";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		dao = UsuarioDAO.getInstance();
		u = new Usuario();
		u.setEmail(EMAIL_EXISTE);
		u.setNombre("dummy");
		u.setDni(DNI_EXISTE);
		u.setPassword("123456");

		// contar usuarios iniciales
		contador = dao.count();
		contatorInicial = dao.count();
		assertTrue("minimo 0 usuarios", contador >= 0);

		// crear usuario
		assertTrue("No inserta usuario", dao.create(u));
		contador = dao.count();
		assertTrue("deberia haber un usuario nuevo", contador > contatorInicial);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		// eliminar usuario creado al inicio del test
		assertTrue("No elimina usuario", dao.delete(u.getId()));

	}

	@Test
	public void testCountYgetAll() {

		ArrayList<Usuario> listado = (ArrayList<Usuario>) dao.getAll();
		assertTrue("getAll no funciona", LIMITE_SELECT >= listado.size());
		assertEquals("count no funciona", contador, dao.count());

	}

	@Test
	public void testExiste() {
		// comprobar existe
		assertNotNull("deberia encontrar el usuario insertado", dao.existe("dummy@dummy.com", "123456"));
		assertNull("debe retornar null si no existe usuario", dao.existe("noExiste@a.com", "1"));
	}

	@Test
	public void testGetById() {
		// getById
		Usuario uById = dao.getById(u.getId());
		assertNotNull("Debe poder recuperar por ID el usuario insertado", uById);
		assertTrue("No son iguales", u.equals(uById));
	}

	@Test
	public void testGetByEmail() {
		Usuario uByEmail = dao.getByEmail(u.getEmail());
		assertNotNull("Debe poder recuperar por Email el usuario insertado", uByEmail);
		assertTrue("No son iguales", u.equals(uByEmail));
	}

	@Test
	public void testUpdate() {
		// Modificar usuario
		Usuario uModificado = new Usuario();
		assertFalse("No deberia modificar usuario sin ID", dao.update(uModificado));

		uModificado.setId(u.getId());
		assertTrue("deberia modificar usuario", dao.update(uModificado));

	}

	@Test
	public void testFilterByDni() {

		Usuario uExito = dao.filterByDni("12345678L");
		Usuario uFracaso = dao.filterByDni("1");
		Usuario uNull = dao.filterByDni(null);

		assertEquals("Deberia haberlo encontrado ", u, uExito);
		assertNull("No deberia existir", uFracaso);
		assertNull("Cuidadin con los null", uNull);

	}

	@Test
	public void testComprobarIntegridad() {

		final long ID_EXISTENTE = u.getId();
		final long ID_NO_EXISTE = -1;

		// comprobar usuario existente == update
		assertTrue(dao.comprobarIntegridad(EMAIL_EXISTE, DNI_EXISTE, ID_EXISTENTE));
		assertTrue(dao.comprobarIntegridad(EMAIL_NO_EXISTE, DNI_EXISTE, ID_EXISTENTE));
		assertTrue(dao.comprobarIntegridad(EMAIL_EXISTE, DNI_NO_EXISTE, ID_EXISTENTE));
		assertFalse(dao.comprobarIntegridad(null, null, ID_EXISTENTE));
		assertFalse(dao.comprobarIntegridad(EMAIL_EXISTE, null, ID_EXISTENTE));
		assertFalse(dao.comprobarIntegridad(EMAIL_NO_EXISTE, null, ID_EXISTENTE));
		assertFalse(dao.comprobarIntegridad(null, DNI_NO_EXISTE, ID_EXISTENTE));
		assertFalse(dao.comprobarIntegridad(null, DNI_EXISTE, ID_EXISTENTE));
		assertTrue(dao.comprobarIntegridad(EMAIL_NO_EXISTE, DNI_NO_EXISTE, ID_EXISTENTE));

		// comprobar usuario no existente == insert
		assertFalse(dao.comprobarIntegridad(EMAIL_EXISTE, DNI_EXISTE, ID_NO_EXISTE));
		assertFalse(dao.comprobarIntegridad(EMAIL_NO_EXISTE, DNI_EXISTE, ID_NO_EXISTE));
		assertFalse(dao.comprobarIntegridad(EMAIL_EXISTE, DNI_NO_EXISTE, ID_NO_EXISTE));
		assertFalse(dao.comprobarIntegridad(null, null, ID_NO_EXISTE));
		assertFalse(dao.comprobarIntegridad(EMAIL_EXISTE, null, ID_NO_EXISTE));
		assertFalse(dao.comprobarIntegridad(EMAIL_NO_EXISTE, null, ID_NO_EXISTE));
		assertFalse(dao.comprobarIntegridad(null, DNI_NO_EXISTE, ID_NO_EXISTE));
		assertFalse(dao.comprobarIntegridad(null, DNI_EXISTE, ID_NO_EXISTE));
		assertTrue(dao.comprobarIntegridad(EMAIL_NO_EXISTE, DNI_NO_EXISTE, ID_NO_EXISTE));

	}

}
