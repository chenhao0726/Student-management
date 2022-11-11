package test;


import com.chen.domain.Student;
import com.chen.service.IStudentService;
import com.chen.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentServiceTest {
    private IStudentService service = new StudentServiceImpl();

    @Test
    public void queryAllTest() {
        List<Student> students = service.queryAll();
        students.forEach(System.out::println);
    }

    @Test
    public void selectById() {
        Student student = service.selectById(1L);
        System.out.println(student);
    }

}
