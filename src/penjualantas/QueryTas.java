/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package penjualantas;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Kang Arif
 */
public class QueryTas {
    public void Add (Object object){
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PembeliPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
                em.persist(object);
                em.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
        } finally {
                em.close();
        }
    }
    
    public void update(long id,String nama_pelanggan,String alamat_pelanggan){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PembeliPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        em.createQuery("UPDATE Pembeli e SET e.Nama_Pelanggan=?1,e.Alamat_Pelanggan=?2 WHERE e.id=?3",Pembeli.class)
                .setParameter(1, nama_pelanggan)
                .setParameter(2, alamat_pelanggan)
                
                .setParameter(3,id)
                .executeUpdate();       
        em.getTransaction().commit();
  }
    
    
public void hapus(long id){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PembeliPU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        int hapusyu=em.createQuery("DELETE FROM Pembeli e WHERE e.id=:par").setParameter("par", id).executeUpdate();
        em.getTransaction().commit();
}
  public void Show() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PembeliPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Pembeli e");
        List<Pembeli> result = query.getResultList();
        for (Pembeli e : result) {
                 System.out.println("ID PELANGGAN :"+ e.getId() + "\n NAMA :" + e.getNama_Pelanggan()+"\n Alamat :"+ e.getAlamat_Pelanggan());   
        }
  }

    
}
