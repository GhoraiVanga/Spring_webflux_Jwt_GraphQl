package com.graph.services;



import com.graph.entities.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudService {

	  Mono<Student> getStudentById(Integer id);
	  Mono<Student> getStudentByName(String name);
	  Flux<Student> getAllStudents();
	  Flux<Student> getStudentsByEmail(String email);
	  Flux<Student> getStudentByMobile(String mobile);
	  Mono<Student> addStudent(Student student);
	  Mono<Student> updateStudent(Integer id, Student student);
	  Mono<Student> deleteStudentById(Integer id);
	  Mono<Student> deleteStudentByName(String name);
	
}