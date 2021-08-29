package com.p3d50.personapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PersonapiApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void isShoudAddTwoNumber() {
		// given
		int numberOne =20;
		int numberTwo = 30;

		//whe
		int result = underTest.add(numberOne,numberTwo);

		//then
		int expected=50;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator {
		int add(int a,int b){return a+b;}
	}

}
