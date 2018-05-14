package com.tecsup.gestion.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tecsup.gestion.dao.DepartmentDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.exception.LoginException;
import com.tecsup.gestion.mapper.DepartmentMapper;
import com.tecsup.gestion.mapper.EmployeeMapper;
import com.tecsup.gestion.model.Department;
import com.tecsup.gestion.model.Employee;

@Repository

public class DepartmentDAOImpl implements DepartmentDAO{

	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public Department findDepartment(int department_id) throws DAOException, EmptyResultException {

		
		String query = "SELECT department_id, name, description, city "
				+ " FROM departments WHERE department_id = ?";

		Object[] params = new Object[] { department_id };

		try {

			Department dpt = (Department) jdbcTemplate.queryForObject(query, params, new DepartmentMapper());
			//
			System.out.println("Buscar departamento por id");

			return dpt;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


	@Override
	public void create(String name, String description, String city) throws DAOException {

		String query = "INSERT INTO departments (name, description, city)  VALUES ( ?,?,? )";

		Object[] params = new Object[] { name, description, city};
		System.out.println("Crear departamento ");

		Department dpt = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			dpt = this.findDepartmentByName(name);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		

	}

	@Override
	public void delete(String name) throws DAOException {

		String query = "DELETE FROM  departments WHERE name = ? ";

		Object[] params = new Object[] { name };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(String  name, String description, String city) throws DAOException {

		String query = "UPDATE departments SET name = ?, description =?, city = ? WHERE login = ?";

		Object[] params = new Object[] { name, description, city};
		System.out.println("Actualizar  departamento ");

		try {
			
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


	@Override
	public Department findDepartmentByName(String name) throws DAOException, EmptyResultException {

		String query = "SELECT department_id, name, description, city "
				+ " FROM departments WHERE name = ? ";
		System.out.println("Buscar   departamento por name ");

		Object[] params = new Object[] { name };

		try {

			Department department = jdbcTemplate.queryForObject(query, params, new DepartmentMapper());
			//
			return department;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public List<Department> findAllDepartment() throws DAOException, EmptyResultException {

		String query = "SELECT department_id, name, description, city FROM departments ";

		try {

			List<Department> departments = jdbcTemplate.query(query, new DepartmentMapper());
			//
			return departments;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Department> findDepartmentByCity(String city) throws DAOException, EmptyResultException {

		
		System.out.println("Buscar   departamento por city ");

		String query = "SELECT department_id, name, description, city "
				+ " FROM departments WHERE upper(city) like upper(?) ";

		Object[] params = new Object[] { "%" + city + "%" };

		try {

			List<Department> departments = jdbcTemplate.query(query, params, new DepartmentMapper());
			//
			return departments;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


}
