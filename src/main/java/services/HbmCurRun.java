package services;

import model.CarBrand;
import model.CarModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmCurRun {

    public static void main(String[] args) {
        System.out.println("Started HbmAddRun.main");
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            CarBrand carBrand = CarBrand.of("KIA");

            /*CarModel carmodel1 = CarModel.of("RIO");
            session.save(carmodel1);
            carBrand.addModel(session.load(CarModel.class, carmodel1.getId()));

            CarModel carmodel2 = CarModel.of("RIO X");
            session.save(carmodel2);
            carBrand.addModel(session.load(CarModel.class, carmodel2.getId()));

            CarModel carmodel3 = CarModel.of("RIO X-LINE");
            session.save(carmodel3);
            carBrand.addModel(session.load(CarModel.class, carmodel3.getId()));

            CarModel carmodel4 = CarModel.of("SELTOS");
            session.save(carmodel4);
            carBrand.addModel(session.load(CarModel.class, carmodel4.getId()));

            CarModel carmodel5 = CarModel.of("SPORTAGE");
            session.save(carmodel5);
            carBrand.addModel(session.load(CarModel.class, carmodel5.getId()));
*/
            session.save(carBrand);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        System.out.println("Finished HbmAddRun.main");
    }
}