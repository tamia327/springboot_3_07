package com.example.springboot_3_07;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,
        Long> {
}
