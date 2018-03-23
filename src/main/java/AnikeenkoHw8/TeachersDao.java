package AnikeenkoHw8;

import java.util.List;

import com.entities.Teacher;

public interface TeachersDao {
void addTeacher(Teacher teacher);
Teacher getTeacherById(int id);
Teacher getTeacherValera();
List<Teacher> getTeacherAll();
void saveTacher(Teacher teacher);
}
