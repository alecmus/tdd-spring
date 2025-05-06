package com.github.alecmus.tddspring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class TddSpringApplicationTests {

	@Test
	void contextLoads() {
		assertDoesNotThrow(() -> {});
	}

}
