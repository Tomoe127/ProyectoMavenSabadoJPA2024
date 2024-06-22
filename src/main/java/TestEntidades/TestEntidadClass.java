package TestEntidades;

import java.util.List;

import DAO.ClassClienteImp;
import model.TblCliente;

public class TestEntidadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TblCliente cliente = new TblCliente();
		ClassClienteImp crud = new ClassClienteImp();
		/*
		cliente.setNombre("nilson ronaldo");
		cliente.setApellido("ramirez ramirez");
		cliente.setDni("1045789");
		cliente.setEmail("nilson@gmail.com");
		cliente.setTelf("3871459");
		cliente.setSexo("M");
		cliente.setNacionalidad("argentina");
		crud.RegistrarCliente(cliente);
		*/
		
		List<TblCliente> listado = crud.ListadoCliente();
		for(TblCliente lis:listado){
			System.out.println("nombre "+lis.getNombre()+" dni "+lis.getDni()+
								" email "+lis.getEmail()+" telef "+lis.getTelf()+
								" sexo "+lis.getSexo()+" nacionalidad "+lis.getNacionalidad());
		}
	}

}
