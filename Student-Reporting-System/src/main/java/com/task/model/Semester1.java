package com.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Semester1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int Math;
	int English;
	int Science;
	
	

}
