package com.finalproject.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "Mayman123123";
		String encodedPasword = encoder.encode(rawPassword);
		System.out.println(encodedPasword);

	}

}
