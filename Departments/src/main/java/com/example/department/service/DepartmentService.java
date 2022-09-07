package com.example.department.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.department.VO.RequestTemplate;
import com.example.department.entity.Department;

@Service
public interface DepartmentService {
	Department add(Department dept);
	List<Department> list();
	Department update(long id,String name);
	Department searchById(long id);
	List<RequestTemplate> listWithEmp();
	RequestTemplate specificDeptEmployee(long dept_id);
}
