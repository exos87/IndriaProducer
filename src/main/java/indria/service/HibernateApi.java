package indria.service;

import indria.entity.User;
import indria.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class HibernateApi {

    public static <T> List<T> printAll(Class<T> type) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(type);
            criteria.from(type);
            List<T> data = session.createQuery(criteria).getResultList();
            transaction.commit();
            return data;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    return null;
    }

    public static void deleteAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            // create delete
            CriteriaDelete<User> criteriaDelete = builder.createCriteriaDelete(User.class);
            criteriaDelete.from(User.class);
            session.createQuery(criteriaDelete).executeUpdate();
           // commit transaction
            System.out.println("Zmazane all");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

        }

    }

    public static  void  add(User type)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.merge (type);
            System.out.println("USER: "+ type.toString());
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

        }
    }
}
