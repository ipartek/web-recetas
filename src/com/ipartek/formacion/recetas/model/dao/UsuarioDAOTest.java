package com.ipartek.formacion.recetas.model.dao;

import static org.junit.Assert.assertEquals;
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		dao = UsuarioDAO.getInstance();
		u = new Usuario();
		u.setEmail("dummy@dummy.com");
		u.setNombre("dummy");
		u.setPassword("123456");

		// contar usuarios iniciales
		contador = dao.count();
		contatorInicial = dao.count();
		assertTrue("minimo 0 usuarios", contador >= 0);

		// crear usuario
		dao.create(u);
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
		assertEquals("getAll no funciona", contador, listado.size());

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
		// TODO comparar todos los campos del usuario
	}

	@Test
	public void testGetByEmail() {
		Usuario uByEmail = dao.getByEmail(u.getEmail());
		assertNotNull("Debe poder recuperar por Email el usuario insertado", uByEmail);
		// TODO comparar todos los campos del usuario
	}

	@Test
	public void testUpdate() {
		// Modificar usuario
		Usuario uModificado = new Usuario();

		assertTrue("deberia modificar usuario", dao.update(uModificado));

		// TODO comparar todos los campos del usuario

	}

}
