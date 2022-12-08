package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.task.model.Student;
import com.task.pojo.Averagesmarkssem1;

@Repository
@EnableJpaRepositories
public interface studentrepositry extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT AVG(sem1_persentage) FROM Student")
	double findsem1_averagepercentage();

	@Query(value = "SELECT AVG(sem2_persentage) FROM Student")
	double findsem2_averagepercentage();


//	@Query(value = "SELECT AVG(english),AVG(math),AVG(science)  FROM Semester1")
//	List<Double> findaveragessem1();
	
	@Query(value = "SELECT AVG(english),AVG(math),AVG(science)  FROM Semester1")
	Averagesmarkssem1 findaveragessem1();
	
	
//	@Query(value = "SELECT AVG(english),AVG(math),AVG(science)  FROM Semester2")
//	Object findAverages_sem2();

}
