package com.school.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {

	@ManyToMany(mappedBy = "classes")
    private Set<School> students = new HashSet<>();

	
	
	@Id
	@Column(name = "class_id")
	private long ClassId;
	
	@Column(name = "class_name")
	private String ClassName;
	
    @Column(name = "class_count")
	@Embedded
	private long ClassCount;

    
	@Override
	public String toString() {
		return "Class [ClassId=" + ClassId + ", ClassName=" + ClassName + ", ClassCount=" + ClassCount + "]";
	}

	public long getClassId() {
		return ClassId;
	}

	public void setClassId(long classId) {
		ClassId = classId;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public long getClassCount() {
		return ClassCount;
	}

	public void setClassCount(long classCount) {
		ClassCount = classCount;
	}
	
  

}
