package ui;

import employee.beans.*;
import employee.exceptions.*;
import java.util.*;

public class EmployeeMain {

	 private Map<Integer, Employee> store = new HashMap<>();

	    public static void main(String args[]) {
	        EmployeeMain project = new EmployeeMain();
	        project.run();
	    }


	    public void run() {
	        try {
	            Department department1 = new Department("d1", "IT");
	            Department department2 = new Department("d2", "NON IT");
	            System.out.println(department1);
	            addDeveloper(1, "Siddharth",department1 ,"JAVA" );
	            addDeveloper(2, "ABCD",department2, "DBMS");

	            addTester(3, "EFGH", 50, department3,"IDE");
	            addTester(4, "IJKL", 90, course2, "");
	            

	            int inputId = 1;
	            Student student = findStudentById(inputId);
	            System.out.println("student for id=" + inputId);

	            if (student instanceof EceStudent) {
	                EceStudent eceStudent = (EceStudent) student;
	                displayStudent(eceStudent);
	            }
	            if (student instanceof CseStudent) {
	                CseStudent cseStudent = (CseStudent) student;
	                displayStudent(cseStudent);
	            }

	            removeStudentById(-20);

	            displayAll();


	        } catch (StudentNotFoundException e) {
	            System.out.println("sorry student not found");
	            System.out.println(e.getMessage());
	        } catch (InvalidIdException e) {
	            System.out.println("sorry it appears id you passed is invalid");
	            String msg = e.getMessage();
	            System.out.println(msg);
	        } catch (Exception e) {
	            System.out.println("something went wrong");
	        }
	    }

	    public void displayAll() {
	        System.out.println("*****display all student*******");
	        Collection<Student> students = store.values();
	        for (Student student : students) {
	            if (student instanceof EceStudent) {
	                EceStudent eceStudent = (EceStudent) student;
	                displayStudent(eceStudent);
	            }
	            if (student instanceof CseStudent) {
	                CseStudent cseStudent = (CseStudent) student;
	                displayStudent(cseStudent);
	            }
	        }
	    }


	    public void addEceStudent(int id, String name, int score, Course course, String device) {
	        EceStudent student = new EceStudent(id, name, score, course, device);
	        store.put(id, student);
	    }


	    public void addCseStudent(int id, String name, int score, Course course, String laptop, String lang) {
	        CseStudent student = new CseStudent(id, name, score, course, laptop, lang);
	        store.put(id, student);

	    }

	    public void validateId(int id) {
	        if (id < 0) {
	            throw new InvalidIdException("id is invalid " + id);
	        }

	    }

	    public Student findStudentById(int id) throws InvalidIdException, StudentNotFoundException {
	        validateId(id);
	        if (!store.containsKey(id)) {
	            throw new StudentNotFoundException("student not found for id=" + id);
	        }
	        Student student = store.get(id);
	        return student;
	    }

	    public void removeStudentById(int id) {
	        validateId(id);
	        store.remove(id);
	    }

	    void displayBaseStudent(Student student) {
	        int id = student.getId();
	        String name = student.getName();
	        int score = student.getScore();
	        Course course = student.getCourse();
	        String courseId = course.getCourseId();
	        String courseName = course.getCourseName();
	        System.out.println("student " + id + " " + name + " " + score);
	        System.out.println("course is " + courseId + " " + courseName);

	    }

	    void displayStudent(EceStudent student) {
	        displayBaseStudent(student);
	        String device = student.getDevice();
	        System.out.println("device=" + device);
	    }

	    void displayStudent(CseStudent student) {
	        displayBaseStudent(student);
	        String language = student.getLanguage();
	        String laptop = student.getLaptop();
	        System.out.println("laptop=" + laptop);
	        System.out.println("language=" + language);
	    }
}
