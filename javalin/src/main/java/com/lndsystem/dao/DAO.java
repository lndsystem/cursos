package com.lndsystem.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.lndsystem.domain.Person;

public class DAO {

	private List<Person> people = new ArrayList<>(
			Arrays.asList(new Person(1, "Leonan", 22), new Person(2, "Wesley", 33), new Person(3, "Luiz", 30)));

	private Integer randomId() {
		return ThreadLocalRandom.current().nextInt();
	}

	public Person save(Person person) {
		person.setId(randomId());
		people.add(person);
		return person;
	}

	public List<Person> findAll() {
		return people;
	}

	public Person findById(Integer id) {
		return people.parallelStream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
	}
}
