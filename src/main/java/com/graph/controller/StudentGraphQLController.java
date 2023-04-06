package com.graph.controller;

import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graph.entities.Student;
import com.graph.services.StudService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
@Slf4j
@RestController
public class StudentGraphQLController {
    
    private final StudService StudeService;

   @Autowired
   public StudentGraphQLController(StudService StudeService) {
     this.StudeService = StudeService;
   }
   
  @QueryMapping("getAllStudents")
  @PreAuthorize("hasRole('USER')")
  Flux<Student> getAllStudents() {
	  
    log.info("Get all students using 'getAllStudents' query");
    return processWithLog(this.StudeService.getAllStudents());
  }

  @QueryMapping("getStudentById")
  @PreAuthorize("hasRole('USER')")
  Mono<Student> getStudentById(@Argument Integer id) {
    log.info("Get student by id using 'getStudentById' query");
    return processWithLog(this.StudeService.getStudentById(id));
  }

  @QueryMapping("getStudentByName")
  @PreAuthorize("hasRole('USER')")
  Mono<Student> getStudentByName(@Argument String name) {
    log.info("Get Student by name using 'getPlayerByName' query");
    return processWithLog(this.StudeService.getStudentByName(name));
  }

  @QueryMapping("getStudentsByEmail")
  @PreAuthorize("hasRole('USER')")
  Flux<Student> getStudentsByEmail(@Argument String email) {
    log.info("Get Student by email using 'getStudentsByEmail' query");
    return processWithLog(this.StudeService.getStudentsByEmail(email));
  }

  @QueryMapping("getStudentByMobile")
  @PreAuthorize("hasRole('USER')")
  Flux<Student> getStudentByMobile(@Argument String mobile) {
    log.info("Get Student by Mobile using 'getStudentByMobile' query");
    return processWithLog(this.StudeService.getStudentByMobile(mobile));
  }

  @MutationMapping("addStudent")
  @PreAuthorize("hasRole('ADMIN')")
  Mono<Student> addStudent(@Argument Student student) {
    log.info("Add Student using 'addStudent' mutation");
    return processWithLog(this.StudeService.addStudent(student));
  }

  @MutationMapping("updateStudent")
  @PreAuthorize("hasRole('ADMIN')")
  Mono<Student> updatePlayer(@Argument Integer id, @Argument Student student) {
    log.info("Updating Student using 'updateStudent' mutation");
    return processWithLog(this.StudeService.updateStudent(id, student));
  }

  @MutationMapping("deleteStudentById")
  @PreAuthorize("hasRole('ADMIN')")
  Mono<Student> deletePlayerById(@Argument Integer id) {
    log.info("Delete Student using 'deleteStudentById' mutation");
    return processWithLog(this.StudeService.deleteStudentById(id));
  }

  @MutationMapping("deleteStudentByName")
  @PreAuthorize("hasRole('ADMIN')")
  Mono<Student> deletePlayerById(@Argument String name) {
    log.info("Delete Student using 'deleteStudentByName' mutation");
    return processWithLog(this.StudeService.deleteStudentByName(name));
  }

  private <T> Mono<T> processWithLog(Mono<T> monoToLog) {
    return monoToLog
        .log("StudentGraphQLController.", Level.INFO, SignalType.ON_NEXT, SignalType.ON_COMPLETE);
  }

  private <T> Flux<T> processWithLog(Flux<T> fluxToLog) {
    return fluxToLog
        .log("StudentGraphQLController.", Level.INFO, SignalType.ON_NEXT, SignalType.ON_COMPLETE);
  }
  
  
  
  
  
  
  
  
  

}

