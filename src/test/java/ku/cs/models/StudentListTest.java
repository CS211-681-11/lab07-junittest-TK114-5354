package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList list;
    @BeforeEach
    void init(){
        list = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบ getStudents")
    void testGetStudents(){
        ArrayList<Student> l = new ArrayList<>();//arrayList ว่าง
        assertEquals(l,list.getStudents());
    }

    @Test
    @DisplayName("ทดสอบ Constructor")
    void testConstructor(){
        StudentList check = new StudentList();
        assertEquals(check.getStudents(),list.getStudents());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนเข้าไปใน StudentList")
    void testAddNewStudent(){
        list.addNewStudent("67xxxxxxx","test");
        assertEquals(l.getStudents().get(i).getId(),list.findStudentById("67xxxxxxx"));
    }

}