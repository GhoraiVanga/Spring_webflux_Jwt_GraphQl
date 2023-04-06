package com.graph.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graph.entities.Student;
import com.graph.exception.EntityMappingException;
import com.graph.repositories.StudRepo;
import com.graph.services.StudService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class StudentServiceImpl implements StudService {
	
	 private final StudRepo sRepo;
    
    @Autowired
    public StudentServiceImpl(StudRepo sRepo) {
      this.sRepo = sRepo;
    }
	
	@Override
	public Mono<Student> getStudentById(Integer id) {
		
		 final String errorMessage = "There is an issue getting all of Students.";
	     return (this.processWithErrorCheck(this.sRepo.findById(id), errorMessage));
	
	}

	@Override
	public Mono<Student> getStudentByName(String name) {
		final String errorMessage = String.format("There is no student with name: '%s'", name);
	    return processWithErrorCheck(this.sRepo.findByName(name), errorMessage);
	}

	@Override
	public Flux<Student> getAllStudents() {
		
		    final String errorMessage = "There is an issue getting all of Students.";
		    return processWithErrorCheck(this.sRepo.findAll(), errorMessage);	
	}

	@Override
	public Flux<Student> getStudentsByEmail(String email) {
	
		
	    final String errorMessage = String.format("There is no email for Student: '%s'", email);
	    return processWithErrorCheck(this.sRepo.findByEmail(email), errorMessage);
	}

	@Override
	public Flux<Student> getStudentByMobile(String mobile) {
		 final String errorMessage = String.format("There is no mobile for Student: '%s'", mobile);
		    return processWithErrorCheck(this.sRepo.findByMobile(mobile), errorMessage);
	}

	@Override
	public Mono<Student> addStudent(Student student) {
		
		final String errorMessage = "Unable to add student with input:" + student;
	    return processWithErrorCheck(this.sRepo.save(student), errorMessage);
	
	}

	@Override
	public Mono<Student> deleteStudentById(Integer id) {
		return getStudentById(id).map(student -> {
		      this.sRepo.deleteById(id).subscribe();
		      return student;
		    });
		
	}

	@Override
	public Mono<Student> deleteStudentByName(String name) {
		return getStudentByName(name).map(student -> {
		      this.sRepo.deleteByName(name).subscribe();
		      return student;
		    });
	}

	
	  private <T> Mono<T> processWithErrorCheck(Mono<T> monoToCheck, String errorMessage) {
		    return monoToCheck.switchIfEmpty(Mono.defer(() -> {
		      log.error(errorMessage);
		      return Mono.error(new EntityMappingException(errorMessage));
		    }));
		  }

		  private <T> Flux<T> processWithErrorCheck(Flux<T> fluxToCheck, String errorMessage) {
		    return fluxToCheck.switchIfEmpty(Flux.defer(() -> {
		      log.error(errorMessage);
		      return Flux.error(new EntityMappingException(errorMessage));
		    }));
		  }

		@Override
		public Mono<Student> updateStudent(Integer id, Student student) {
			
			return null;
		}
	

}

