package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Class;
import com.school.entity.School;
import com.school.repository.ClassRepository;

@Service
public class ClassService {

	private static final Class Class = null;
	@Autowired
	ClassRepository classrepository;

	public List<Class> getAllClass() {

		List<Class> students = classrepository.findAll();

		return students;

	}


	public Class addclass(Class classId) {
	classrepository.save(classId);

	return classId;
	}

	public Class updateclass(Class classId) {
		classrepository.save(classId);

		return classId;
	}
	

	public void deleteclass(long classID) {

		Class entity = classrepository.getOne(classID);

		classrepository.delete(entity);

	}

	public Class getClass(long classID) {
		Class sh = null;
		//Long classID=null;
		Optional<Class> findById = classrepository.findById(classID);
		if (findById.isPresent()) {
			sh = findById.get();
		}

		return sh;	}

	

}
