package com.task.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy= jakarta.persistence.GenerationType.IDENTITY)
	private int rollno;
	private String name;
	private int Standardt;
	private double sem1_persentage;
	private double sem2_persentage;

	@OneToOne(cascade = CascadeType.ALL)
	private Semester1 semester1;
	@OneToOne(cascade = CascadeType.ALL)
	private Semester2 semester2;
}

