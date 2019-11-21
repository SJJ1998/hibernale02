package com.sjj.dao;

import com.sjj.po.Student;
import com.sjj.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author 石家俊
 * @create 2019- 11 -21 - 11:01
 */
public class StudentDaoImpl implements StudentDao{



    public List<Student> selectAll() {
        //1.获取Session会话对象
        Session session = HibernateUtils.getSession();
        //2.创建SQL语句
          String hql="from com.sjj.po.Student";
        //3.创建Query对象
        Query query = session.createQuery(hql);
        //4.获取查询结果
        List list = query.list();
        //5.关闭资源
        HibernateUtils.closeSession();
        return list;
    }
}
