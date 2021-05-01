package ar.edu.unju.edm.service.imp;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
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
		// fecha para cumple
		LocalDate fechaNac= unCliente.getFechaNacimiento();
		LocalDate fechaAhora = LocalDate.now();
		//fecha desde ultima compra
		LocalDate fechaUlti = unCliente.getFechaUltimaCompra();
		//sigue el orden de fecha anterior y fecha posterior (sig line)
	
		//--calculo edad--
		Period periodo = Period.between(fechaNac, fechaAhora);
		unCliente.setEdad(periodo.getYears());
		
		//--calculo de tiempo desde ultima compra--
		String datos= "T_desdeUltimaComp: ";
		Period periodo2 = Period.between(fechaUlti, fechaAhora);
		datos += (periodo2.getYears()+"-"+periodo2.getMonths()+"-"+periodo2.getDays()+" T_hastaCumple :");
		
		//--calculo hasta siguiente cumpleaños--
 
     
       
        //fecha de nc mejorada 
        LocalDate nextBDay = fechaNac.withYear(fechaAhora.getYear());

        //Si el cumpleaños ya ocurrió este año, agrega 1 año
        if (nextBDay.isBefore(fechaAhora) || nextBDay.isEqual(fechaAhora)) {
            nextBDay = nextBDay.plusYears(1);
        }
        
        Period p = Period.between(fechaAhora, nextBDay);
        long totalDias = ChronoUnit.DAYS.between(fechaAhora, nextBDay);

       //Cuando totalDias=365 hoy es el cumpleaños

        if (totalDias == 365)
        {
            datos += (p.getYears()+"-"+p.getMonths()+"-"+p.getDays()+" Feliz Cumple!");
        } else
        {
            datos += (p.getYears()+"-"+p.getMonths()+"-"+ p.getDays()+" ");    
        }

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
