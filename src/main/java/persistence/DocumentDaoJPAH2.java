package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Documents.Document;

import java.util.List;

public class DocumentDaoJPAH2 extends DaoJPAH2<Document>{

    public List<Document> find(String titleSearch, String authorSearch, String genreSearch, int yearSearch) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery(
                "select d " +
                        "from Document d " +
                        "where LOWER(d.title) like :titleSearch " +
                        "and d.author like :authorSearch " +
                        "and d.genre like :genreSearch " +
                        "and d.publicationYear = :yearSearch"
                ,Document.class
        );
        query.setParameter("titleSearch","%" + titleSearch.toLowerCase() + "%");
        query.setParameter("authorSearch",authorSearch);
        query.setParameter("genreSearch",genreSearch);
        query.setParameter("yearSearch",yearSearch);

        List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return documents;
    }

    public Document findById(long id) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery(
                "select d " +
                        "from Document d " +
                        "where d.id = :id"
                ,Document.class);

        query.setParameter("id",id);

        Document document = query.getSingleResult();

        em.getTransaction().commit();
        em.close();

        return document;
    }
}
