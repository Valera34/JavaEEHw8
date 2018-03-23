package AnikeenkoHw8;

import java.sql.ResultSet;
import java.sql.SQLException;


import javax.persistence.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.googlecode.ehcache.annotations.Cacheable;

import net.sf.ehcache.CacheManager;

//import net.sf.ehcache.Cache;


@Repository
public class JdbcStudentsDao implements StudentsDao{

private static final String SQL_INSERT_STUDENT = "insert into students (pib,course) values (?,?)";

@Autowired
private SimpleJdbcTemplate jdbcTemplate;

public void addStudent(Student student) {
jdbcTemplate.update(SQL_INSERT_STUDENT, 
student.getPib(),
student.getCourse());
}

private static final String SQL_SELECT_STUDENT_BY_ID = "select id, pib, course from students where id = ?";


@Cacheable( cacheName = "studentsCache")
public Student getStudentById(int id){

System.out.println("I am in cache");
return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID, 
new ParameterizedRowMapper<Student>() {
public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
Student student = new Student();
student.setStudentId(rs.getInt(1));
student.setPib(rs.getString(2));
student.setCourse(rs.getInt(3));
return student;
}
},id);
}

}
