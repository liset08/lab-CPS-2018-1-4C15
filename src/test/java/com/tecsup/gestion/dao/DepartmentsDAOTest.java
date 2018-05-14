package com.tecsup.gestion.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class DepartmentsDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentsDAOTest.class);

	@Autowired
	private DepartmentDAO departmentDAO;

	
	@BeforeClass
	public static void beforeClass() {
		logger.info("Antes de todos los metodos");

	}
	
	@Before
	public  void before() {
		logger.info("Antes de cada metodo");
	}
	
	@Test
	public void testFindEmployeeById() {

		try {
			//
			Department dpt = departmentDAO.findDepartment(48);

		/*	Assert.assertNotNull(dpt);

			Assert.assertEquals("departamento_lima", dpt.getName());
			Assert.assertEquals("este es un bonito departamento", dpt.getDescription());
			Assert.assertEquals("Lima", dpt.getCity());
			*/

			logger.info(dpt.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testFindAllDepartments() {

		try {
			//
			List<Department> emps = departmentDAO.findAllDepartment();

			//Assert.assertEquals(emps.size(), 4);

			logger.info(emps.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

		
	}
	//cambios 

	@Test
	public void testFindEmployeeByName() {

		try {
			//
			Department dpt = departmentDAO.findDepartmentByName("Prueba2");

			Assert.assertEquals("50", dpt.getDepartmentId());
			Assert.assertEquals(":3", dpt.getDescription());
			Assert.assertEquals("Miau x2", dpt.getCity());
			

			logger.info(dpt.toString());
			
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testCreateDepartment() {

		logger.info("--");
		
		String NAME = "creado" + (int) (Math.random() * 100);
		//logger.info(LOGIN);
		String DESC = "liset ahora";
		String CITY = "Lima";
		

		try {
			//
			departmentDAO.create(NAME, DESC, CITY);

			//
			Department dpt = departmentDAO.findDepartmentByName(NAME);

			Assert.assertEquals(DESC, dpt.getDescription());
			Assert.assertEquals(CITY, dpt.getCity());
			

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}

	
	
	@Test
	public void testUpdateDepartment() {

		String NAME = "liset" + (int)(Math.random() * 100);
		String DESC = "studen";
		String CITY = "lima";
		
		
		String UP_NAME = "aupdate";
		String UP_DESC = "aupdate";
		String UP_CITY = "surco";
		
		try {
			//
			departmentDAO.create(NAME, DESC, CITY);
			//
			departmentDAO.update(UP_NAME, UP_DESC,UP_CITY);
			//
			Department emp = departmentDAO.findDepartmentByName(NAME);

			Assert.assertEquals(UP_NAME, emp.getName());
			Assert.assertEquals(UP_DESC, emp.getDescription());
			Assert.assertEquals(UP_CITY, emp.getCity());

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}
	
	
	@Test
	public void testDeleteDepartment() {

		String NAME = "departamento memes";
		String DESCRIPTION = "Uvuvwevwevwe ";
		String  CITY = "Osas";
		

		try {
			//
			departmentDAO.create(NAME, DESCRIPTION, CITY);

		} catch (DAOException e) {
			fail(e.getMessage());
		}

		try {

			departmentDAO.delete(NAME);

			departmentDAO.findDepartmentByName(NAME);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyResultException e) {
			// Usuario borrado 
			return;
		}

	}
	
	@After
	public void after() {
		logger.info("Despues de cada metodo");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.info("Despues de todos los metodos");
	}
}


