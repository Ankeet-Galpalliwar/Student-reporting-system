package com.task.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.task.model.Semester1;
import com.task.model.Semester2;
import com.task.model.Student;
import com.task.pojo.Averagesmarkssem1;
import com.task.repository.studentrepositry;

@Service
public class Myservice {

	@Autowired
	studentrepositry studentrepositry;

	public String addstudent(Student student) {
		double percentage2 = ((student.getSemester2().getScience() + student.getSemester2().getEnglish()
				+ student.getSemester2().getMath()) * 100) / 300;
		double percentage1 = ((student.getSemester1().getScience() + student.getSemester1().getEnglish()
				+ student.getSemester1().getMath()) * 100) / 300;

		student.setSem2_persentage(percentage2);
		student.setSem1_persentage(percentage1);
		// System.err.println(percentage);
		// System.err.println(student.getSemester2().getScience()+".."+student.getSemester2().getEnglish()+".."+student.getSemester2().getMath());
		Student save = studentrepositry.save(student);
		if (save == null) {
			return "Data not added ";
		}
		return "Data added sucessfully";
	}

	public double getaveragepercentagesem1() {
		List<Student> findAll = studentrepositry.findAll();
		double sem1_averagepercentage = studentrepositry.findsem1_averagepercentage();
		return sem1_averagepercentage;

	}

	public double getaveragepercentagesem2() {
		List<Student> findAll = studentrepositry.findAll();
		double sem1_averagepercentage = studentrepositry.findsem2_averagepercentage();
		return sem1_averagepercentage;
	}

	public List<Student> getalldetails(String field) {
		List<Student> findAll = studentrepositry.findAll(Sort.by(Sort.Direction.DESC,field));
		return findAll;
	}

	public Page<Student> getalldetails(int offset, int pageSize) {
		Page<Student> findAll = studentrepositry.findAll(PageRequest.of(offset, pageSize));
		return findAll;
	}

//	public List<Double> averagemarksem1() {
//         List<Double> findaveragessem1 = studentrepositry.findaveragessem1();
//		return findaveragessem1;		
//	}
	
	public Averagesmarkssem1 averagemarksem1() {
		Averagesmarkssem1 findaveragessem1 = studentrepositry.findaveragessem1();
		return findaveragessem1;		
	}



//	public Object averagemarksem2() {
//		Object findAverages_sem2 = studentrepositry.findAverages_sem2();
//		return findAverages_sem2;
//		
//	}

}
