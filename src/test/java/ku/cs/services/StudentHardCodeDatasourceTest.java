package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    @Test
    @DisplayName("ทดสอบ readData")
    void testReadData(){
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList l = datasource.readData();

        int i = 0;
        for (Student s: l.getStudents()) {//ไล่ทดสอบ StudentList l ทีละตัว
            assertEquals(s.getId(), l.getStudents().get(i).getId());//ทดสอบ ID ว่าเหมือนกันหรือไม่
            assertEquals(s.getName(),l.getStudents().get(i).getName());//ทดสอบชื่อว่าเหมือนกันหรือไม่
            assertEquals(s.getScore(),l.getStudents().get(i).getScore());//ทดสอบคะแนนว่าเท่ากันหรือไม่
            i++;
        }
    }

}