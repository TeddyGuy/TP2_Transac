package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoJPAH2<T> implements Dao<T> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate.exe");
    @Override
    public void save(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }
}
