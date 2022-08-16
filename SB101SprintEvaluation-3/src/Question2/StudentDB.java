package Question2;

import java.io.Serializable;
import java.util.HashSet;

public class StudentDB implements Serializable {
	
	HashSet<Student> studentData = new HashSet<>();
	
	public void addStudent(Student student) { // this method simply adds students into the studentsData Set.
		
		studentData.add(student);
	} 
	
	
}
