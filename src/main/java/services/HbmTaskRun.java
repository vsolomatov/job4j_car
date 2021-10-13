package services;

import model.Category;
import model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmTaskRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Category first = Category.of("Consulting");

            Task one = Task.of("Consultation on Hibernate", first);
            Task two = Task.of("Consultation on Spring", first);
            Task three = Task.of("Consultation on Servlet", first);

            first.getTasks().add(one);
            first.getTasks().add(two);
            first.getTasks().add(three);
            session.persist(first);

            session.getTransaction().commit();

            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
