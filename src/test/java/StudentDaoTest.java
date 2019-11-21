import com.sjj.dao.StudentDao;
import com.sjj.dao.StudentDaoImpl;
import com.sjj.po.Student;

import java.util.List;

/**
 * @author 石家俊
 * @create 2019- 11 -21 - 11:28
 */
public class StudentDaoTest {

    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();
        List<Student> stus = dao.selectAll();
        for (Student student : stus) {
            System.out.println(student);
        }
    }
}
