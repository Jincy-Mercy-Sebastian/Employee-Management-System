package com.jthread.employeemanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.jthread.employeemanagement.dto.EmployeesInDepartmentDto;
import com.jthread.employeemanagement.exception.ResourceNotFoundException;
import com.jthread.employeemanagement.model.Employee;
import com.jthread.employeemanagement.repository.DepartmentRepository;
import com.jthread.employeemanagement.repository.EmployeeRepository;
import com.jthread.employeemanagement.service.DepartmentServiceImpl;
import com.jthread.employeemanagement.service.EmployeeServiceImpl;


@SpringBootTest
class EmployeemanagementApplicationTests {

	@Test
	void contextLoads() {  //to verify that the Spring context can be loaded correctly. When the application context is loaded, it means that the Spring Boot application configuration (e.g., beans, services, repositories) is set up and ready for use. This is particularly useful for integration testing.
	}

    @Mock
    private DepartmentRepository departmentRepository; //for dependencies of the class to be tested
    
    @InjectMocks
    private DepartmentServiceImpl departmentService; //for injecting the mocks into your service class. 

    @BeforeEach				//This is set up correctly to initialize mocks before each test.
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindEmployeeInDepartment() throws ResourceNotFoundException {
        String departmentName = "Engineering";
        Employee employee1 = new Employee( "John Doe", "Engineering", departmentName, null);
        Employee employee2 = new Employee( "Jane Smith", "AI", departmentName, 25000);
        EmployeesInDepartmentDto emp1 = new EmployeesInDepartmentDto(1,"John", "Doe", "JohnDoe@hmail.com", 001, "Engineering");
        EmployeesInDepartmentDto emp2 = new EmployeesInDepartmentDto(2,"Jane", "Smith", "JaneSmith@gmail.com", 001, "AI");
		List<EmployeesInDepartmentDto> employees = Arrays.asList(emp1);

        when(departmentRepository.findEmployeesInDepartment("Engineering")).thenReturn(employees);

        List<EmployeesInDepartmentDto> result = departmentService.findEmployeesInDepartment(departmentName);

        //The assertions check whether the list is not null, the size is correct, and the first names match the expected values.
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());
//        assertEquals("Jane", result.get(1).getFirstName());
    }

    // Add more test cases as needed
}
