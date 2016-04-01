package br.com.sga.backend.business;

import java.util.List;

import br.com.sga.backend.dao.StudentDao;
import br.com.sga.backend.model.Student;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentBusiness {

	private final StudentDao studentDao;

	public StudentBusiness(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public List<Student> listStudents(){
		return studentDao.getAll();
	}

	public void createStudent(Student student) {
		studentDao.save(student);
	}
}
