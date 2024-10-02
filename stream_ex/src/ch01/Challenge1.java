package ch01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge1 {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// 1. 짝수만 필터링하고 제곱하여 새로운 리스트로 반환
		List<Integer> result = numbers.stream().filter(n -> n % 2 == 0) // 짝수만 필터링
				.map(n -> n * n) // 제곱
				.collect(Collectors.toList()); // 리스트로 수집

		System.out.println(result); // 출력: [4, 16, 36, 64, 100]
	}
	}


