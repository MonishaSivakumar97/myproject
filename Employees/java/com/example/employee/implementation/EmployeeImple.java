package com.example.employee.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.employee.VO.Department;
import com.example.employee.VO.ResponseTemplate;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@Component
public class EmployeeImple implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Employee add(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> list() {
		return empRepo.findAll();
	}

	@Override
	public Employee searchById(long id) {
		return empRepo.findById(id);
	}

	@Override
	public ResponseTemplate empWithDept(long empId) {
		ResponseTemplate RT = new ResponseTemplate();
		Employee emp = empRepo.findById(empId);
		
		long dept_id = emp.getDept_id();
		Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+dept_id, Department.class);
		RT.setDepartment(dept);
		RT.setEmployee(emp);
		return RT;
	}

	@Override
	public Employee assignDepartment(long empId, long deptId) {
		Employee emp = empRepo.findById(empId);
		Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+deptId, Department.class);
		if(emp==null || dept==null)
		{
			return null;
		}
		emp.setDept_id(deptId);
		empRepo.save(emp);
		return emp;
	}

	@Override
	public List<Employee> getByDeptId(long dept_id) {
		return empRepo.getByDeptId(dept_id);
	}

	@Override
	public List<Employee> getEmployeeByDepartmentWithDescAge(long dept_id) {
		return empRepo.getEmployeeByDepartmentWithDescAge(dept_id);
	}
	

}
