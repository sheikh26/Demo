package com.example.demo.repo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	private Calculator c = new Calculator();

	@Test
    @Disabled
	void contextLoads() {
	}
	@Test
	@Disabled
    void testSum() {
        //expected
        int expectedResult = 17;
        //actual
        int actualResult = c.doSum(12, 3, 2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
