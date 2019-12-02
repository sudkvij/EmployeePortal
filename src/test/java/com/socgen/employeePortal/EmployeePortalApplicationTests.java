package com.socgen.employeePortal;

//import org.junit.jupiter.api.Test;
import com.socgen.employeePortal.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeePortalApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Before
	public void setup() {

	}

	@Test
	void contextLoads() {
	}

}
