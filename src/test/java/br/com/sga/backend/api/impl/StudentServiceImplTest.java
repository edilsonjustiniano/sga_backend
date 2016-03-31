package br.com.sga.backend.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.sga.backend.business.StudentBusiness;
import br.com.sga.backend.model.Student;
import br.com.sga.backend.validator.StudentValidator;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {
	
	@Mock
	private StudentValidator studentValidator;
	
	@Mock
	private StudentBusiness studentBusiness;

	@InjectMocks
	private StudentServiceImpl studentServiceImpl;
	
	
	@Test
	public void shouldListStudents(){
		
		//Given
		List<Student> students = buildStudentList();
		BDDMockito.given(studentBusiness.listStudents()).willReturn(students);
		
		//When
		List<Student> result = studentServiceImpl.listStudents();
		
		//Then
		Assert.assertEquals(students, result);
	}
	
	private List<Student> buildStudentList(){
		ArrayList<Student> students = new ArrayList<Student>();
		Student student = new Student();
		student.setId(23L);
		student.setName("Sandro");
		students.add(student);
		return students;
	}
	
}
