package org.jpql.sregion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.modelo.sregion.S_Region;

public class JPQLS_Region {
	
	//INSERTAR
	public static void insertarS_Region(int id, String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			S_Region region = new S_Region();
			region.setId(id);
			region.setName(name);
			em.persist(region);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}	}
	
	//ACTUALIZAR
	public static void actualizarS_Region(String name, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			S_Region region = new S_Region();
			region.setId(id);
			region.setName(name);
			em.merge(region);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}	}
	
	//ELIMINAR
	public static void eliminarS_Region(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			S_Region region = new S_Region();
			region = em.find(S_Region.class, id);
			if (region ==null) {
				System.out.println("EL REGISTRO NO EXISTE");
			}else {
				em.remove(region);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}	}
	
	//CONSULTAR TODO
	@SuppressWarnings("unchecked")
	public static void consultaTodoS_Region() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("select a from S_Region a");
			List<S_Region> regiones = query.getResultList();
			for(S_Region x : regiones) {
				System.out.println(x.getId() + " , "+ x.getName());
			}
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}	}
	
	/*
	 * CATALOGO DE CONSULTAS:
	 * 
	 * 1.- SELECT_ALL_S_REGION
	 * 2.- SELECT_BY_ID_S_REGION
	 * */
	
	public static void consultaAlmacenadaS_Region() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			//CONSULTA GENERAL
			Query query = em.createNamedQuery("SELECT_ALL_S_REGION");
			
			//CONSULTA INDIVIDUAL
			//Query query = em.createNamedQuery("SELECT_BY_ID_S_REGION");
			//query.setParameter("p", 1);
			
			@SuppressWarnings("unchecked")
			List<S_Region> regiones = query.getResultList();
			for (S_Region x : regiones) {
				System.out.println(x.getId() + " , " + x.getName());
			}
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}	}
	
    public static void main(String[] args) {
    	consultaAlmacenadaS_Region();
    	//consultaTodoS_Region();
    	//eliminarS_Region(9);
    	//actualizarS_Region("MICHOACAN MX", 9);
		//insertarS_Region(9, "MICHOACAN");
	}

}









