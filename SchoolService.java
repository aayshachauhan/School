package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.School;
import com.school.repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolrepository;

	public List<School> getStudent() {

		List<School> students = schoolrepository.findAll();

		return students;

	}

	public School getStudent(Long studentID) {
		School sh = null;
		Optional<School> findById = schoolrepository.findById(studentID);
		if (findById.isPresent()) {
			sh = findById.get();
		}

		return sh;

	}

	public School addStudent(School student) {
		schoolrepository.save(student);

		return student;
	}

	public School updateStudent(School student) {
		schoolrepository.save(student);

		return student;
	}

	
	
	

	public void deleteStudent(long studentID) {

		School entity = schoolrepository.getOne(studentID);

		schoolrepository.delete(entity);
		
	}


	
	
	
	
	
	
	
	
	
	
}
