package org.remix.ssh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by astaJerry on 2017/7/25.
 */
public class HibernateUtils {

    // 1.创建工厂对象;
    private static SessionFactory sessionFactory;
    /*// 2.初始化工厂对象;
    static {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
        Session s = factory.openSession();
    }*/

//    private HibernateUtils() {
//
//    }
    //获得开启着的Session
    public static Session getSession(){
//        return sessionFactory.openSession();
        return getSessionFactory().openSession();
    }

    //关闭Session
    public static void closeSession(Session session){
        if(session!=null){
            if(session.isOpen()){
                session.close();
            }
        }
    }

/*    public static SessionFactory getSessionFactory(){
        SessionFactory sessionFactory = null;
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("applicationContext.xml").build();   // configures settings from hibernate.cfg.xml
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        return sessionFactory;
    }*/

    public static SessionFactory getSessionFactory()
    {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("applicationContext.xml").build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return sessionFactory;
    }

}
