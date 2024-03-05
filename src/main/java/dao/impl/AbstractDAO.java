/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.GenericDAO;
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import util.JPAConfig;

/**
 *
 * @author lunhu
 */
public class AbstractDAO<T> implements GenericDAO<T> {

    private Class<T> cls;
    protected EntityManager entityManager;

    public AbstractDAO(Class<T> cls) {
        this.cls = cls;
        entityManager = JPAConfig.getEntityManager();
    }

    @Override
    public T save(T entity) {
        checkOpenEntityManager();
        EntityTransaction Et = entityManager.getTransaction();
        try {
            Et.begin();
            entityManager.persist(entity);
//            String sql = "INSERT INTO (Entity).. VALUES ...";
//            ps.executeupdate();

            Et.commit();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void update(T entity) {
        checkOpenEntityManager();
        EntityTransaction Et = entityManager.getTransaction();
        try {
            Et.begin();
            entityManager.merge(entity);
            Et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            Et.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(int id) {
        checkOpenEntityManager();
        EntityTransaction Et = entityManager.getTransaction();
        try {
            Et.begin();
            T entity = entityManager.find(cls, id);
            entityManager.remove(entity);
            Et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            Et.rollback();
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public void UpdateWithJPQL(String jpql, Object... Parameters) {
         checkOpenEntityManager();
        Query query = entityManager.createQuery(jpql);
        setParameters(query, Parameters);       
        EntityTransaction Et = entityManager.getTransaction();
        try {
            Et.begin();
            query.executeUpdate();
            Et.commit();
        } catch (Exception e) {
            if (Et.isActive()) {
                Et.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    @Override
    public void deleteWithJPQL(String jpql, Object... Parameters) {
        checkOpenEntityManager();
        Query query = entityManager.createQuery(jpql);
        setParameters(query, Parameters);       
        EntityTransaction Et = entityManager.getTransaction();
        try {
            Et.begin();
            query.executeUpdate();
            Et.commit();
        } catch (Exception e) {
            if (Et.isActive()) {
                Et.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteWithEntity(T entity) {
        checkOpenEntityManager();
        EntityTransaction Et = entityManager.getTransaction();
        try {
            Et.begin();
            entityManager.remove(entity);
            Et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            Et.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteManyEntity(String jpql, Object... Parameters) {
        checkOpenEntityManager();
        EntityTransaction Et = entityManager.getTransaction();
        try {
            Et.begin();
            Query query = entityManager.createQuery(jpql);
            int deletedCount = query.executeUpdate();
            System.out.println("Number of entities deleted: " + deletedCount);
            Et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            Et.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public T findById(int id) {
        checkOpenEntityManager();
        T entity = entityManager.find(cls, id);
        return entity;

    }

    @Override
    public List<T> findAll() {
        checkOpenEntityManager();
        //criteriaBuilder dùng để tạo các mệnh để truy vất 
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //Chỉ định đối tượng truy vấn trả về là Entity<cls>
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(cls);

        //Root đại diện cho From Entity
        Root<T> root = criteriaQuery.from(cls);

        //Thiết lập câu truy vấn là Select root = Select * from cls
        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    ;

    @Override
    public Long countAll() {
        checkOpenEntityManager();
        //criteriaBuilder dùng để tạo các mệnh để truy vất 
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //Chỉ định đối tượng truy vấn trả về là Entity<cls>
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);

        //Root đại diện cho From Entity
        Root<T> root = countQuery.from(cls);

        //Thiết lập câu truy vấn là Select root = Select * from cls
        countQuery.select(criteriaBuilder.count(root));

        return entityManager.createQuery(countQuery).getSingleResult();
    }

    @Override
    public T findOne(String jdql, Object... Parameters) {
        checkOpenEntityManager();
        try {
            TypedQuery<T> query = entityManager.createQuery(jdql, cls);
            // Sử dụng setParameter với vị trí và giá trị
            setParameters(query, Parameters);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findList(String jdql, Object... Parameters) {
        checkOpenEntityManager();
        try {
            TypedQuery<T> query = entityManager.createQuery(jdql, cls);
            setParameters(query, Parameters);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findListSetLimit(String jdql, int limit, int offset, Object... Parameters) {
        checkOpenEntityManager();
        try {
            TypedQuery<T> query = entityManager.createQuery(jdql, cls);
            query.setFirstResult(offset);
            if (limit != 0) {
                query.setMaxResults(limit);
            }

            setParameters(query, Parameters);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Double sumByColumn(String jdql) {
        checkOpenEntityManager();
        try {
            TypedQuery<Double> query = entityManager.createQuery(jdql, Double.class);
            if (query.getSingleResult() == null) {
                return 0.0;
            }
            return query.getSingleResult();
        } catch (NoResultException e) {
            return 0.0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }

    }

    public void setParameters(TypedQuery<T> query, Object... parameters) {
        for (int i = 1; i <= parameters.length; i++) {
            query.setParameter(i, parameters[i - 1]);
        }
    }
    
    public void setParameters(Query query, Object... parameters) {
        for (int i = 1; i <= parameters.length; i++) {
            query.setParameter(i, parameters[i - 1]);
        }
    }

    public void checkOpenEntityManager() {
        entityManager.close();
        if (!entityManager.isOpen()) {
            entityManager = JPAConfig.getEntityManager();
        }
    }

    public static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    
}
