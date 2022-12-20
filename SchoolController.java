package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Class;
import com.school.entity.School;
import com.school.repository.SchoolRepository;
import com.school.service.ClassService;
import com.school.service.SchoolService;

@RestController
public class SchoolController {

	@Autowired
	SchoolService schoolservice;

	@Autowired
	ClassService classService;

	@Autowired
	SchoolRepository schoolrepository;

	@GetMapping("/test")
	public School testSchool() {
		School ok = null;
		return ok;
	}

	@PostMapping("/student")
	public School addStudent(@RequestBody School student) {
		return schoolservice.addStudent(student);
	}

	@GetMapping("/v1/student")
	public List<School> getStudent() {
		return schoolservice.getStudent();
	}

	@GetMapping("/getstudent/{studentID}")

	public School getstudent(@PathVariable String studentID) {

		return this.schoolservice.getStudent(Long.parseLong(studentID));

	}

	@PutMapping("/student")

	public School updatestudent(@RequestBody School student) {
		// logger.info("update student");
		return this.schoolservice.updateStudent(student);

	}

	@DeleteMapping("/deletstudent/{studentID}")

	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String studentID) {

		try {

			this.schoolservice.deleteStudent(Long.parseLong(studentID));

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/class")
	public Class addclass(@RequestBody Class classID) {
		return classService.addclass(classID);
	}

	@GetMapping("/v1/class")
	public List<Class> getAllClass() {
		return classService.getAllClass();
	}

	@GetMapping("/getClass/{classID}")
	public Class getclass(@PathVariable String classID) {

		return this.classService.getClass(Long.parseLong(classID));

	}

	@PutMapping("/class")

	public Class updateclass(@RequestBody Class classID) {
		// logger.info("update class");
		return this.classService.updateclass(classID);

	}

	@DeleteMapping("/deletclass/{classID}")

	public ResponseEntity<HttpStatus> deleteclass(@PathVariable String classID) {

		try {

			this.classService.deleteclass(Long.parseLong(classID));

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
