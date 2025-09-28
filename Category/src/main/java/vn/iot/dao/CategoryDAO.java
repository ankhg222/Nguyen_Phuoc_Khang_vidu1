package vn.iot.dao;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iot.entity.Category;
import vn.iot.entity.config.JpaConfig;

public class CategoryDAO {
  public List<Category> findAll(){
    EntityManager em = JpaConfig.em();
    try { return em.createQuery("SELECT c FROM Category c ORDER BY c.categoryId", Category.class).getResultList(); }
    finally { em.close(); }
  }
  public Category findById(int id){
    EntityManager em = JpaConfig.em();
    try { return em.find(Category.class, id); }
    finally { em.close(); }
  }
  public Category create(Category c){
    EntityManager em = JpaConfig.em(); EntityTransaction tx = em.getTransaction();
    try { tx.begin(); em.persist(c); tx.commit(); return c; }
    catch(Exception e){ if(tx.isActive()) tx.rollback(); throw e; }
    finally { em.close(); }
  }
  public Category update(Category c){
    EntityManager em = JpaConfig.em(); EntityTransaction tx = em.getTransaction();
    try { tx.begin(); Category m = em.merge(c); tx.commit(); return m; }
    catch(Exception e){ if(tx.isActive()) tx.rollback(); throw e; }
    finally { em.close(); }
  }
  public void remove(int id){
    EntityManager em = JpaConfig.em(); EntityTransaction tx = em.getTransaction();
    try { tx.begin(); Category c = em.find(Category.class, id); if(c!=null) em.remove(c); tx.commit(); }
    catch(Exception e){ if(tx.isActive()) tx.rollback(); throw e; }
    finally { em.close(); }
  }
  
  public int count() {
    EntityManager em = JpaConfig.em();
    try {
      Long count = em.createQuery("SELECT COUNT(c) FROM Category c", Long.class).getSingleResult();
      return count.intValue();
    } catch (Exception e) {
      return 0;
    } finally {
      em.close();
    }
  }
  
  public void close() {
    // EntityManager được đóng tự động trong mỗi method
    // Method này để tương thích với HomeController
  }
}
