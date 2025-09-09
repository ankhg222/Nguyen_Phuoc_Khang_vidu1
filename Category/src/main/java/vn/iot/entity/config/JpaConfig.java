package vn.iot.entity.config;
import jakarta.persistence.*;

public final class JpaConfig {
  private static final EntityManagerFactory EMF =
      Persistence.createEntityManagerFactory("dataSource");
  private JpaConfig(){}
  public static EntityManager em(){ return EMF.createEntityManager(); }
  public static void shutdown(){ if(EMF.isOpen()) EMF.close(); }
}
