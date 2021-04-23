package ar.edu.unju.edm.model;

import java.time.LocalDate;
//import java.util.Date;
import java.time.Period;

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
	
	//falta edad calculada y habilitar fechaUltimaCompra	

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
LocalDate hoy = LocalDate.now();
Period periodo = Period.between(this.fechaNacimiento, hoy );
edad = periodo.getYears(); 

return edad;
}

public int settiempoRestante() {
	
	LocalDate hoy = LocalDate.now();
	if(this.fechaNacimiento.getMonthValue()<LocalDate.now().getMonthValue())
	{}
	else
	{}
	return 0;
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