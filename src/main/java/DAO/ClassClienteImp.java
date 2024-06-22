package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.ICliente;
import model.TblCliente;

public class ClassClienteImp implements ICliente{

	public void RegistrarCliente(TblCliente cliente) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		EntityManager em=fabr.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		System.out.println("cliente registrado en la BD correctamente");
		em.getTransaction().commit();
		em.close();
	}

	public void ActualizarCliente(TblCliente cliente) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();
		
	}

	public void EliminarCliente(TblCliente cliente) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		TblCliente elim = em.merge(cliente);
		em.remove(elim);
		System.out.println("Cliente eliminado de la base de datos");
		em.getTransaction().commit();
		em.close();
		
	}

	public TblCliente BuscarCliente(TblCliente cliente) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		TblCliente buscliente = em.find(TblCliente.class, cliente.getIdcliente());
		em.getTransaction().commit();
		em.close();
		return buscliente;
	}

	public List<TblCliente> ListadoCliente() {
		// TODO Auto-generated method stub
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("ProyectoMavenSabadoJPA");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		List<TblCliente> listadoclientes = em.createQuery("select c from TblCliente c", TblCliente.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listadoclientes;
	}

}
