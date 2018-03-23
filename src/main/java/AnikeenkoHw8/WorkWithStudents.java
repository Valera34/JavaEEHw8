package AnikeenkoHw8;

import org.springframework.beans.factory.annotation.Autowired;

import AnikeenkoHw8.Student;
import AnikeenkoHw8.StudentsDao;

public class WorkWithStudents {
@Autowired
private StudentsDao studentsDao;

public void saveStudentToDb(Student student){
if ((student!=null)&&(student.getPib()!=null)&&(!"".equals(student.getPib()))&&(student.getCourse()>0)){
studentsDao.addStudent(student);
System.out.println("Student have been saved "+student.toString());
}

}

public Student getStudentFromDbById(int id) {
	Student st= studentsDao.getStudentById(id);
	return st;
}

}
