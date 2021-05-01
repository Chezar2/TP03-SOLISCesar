package ar.edu.unju.edm.model;

import java.time.LocalDate;
//import java.util.Date;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
	private String tipoDocumento;
	private int nroDocumento;
	private String nombreApellido;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	private int edad;
	
	private int codigoAreaTelefono;
	private int numTelefono;
	private String  numTelefonoCompleto;
	//Calendar
	//private Date fechaUltimCompra = new Date();
	
	
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
public int getEdad() {
	int edad=0;
	LocalDate fechaAhora = LocalDate.now();
	Period periodo = Period.between(fechaNacimiento, fechaAhora);
	edad=periodo.getYears();
	return edad;
}

public String getTiempoDeUltimaCompra() {
	//--calculo de tiempo desde ultima compra--
	LocalDate fechaAhora = LocalDate.now();
	//String datos= "T_desdeUltimaComp: ";
	Period periodo = Period.between(fechaUltimaCompra, fechaAhora);
	
	return " T desde U compra Años: "+periodo.getYears()+" Meses: "+periodo.getMonths()+" Dias: "+periodo.getDays();
}
public String getTiempoHastaCumple() {
		
	LocalDate fechaAhora = LocalDate.now();
    LocalDate nextBDay = fechaNacimiento.withYear(fechaAhora.getYear());
	//--calculo hasta siguiente cumpleaños--
 
    //Si el cumpleaños ya ocurrió este año, agrega 1 año
    if (nextBDay.isBefore(fechaAhora) || nextBDay.isEqual(fechaAhora)) {
        nextBDay = nextBDay.plusYears(1);
    }
    Period p = Period.between(fechaAhora, nextBDay);
    long totalDias = ChronoUnit.DAYS.between(fechaAhora, nextBDay);

   //Cuando totalDias=365 hoy es el cumpleaños

    if (totalDias == 365)
    {
        return " Feliz Cumple! Restan: "+p.getYears()+" años, "+p.getMonths()+" meses, "+p.getDays()+" dias";
    } else
    {
    	 return "; NextB, Restan: "+p.getYears()+" años, "+p.getMonths()+" meses, "+p.getDays()+" dias";
    }
	
}
public String getDatosAdicionales() {
	//creí que seria buena practica poner hasta siguiente cumpleaños y desde ultima compra por separado
	return getTiempoDeUltimaCompra()+getTiempoHastaCumple();
}


public LocalDate getFechaUltimaCompra() {
	return fechaUltimaCompra;
}

public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
	this.fechaUltimaCompra = fechaUltimaCompra;
}


	public String getTipoDocumento() {
		return tipoDocumento;
	}




	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}




	public int getNroDocumento() {
		return nroDocumento;
	}




	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}




	public String getNombreApellido() {
		return nombreApellido;
	}




	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}




	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}




	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}




	public int getNumTelefono() {
		return numTelefono;
	}




	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}


//:D?

	public String getNumTelefonoCompleto() {
		numTelefonoCompleto=(String.valueOf(codigoAreaTelefono)+"-"+ String.valueOf(numTelefono));
		return numTelefonoCompleto;
	}




	public void setNumTelefonoCompleto(String numTelefonoCompleto) {
		this.numTelefonoCompleto = numTelefonoCompleto;
	}


}