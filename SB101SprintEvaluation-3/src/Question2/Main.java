package Question2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;





public class Main {

	public static void main(String[] args) throws Exception {
		
//		@params(int studentId, String studentName, String studentAddress, String student_email, String studentPassword) 
		Student student1 = new Student(1, "Ram", "Delhi", "ram@masai.com", "123");
		Student student2 = new Student(2, "Sam", "Mumbai", "sam@masai.com", "124");
		Student student3 = new Student(3, "John", "Pune", "john@masai.com", "125");
		Student student4 = new Student(4, "David", "Bangalore", "david@masai.com", "126");
		Student student5 = new Student(5, "Mark", "Kerala", "mark@masai.com", "127");
		
		StudentDB studentDB = new StudentDB();
		studentDB.addStudent(student1);
		studentDB.addStudent(student2);
		studentDB.addStudent(student3);
		studentDB.addStudent(student4);
		studentDB.addStudent(student5);
		
		
		FileOutputStream fos = new FileOutputStream("dataBase.txt"); 
		ObjectOutputStream os = new ObjectOutputStream(fos); 
		
		os.writeObject(studentDB);
		os.flush();
		os.close();
		
		/* Deserialization */
		FileInputStream fis = new FileInputStream("dataBase.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fis); 
		
		Object obj = objectInputStream.readObject();
		
		StudentDB deserializedObject = (StudentDB) obj;
		
        System.out.println("object is deserialized");
        
        for (Student s : deserializedObject.studentData) {
        	System.out.println(s);
        }
		
	}

}


/*
Now create a Main class with the main method and create 5 student objects by collecting data from the
user and store them into studentsData of StudentDB class by using addStudent(). 

Then serialize the StudentDB object into “dataBase.txt” in the current location.
Note:- make sure while serializing don't serialize the password field and studentsData should not accept duplicates.

Deserialize the StudentDB object from the "dataBase.txt" file and print all the details of the
Students from studentList.



				Student [studentId=1, studentName=Ram, studentAddress=Delhi, student_email=ram@masai.com, studentPassword=null]
				Student [studentId=2, studentName=Sam, studentAddress=Mumbai, student_email=sam@masai.com, studentPassword=null]
				Student [studentId=3, studentName=John, studentAddress=Pune, student_email=john@masai.com, studentPassword=null]
				Student [studentId=4, studentName=David, studentAddress=Bangalore, student_email=david@masai.com, studentPassword=null]
				Student [studentId=5, studentName=Mark, studentAddress=Kerala, student_email=mark@masai.com, studentPassword=null]
*/
