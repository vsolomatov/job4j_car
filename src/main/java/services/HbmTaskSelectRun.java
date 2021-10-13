package services;

import model.Category;
import model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HbmTaskSelectRun {
    public static void main(String[] args) {
        List<Category> list = new ArrayList<>();
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            list = session.createQuery("from Category").list();
            session.getTransaction().commit();
            for (Category category : list) {
                for (Task task : category.getTasks()) {
                    System.out.println(task);
                }
            }
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        /*for (Category category : list) {
            for (Task task : category.getTasks()) {
                System.out.println(task);
            }
        }*/
    }
}
