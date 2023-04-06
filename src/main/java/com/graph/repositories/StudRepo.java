package com.graph.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.graph.entities.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository

public interface StudRepo extends  ReactiveCrudRepository<Student,Integer> {
	
	  Mono<Student> findByName(String name);
	  Mono<Student> deleteByName(String name);
	  Flux<Student> findByGender(String gender);
	  Flux<Student> findByEmail(String email);
	  Flux<Student> findByMobile(String mobile);
	  

}
