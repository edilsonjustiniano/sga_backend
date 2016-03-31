package br.com.sga.backend.api;

import java.util.List;

import br.com.sga.backend.model.Student;

public interface StudentService {

	List<Student> listStudents();
	
	void createStudent(Student student);
}
