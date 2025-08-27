package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {
    Datasource<StudentList> orginal;
    Datasource<StudentList> changed;
    StudentList studentList;

    @BeforeEach
    void init() {
        orginal = new StudentListFileDatasource("data", "student-list.csv");
        changed =  new StudentListFileDatasource("data", "student-list-changed.csv");
        studentList = orginal.readData();
    }

    @Test
    @DisplayName("ทดสอบ readData")
    void testReadData() {
        assertEquals("[{id: '6410450001', name: 'Tim Berners-Lee', score: 145.5}, {id: '6410450002', name: 'Barbara Liskov', score: 60.7}, {id: '6410450003', name: 'Alan Turing', score: 346.2}, {id: '6410450004', name: 'John McCarthy', score: 63.8}, {id: '6410450005', name: 'Alan Kay', score: 68.0}]"
                ,String.valueOf(studentList.getStudents()));
    }

    @Test
    @DisplayName("ทดสอบ writeData")
    void testWriteData() {
        studentList.addNewStudent("67xxxxxxx","test");
        changed.writeData(studentList);
        studentList = changed.readData();
        assertEquals("[{id: '6410450001', name: 'Tim Berners-Lee', score: 145.5}, {id: '6410450002', name: 'Barbara Liskov', score: 60.7}, {id: '6410450003', name: 'Alan Turing', score: 346.2}, {id: '6410450004', name: 'John McCarthy', score: 63.8}, {id: '6410450005', name: 'Alan Kay', score: 68.0}, {id: '67xxxxxxx', name: 'test', score: 0.0}]"
                ,String.valueOf(studentList.getStudents()));
    }
}