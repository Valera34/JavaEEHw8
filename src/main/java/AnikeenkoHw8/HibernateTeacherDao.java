package AnikeenkoHw8;


import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Teacher;

@Repository
public class HibernateTeacherDao implements TeachersDao{
@Autowired
private SessionFactory sessionFactory;


private Session currentSession(){
return sessionFactory.getCurrentSession();
}
public void addTeacher(Teacher teacher) {
currentSession().save(teacher);
}
public Teacher getTeacherById(int id) {
	  Query query = currentSession().getNamedQuery("findWithParam");
	  query.setParameter("fid", id);
	  @SuppressWarnings("unchecked")
	  Teacher res = (Teacher) query.uniqueResult();
	  System.out.println("Teacher has been get from table "+res.toString());
return res;
}
public Teacher getTeacherValera() {
	  Query query = currentSession().getNamedQuery("findValera");
	  @SuppressWarnings("unchecked")
	  Teacher res = (Teacher) query.uniqueResult();
	  System.out.println("Teacher has been get from table "+res.toString());
return res;
}
public List<Teacher> getTeacherAll() {
	Query query = currentSession().getNamedQuery("findAll");
	  @SuppressWarnings("unchecked")
	  List<Teacher> res =  query.list();
	  System.out.println("Teacher has been get from table "+res.toString());
return res;
}
public void saveTacher(Teacher teacher) {
currentSession().update(teacher);
}
}
