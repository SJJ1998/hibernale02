import com.sjj.po.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

import java.io.Serializable;

/**
 * @author 石家俊
 * @create 2019- 11 -21 - 9:02
 */
public class Test {

    //会话工厂
    private SessionFactory sessionFactory;
    //会话
    private Session session;
    //事务
    private Transaction tx;

    @Before
     public void before(){
        //创建会话工厂
        sessionFactory =new Configuration().configure().buildSessionFactory();
        //生产会话
         session=sessionFactory.openSession();
        //开启事务
        tx = session.beginTransaction();
     }

     @org.junit.Test
    public  void testGet(){
        Student student = session.get(Student.class, 1);
        System.out.println("student ="+student);
    }

    @org.junit.Test
    public void insert(){
        Serializable  save= session.save(new Student(8,"鼬"));
        System.out.println(save);
    }

    @org.junit.Test
    public void delete(){
       /*Student stu = new Student();
       stu.setId(1);
       stu.setName("张三");
       session.delete(stu);*/
       //删除  先根据id 查询对象是否存在(entity) 再去删除
        Student stu = session.get(Student.class,2);
        if(stu!=null){
            session.delete(stu);
        }
    }

       @org.junit.Test
    public void  update(){
        Student stu = new Student();
        stu.setId(3);
        stu.setName("大河");
        session.update(stu);
    }
    /*
     *
     * 新增 或者 修改
     *    根据  实体类中的主键 进行查询
     *    如果 查询到数据 那么执行 修改操作
     *    否则              执行 添加操作
     *
     *   添加setid 就是 修改
     *   没有setid 就是 添加
     * */


    @org.junit.Test
    public void InsertOrUpdate(){
           Student stu = new Student();
           //stu.setId(7);
           stu.setName("哈哈哈哈哈");
           session.saveOrUpdate(stu);
    }

    @After
    public void after(){
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
