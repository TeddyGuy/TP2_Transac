package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Client;

import java.util.Optional;

public class ClientDaoJPAH2 extends DaoJPAH2<Client>{

    public Optional<Client> find(Client clientToLogin) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Client> query = em.createQuery(
                "select c " +
                        "from Client c left join fetch c.documentLoans " +
                        "where c.username like :username " +
                        "and c.password like :password"
                ,Client.class
        );

        System.out.println(clientToLogin.getUsername());
        System.out.println(clientToLogin.getPassword());

        query.setParameter("username", clientToLogin.getUsername());
        query.setParameter("password", clientToLogin.getPassword());

        Optional<Client> client = Optional.ofNullable(query.getSingleResult());

        em.getTransaction().commit();
        em.close();

        return client;
    }
}
