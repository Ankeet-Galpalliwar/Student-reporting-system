package com.task.pojo;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Averagesmarkssem1 {
	
    double english;
	double math;
	double science;
	
	public Averagesmarkssem1(double english, double math, double science) {
		super();
		this.english = english;
		this.math = math;
		this.science = science;
	}
	
	
	

}
