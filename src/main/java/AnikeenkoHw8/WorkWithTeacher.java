package AnikeenkoHw8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.entities.Teacher;

//@Transactional

public class WorkWithTeacher {
@Autowired
private TransactionTemplate transactionTemplate;
@Autowired
private TeachersDao teachersDao;
public Teacher addTeacher(final Teacher teacher){
	transactionTemplate.execute(new TransactionCallback<Void>(){
		public Void doInTransaction(TransactionStatus txStatus){
		try{
		teachersDao.addTeacher(teacher);
		System.out.println("Teacher has been added "+teacher);
		}catch (RuntimeException e){
		txStatus.setRollbackOnly();
		throw e;
		}
		return null;
		}
		});
		return teacher;

}
Teacher teacher2;
public Teacher getTeacherById(final int id){
	transactionTemplate.execute(new TransactionCallback<Void>(){
		public Void doInTransaction(TransactionStatus txStatus){
		try{
		 teacher2 = teachersDao.getTeacherById(id);
		}catch (RuntimeException e){
		txStatus.setRollbackOnly();
		throw e;
		}
		return null;
		}
		});
	return teacher2;
}
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public Teacher getTeacherValera(){
return teachersDao.getTeacherValera();
}
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public List<Teacher> getTeacherAll() {
	return teachersDao.getTeacherAll();
}
public void saveTacher(final Teacher teacher){
	transactionTemplate.execute(new TransactionCallback<Void>(){
		public Void doInTransaction(TransactionStatus txStatus){
		try{
		teachersDao.saveTacher(teacher);
		System.out.println("Teacher has been added "+teacher);
		}catch (RuntimeException e){
		txStatus.setRollbackOnly();
		throw e;
		}
		return null;
		}
		});
}
}
