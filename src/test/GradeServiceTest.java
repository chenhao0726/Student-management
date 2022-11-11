package test;

import com.chen.dao.IGradeDao;
import com.chen.domain.Grade;
import com.chen.service.IGradeService;
import com.chen.service.impl.GradeServiceImpl;
import org.junit.Test;

import java.util.List;

public class GradeServiceTest {
    private IGradeService iGradeService = new GradeServiceImpl();

    @Test
    public void selectAll() {
        List<Grade> grades = iGradeService.selectAll();
        grades.forEach(System.out::println);
    }

    @Test
    public void saveClass() {
        Grade grade = new Grade("三班");
        int result = iGradeService.saveClass(grade);
        System.out.println(result);
    }

}
