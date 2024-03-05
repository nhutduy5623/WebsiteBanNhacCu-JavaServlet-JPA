package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConfig {
    private static final String PERSISTENCE_UNIT_NAME = "quanlynhaccuJPA";
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
