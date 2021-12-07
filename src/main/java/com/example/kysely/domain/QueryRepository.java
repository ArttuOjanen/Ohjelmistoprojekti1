package com.example.kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface QueryRepository extends CrudRepository <Query, Long> {
	


}
