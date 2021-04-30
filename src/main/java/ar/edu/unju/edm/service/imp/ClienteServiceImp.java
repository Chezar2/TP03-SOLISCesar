package ar.edu.unju.edm.service.imp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.service.IClienteService;
import ar.edu.unju.edm.util.ListadoClientes;

@Service
public class ClienteServiceImp implements IClienteService{
	
	private List<Cliente> listadoClientes = ListadoClientes.clientes;
	
	@Autowired
	Cliente unCliente;

	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		LocalDate fechaNac= unCliente.getFechaNacimiento();
		LocalDate fechaAhora = LocalDate.now();
		
		LocalDate fechaUlti = unCliente.getFechaUltimaCompra();
		//sigue el orden de fecha anterior y fecha posterior (sig line)
		Period periodo = Period.between(fechaNac, fechaAhora);
		unCliente.setEdad(periodo.getYears());
		String datos= "TUComp: ";
		Period periodo2 = Period.between(fechaUlti, fechaAhora);
		datos += (periodo.getMonths()+"-"+periodo.getMonths()+"-"+periodo.getDays()+"ThC :");
		
		if(fechaAhora.getMonthValue()> fechaNac.getMonthValue()) {
		
			fechaNac = LocalDate.of(fechaNac.getYear()+unCliente.getEdad(),fechaNac.getMonthValue(),fechaNac.getDayOfMonth());
		}
		else if (fechaAhora.getMonthValue() == fechaNac.getMonthValue()) {
			if (fechaAhora.getDayOfMonth()> fechaNac.getDayOfMonth())
			{
				fechaNac = LocalDate.of(fechaNac.getYear()+unCliente.getEdad(),fechaNac.getMonthValue(),fechaNac.getDayOfMonth());
			}
			else {
				periodo = Period.between(fechaNac, fechaAhora );
			}
		}
		else
		{
			periodo = Period.between(fechaNac, fechaAhora);
		}
		
	
		datos += (periodo.getYears()+"-"+periodo.getMonths()+"-"+periodo.getDays()+" ");
		unCliente.setDatosAdicionales(datos);
		
		listadoClientes.add(unCliente);	

	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return listadoClientes;
	}

}
