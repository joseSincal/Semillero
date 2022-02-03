package com.prac2.practica2;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Practica2ApplicationTests {

	@Test
	void contextLoads() {
		try {
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}

}
