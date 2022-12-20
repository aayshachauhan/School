package com.school.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class School {
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(  name ="Student_class_master",
			joinColumns = { @JoinColumn(name = "student_config_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "class_config_id") }
			
			)
	//@JsonIgnore
    Set<Class> classes = new HashSet<>();

	
	@Id
	@Column(name = "student_id")
	private long studentID;
	
    @Column(name = "student_name")
	private String studentName;
	
    @Column(name = "course")
	private String course;

	@Override
	public String toString() {
		return "School [studentID=" + studentID + ", studentName=" + studentName + ", course=" + course
				+ ", getStudentID()=" + getStudentID() + ", getStudentName()=" + getStudentName() + ", getCourse()="
				+ getCourse() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public long getStudentID() {
		return studentID;
	}

	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
