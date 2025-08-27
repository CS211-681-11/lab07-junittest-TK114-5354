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
        assertEquals("{id: '67xxxxxxx', name: 'test', score: 0.0}",String.valueOf(list.getStudents().get(0)));
        //ทดสอบใส่นักเรียนแบบไม่ใส่คะแนน

        list.addNewStudent("6710405354","Thanakrit",40);
        assertEquals("{id: '6710405354', name: 'Thanakrit', score: 40.0}",String.valueOf(list.getStudents().get(1)));
        //ทดสอบใส่นักเรียนแบบใส่คะแนน
    }

    @Test
    @DisplayName("ทดสอบการหานักเรียนด้วย ID")
    void testFindStudentById(){
        list.addNewStudent("67xxxxxxx","test");
        assertEquals(list.getStudents().get(0),list.findStudentById("67xxxxxxx"));//หานักเรียนด้วย ID 67xxxxxxx

        assertEquals(null,list.findStudentById("6710405354"));//หานักเรียนด้วย ID 6710405354
    }

    @Test
    @DisplayName("ทดสอบ filterByName")
    void testFilterByName(){
        list.addNewStudent("67xxxxxxx","test");
        assertEquals(list.getStudents(),list.filterByName("test").getStudents());//filler หานักเรียน test

        assertEquals("[]",String.valueOf(list.filterByName("Thanakrit").getStudents()));
        //filler หานักเรียน Thanakrit
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนผ่าน ID")
    void testGiveScoreToId(){
        list.addNewStudent("67xxxxxxx","test");
        list.giveScoreToId("67xxxxxxx",20);
        assertEquals(list.getStudents().get(0).getScore(),list.findStudentById("67xxxxxxx").getScore());
        //ทดสอบการให้คะแนนผ่าน ID 67xxxxxxx
        list.addNewStudent("6710405354","Thanakrit");
        list.giveScoreToId("6710405354",40);
        assertEquals(list.getStudents().get(1).getScore(),list.findStudentById("6710405354").getScore());
        //ทดสอบการให้คะแนนผ่าน ID 6710405354
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดผ่าน ID")
    void testViewGradeOfId(){
        list.addNewStudent("67xxxxxxx","test");

        list.giveScoreToId("67xxxxxxx",20);//67xxxxxxx มี 20 คะแนน
        assertEquals("F",list.getStudents().get(0).grade());

        list.giveScoreToId("67xxxxxxx",30);//67xxxxxxx มี 50 คะแนน
        assertEquals("D",list.getStudents().get(0).grade());

        list.giveScoreToId("67xxxxxxx",10);//67xxxxxxx มี 60 คะแนน
        assertEquals("C",list.getStudents().get(0).grade());

        list.giveScoreToId("67xxxxxxx",19.9);//67xxxxxxx มี 79.9 คะแนน
        assertEquals("B",list.getStudents().get(0).grade());

        list.giveScoreToId("67xxxxxxx",1);//67xxxxxxx มี 80.9 คะแนน
        assertEquals("A",list.getStudents().get(0).grade());
    }
}