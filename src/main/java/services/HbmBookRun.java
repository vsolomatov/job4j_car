package services;

import model.Book;
import model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmBookRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Book one = Book.of("Алгоритмы и структуры");
            Book two = Book.of("Паттерны проектирования");

            Author first = Author.of("Вирт");
            first.getBooks().add(one);
            first.getBooks().add(two);

            Author second = Author.of("Фримен");
            second.getBooks().add(two);

            session.persist(first);
            session.persist(second);

            //session.getTransaction().commit();

            Author author = session.get(Author.class, first.getId());
            session.remove(author);

            session.getTransaction().commit();

            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
