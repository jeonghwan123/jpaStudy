package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();

            member.setUsername("C");

            em.persist(member);



            tx.commit();
        } catch(Exception E){
            tx.rollback();

        } finally {
            em.close();
        }
        emf.close();
    }
}
