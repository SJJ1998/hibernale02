package com.sjj.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author 石家俊
 * @create 2019- 11 -21 - 11:04
 */
public class HibernateUtils {

    //会话工厂
    private static SessionFactory sessionFactory;
    //会话
    private static Session session;
    //事务
    private static Transaction tx;

    static {
        //创建会话工厂
        sessionFactory =new Configuration().configure().buildSessionFactory();
        //生产会话
        session=sessionFactory.openSession();
        //开启事务
        tx = session.beginTransaction();
    }

    public static  Session getSession(){
        return  sessionFactory.openSession();
    }
    public static  void  closeSession(){
        tx.commit();
        session.close();
        sessionFactory.close();
    }

}
