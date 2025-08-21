package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s;
    @BeforeEach
    void init(){
        s = new Student("67xxxxxxx","test");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 40.1")
    void testAddScore(){
        s.addScore(40.1);
        assertEquals(40.1,s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคิดเกรด")
    void testCalculateGrade(){
        s.addScore(20);//s มี 20 คะแนน
        assertEquals("F",s.grade());

        s.addScore(30);//s มี 50 คะแนน
        assertEquals("D",s.grade());

        s.addScore(10);//s มี 60 คะแนน
        assertEquals("C",s.grade());

        s.addScore(19.9);//s มี 79.9 คะแนน
        assertEquals("B",s.grade());

        s.addScore(1);//s มี 80.9 คะแนน
        assertEquals("A",s.grade());
    }

    @Test
    @DisplayName("ทดสอบ Constructor")
    void testConstructor0(){
        Student s1 = new Student("67xxxxxxx","test");
        assertEquals(String.valueOf(s),String.valueOf(s1));//ทดสอบ object ที่มีค่าเท่ากัน
        assertEquals(0,s1.getScore());//ทดสอบว่า object s1 มีคะแนนเป็น 0

        Student s2 = new Student("67xxxxxxx","test",50);
        assertEquals(50,s2.getScore());//ทดสอบว่า object s2 มีคะแนนเป็น 50
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName(){
        s.changeName("tset");
        assertEquals("tset",s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเช็คID")
    void testIsId(){
        boolean check1 = s.isId("67xxxxxxx");
        assertEquals(true,check1);

        check1 = s.isId("6710405354");
        assertEquals(false,check1);
    }

    @Test
    @DisplayName("ทดสอบการเช็คชื่อ")
    void testIsNameContains(){
        boolean check1 = s.isNameContains("test");
        assertEquals(true,check1);

        check1 = s.isNameContains("TEST");
        assertEquals(true,check1);

        check1 = s.isNameContains("Krit");
        assertEquals(false,check1);
    }

    @Test
    @DisplayName("ทดสอบ toString")
    void testToString(){
        assertEquals("{id: '67xxxxxxx', name: 'test', score: 0.0}",String.valueOf(s));
    }
}