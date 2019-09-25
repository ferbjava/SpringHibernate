package com.tomcat.springdemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DynamicFortuneService implements FortuneService {

	private List<String> fortunes;
	private Random random;

	@PostConstruct
	private void fillFortunesList() throws IOException {
		fortunes = new ArrayList<>();
		random = new Random();

		InputStream input = getClass().getClassLoader().getResourceAsStream("fortune.properties");
		Properties prop = new Properties();

		prop.load(input);
		prop.forEach((key, value) -> fortunes.add(value.toString()));
		
	}

	@Override
	public String getFortune() {
		int index = random.nextInt(fortunes.size());
		return fortunes.get(index);
	}

}
