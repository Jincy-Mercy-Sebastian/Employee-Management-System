package com.jthread.employeemanagement.test;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jthread.employeemanagement.model.Address;
import com.jthread.employeemanagement.model.Department;
import com.jthread.employeemanagement.model.Employee;
import com.jthread.employeemanagement.model.Project;
import com.jthread.employeemanagement.model.Task;
import com.jthread.employeemanagement.repository.DepartmentRepository;
import com.jthread.employeemanagement.repository.EmployeeRepository;
import com.jthread.employeemanagement.repository.ProjectRepository;
import com.jthread.employeemanagement.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class TestRunner implements CommandLineRunner{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		createProject();	
//		createTask();
//		updateTaskWithProjectId();
		
//		createDepartment();
//		createEmployee();
		
//		assignEmployeeToDepartment();
//		assignEmployeeToProject();
		
	}


	private void assignEmployeeToProject() {
		Optional<Employee> empContainer= employeeRepository.findById(1);
		Optional<Project> projContainer= projectRepository.findById(2);
		Set<Project> empjSet=new HashSet<>();
		Set<Project> projSet=new HashSet<>();
		if( empContainer.isPresent())
		{	
			Employee emp=empContainer.get();
			emp.getProjects().forEach(p->projSet.add(p));
			if (projContainer.isPresent()) {
				Project proj = projContainer.get();
				projSet.add(proj);
				emp.setProjects(projSet);
				employeeRepository.save(emp);
			
			}
		
		}
	}

	private void assignEmployeeToDepartment() {
		Optional<Employee> empContainer= employeeRepository.findById(3);
		Optional<Department> depContainer= departmentRepository.findById(3);
		if(empContainer.isPresent() && depContainer.isPresent())
		{	
			
			Employee emp=empContainer.get();
			Department dep=depContainer.get();
			emp.setDepartment(dep);
			employeeRepository.save(emp);
		}
	}


	private void createEmployee() {
//		Address add1= new Address("Perambra", "Kozhikode","Kerala", 645109);
//		Employee emp1=new Employee("Abhiraj", "k", "abhiraj.k@gmail.com", 40000, add1);	
//		employeeRepository.save(emp1);
//		
		Address add2= new Address("Thalore", "Trissur","Kerala", 689032);
		Employee emp2=new Employee("Sree", "Lakshmi", "sreelakshmi@gmail.com", 30000, add2);		
		employeeRepository.save(emp2);
		
		Address add3= new Address("Palayam", "Thiruvananthapuram","Kerala", 690522);
		Employee emp3=new Employee("Athul", "Ronaldo", "Athul.Ronaldo@gmail.com", 45000, add3);
		
		employeeRepository.save(emp3);
	}


	private void createDepartment() {
		Department d1=new Department("Telecommunications", "Ierland");
		Department d2=new Department("AI", "Netharland");
		Department d3=new Department("Finance", "United Kingdon");
		departmentRepository.save(d1);
		departmentRepository.save(d2);
		departmentRepository.save(d3);
		
	}


	private void updateTaskWithProjectId() {
		Optional<Task> task=taskRepository.findById(5);
		if(task.isPresent()) {
			Task t=task.get();
			Optional<Project> p=projectRepository.findById(3);
			t.setProject(p.get());
			taskRepository.save(t);
		};
		
		Optional<Task> task2=taskRepository.findById(6);
		if(task.isPresent()) {
			Task t=task2.get();
			Optional<Project> p=projectRepository.findById(3);
			t.setProject(p.get());
			taskRepository.save(t);
		}
	}


	private void createProject() {
		
		Task t1=new Task("IDM-768 : Project release", LocalDate.of(2025, 3, 9));
		Task t2=new Task("IDM-917 : Performance improvement", LocalDate.of(2025, 04, 20));
		Set<Task> taskSet=new HashSet<Task>();
		taskSet.add(t1);
		taskSet.add(t2);
		
		Project project=new Project("HorizonGo", 4500000, taskSet);
		projectRepository.save(project);	
		
	}
}
