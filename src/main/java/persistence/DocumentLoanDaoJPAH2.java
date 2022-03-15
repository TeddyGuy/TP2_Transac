package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.DocumentLoan;

import java.util.List;

public class DocumentLoanDaoJPAH2 extends DaoJPAH2{
    public List<DocumentLoan> getByClientId(long id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<DocumentLoan> query = em.createQuery(
                "select dl " +
                        "from DocumentLoan dl " +
                        "where dl.client.id = :id"
                ,DocumentLoan.class);

        query.setParameter("id",id);

        List<DocumentLoan> documentLoan = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return documentLoan;
    }
}
