package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Semester1;
import com.task.model.Semester2;
import com.task.model.Student;
import com.task.pojo.Averagesmarkssem1;
import com.task.serviceimpl.Myservice;

@RestController
public class Mycontroller {
	
	@Autowired
	Myservice myservice;
	
	@PostMapping("/addstudent")
	public String addStudent(@RequestBody Student student){
		String value = myservice.addstudent(student);
		return value;
	}
	
	@GetMapping("/averagepercentage/sem1")
	public double AveragePercentagesem1() {
		double getaveragepercentage = myservice.getaveragepercentagesem1();
		return getaveragepercentage;
	}
	
	@GetMapping("/averagepercentage/sem2")
	public double AveragePercentagesem2() {
		double getaveragepercentage = myservice.getaveragepercentagesem2();
		return getaveragepercentage;
	}
	
	@GetMapping("/getalldetailsSortingWithfield/{field}")
	public List<Student> getalldetailssortingwithfield(@PathVariable String field) {
		List<Student> getalldetails = myservice.getalldetails(field);
		return getalldetails;
	}
	
	@GetMapping("/getalldetailsWithPaginatation/{offset}/{pageSize}")
	public Page<Student> getalldetailsWithPaginatation(@PathVariable int offset,@PathVariable int pageSize) {
		Page<Student> getalldetails = myservice.getalldetails(offset,pageSize);
		return getalldetails;
	}
	
	
//	@GetMapping("/AveragemarksEachSubject/sem1")
//	public  List<Double> Getavergaemarkssem1() {
//		 List<Double> averagemarksem1 = myservice.averagemarksem1();
//		return averagemarksem1;
//	}
	
	@GetMapping("/AveragemarksEachSubject/sem1")
	public  Averagesmarkssem1 Getavergaemarkssem1() {
		Averagesmarkssem1 averagemarksem1 = myservice.averagemarksem1();
		return averagemarksem1;
	}
	
//	@GetMapping("/AveragemarksEachSubject/sem2")
//	public Object Getavergaemarkssem2() {
//		Object averagemarksem2 = myservice.averagemarksem2();
//		return averagemarksem2;
//		
//	}
	
}
