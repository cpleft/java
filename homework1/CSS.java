/** class Book, Course, Student
 * @author 杨谊 16130120200 429426523@qq.com
 * Thu Oct 25 20:23:18 CST 2018
 */
import java.util.ArrayList;

public class CSS 
{
  public static void main(String[] args) {
    Student stu = new Student(args);
  }
}

class Book 
{
  String book_name;
  Book(String book_name) {
    this.book_name = book_name;
  }
}

class Course 
{
  String course_name;
  Course(String course_name) {
    this.course_name = course_name;
  }
}

class Student 
{
  public String student_name;
  public ArrayList<Course> student_course = new ArrayList<Course>();
  public ArrayList<Book> student_book = new ArrayList<Book>();

  public Student() {
    student_name = "0";
  }
  public Student(String student_name) {
    this.student_name = student_name;
    System.out.println("The student has not selected a course!");
  }
  public Student(String[] s) {
    System.out.print(s[0] + " ");
    // add courses from Command-Line args
    for (int i = 1; i < s.length; i++) {
      Course c = new Course(s[i]);
      student_course.add(c);
    }

    // add books for each course
    for (Course i:student_course) {
      switch (i.course_name) {
        case "Java": 
          System.out.print("select Java with books Thinking in Java, Java 8, ");
          break;
        case "C++": 
          System.out.print("select C++ with books Thinking in C++, ");
          break; 
        case "WebEngineering": 
          System.out.print("select WebEngineering with books Thinking in C++, ");
          break; 
        default: 
          System.out.print("select " + i.course_name + " with other books, ");
          break;
      }
    }
    System.out.println();
  }
}
