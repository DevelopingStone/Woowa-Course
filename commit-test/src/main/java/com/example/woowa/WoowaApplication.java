package com.example.woowa;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class WoowaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoowaApplication.class, args);
	}


}



class Main {

	public static void main(String[] args) {

		Console.readLine();
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);


		Collections.sort(numbers);
		System.out.println("numbers = " + numbers);

	}
}
