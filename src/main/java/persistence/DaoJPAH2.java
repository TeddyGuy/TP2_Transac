package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class DaoJPAH2<T> implements Dao<T> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    @Override
    public void save(T t) {

    }
}
