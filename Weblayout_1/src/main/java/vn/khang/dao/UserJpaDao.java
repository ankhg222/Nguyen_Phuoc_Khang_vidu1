package vn.khang.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import vn.khang.entity.UserEntity;

public class UserJpaDao {
    private final EntityManagerFactory emf;
    
    public UserJpaDao() {
        try {
            this.emf = Persistence.createEntityManagerFactory("dataSource");
            System.out.println("✅ JPA EntityManagerFactory initialized successfully!");
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize JPA EntityManagerFactory: " + e.getMessage());
            throw new RuntimeException("JPA initialization failed. Please check database connection settings.", e);
        }
    }

    public UserEntity findById(int id) {
        EntityManager em = emf.createEntityManager();
        try { return em.find(UserEntity.class, id); }
        finally { em.close(); }
    }

    public boolean updateProfile(int id, String fullName, String phone, String imagePathOrNull) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            UserEntity u = em.find(UserEntity.class, id);
            if (u == null) return false;
            u.setFullname(fullName);   // chú ý: tên biến khớp với entity
            u.setPhone(phone);
            if (imagePathOrNull != null) u.setAvatar(imagePathOrNull);
            em.merge(u);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
}
