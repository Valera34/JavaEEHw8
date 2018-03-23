package AnikeenkoHw8;


import java.util.Date;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Teacher;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
    	WorkWithStudents worker = 
    	(WorkWithStudents) context.getBean("worker");
    	//new WorkWithStudents();
    	Student testStudent = new Student("Vlad Valt", 5);
    	worker.saveStudentToDb(testStudent);
    	WorkWithTeacher workWithTeacher = 
    			(WorkWithTeacher) context.getBean("teachersWorker");
    			Teacher teacher = new Teacher();
    			teacher.setFirstname("Andrii");
    			teacher.setLastname("Glybovets");
    			teacher.setCellphone("+380675097865");
    			teacher = workWithTeacher.addTeacher(teacher);
    			teacher.setBirthDate(new Date());
    			workWithTeacher.saveTacher(teacher);
    			System.out.println("[");
    			workWithTeacher.getTeacherById(1);
    			workWithTeacher.getTeacherValera();
    			workWithTeacher.getTeacherAll();
    			System.out.println("]");
    			
    			Student student = worker.getStudentFromDbById(1);
    			student = worker.getStudentFromDbById(1);
    			System.out.println(student);
    			CacheManager cm = new CacheManager();
    			Cache cache = cm.getCache("studentsCache");
    		    student = worker.getStudentFromDbById(2);
    		    student = worker.getStudentFromDbById(2);
    		    student = worker.getStudentFromDbById(1);
            	System.out.println(cache.getName());
            	System.out.println(student);
    			
    	
    		    
    			


    }
}

