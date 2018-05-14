package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.DepartmentDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public Department find(int department_id) throws DAOException, EmptyResultException {

		Department dpt = departmentDAO.findDepartment(department_id);

		return dpt;
	}

	@Override
	public List<Department> findAll() throws DAOException, EmptyResultException {

		List<Department> dpts = departmentDAO.findAllDepartment();

		return dpts;
	}

	@Override
	public void update(String name, String description, String city)
			throws DAOException {

		departmentDAO.update(name, description, city);
	}

	
}
