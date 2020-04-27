package cl.tesoreria.seguridad.profile.vo; 

import java.io.Serializable;

public class CargaMasiva implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rut;
	private String pass;
	private String descripcion;
	private String rol;
	private String observacion;
    private String idCarga;
    private String tipoCarga;
    private String idApp;
    
    public CargaMasiva(){
    }

	public String getRut(){
		return rut;
	}
	public void setRut(String rut){
		this.rut = rut;
	}
	public String getPass(){
		return pass;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public String getDescripcion(){
		return descripcion;
	}
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	public String getRol(){
		return rol;
	}
	public void setRol(String rol){
		this.rol = rol;
	}
	public String getObservacion(){
		return observacion;
	}
	public void setObservacion(String observacion){
		this.observacion = observacion;
	}
    public String getIdCarga(){
		return idCarga;
	}
	public void setIdCarga(String idCarga){
		this.idCarga = idCarga;
	}
    public String getTipoCarga(){
		return tipoCarga;
	}
	public void setTipoCarga(String tipoCarga){
		this.tipoCarga = tipoCarga;        
	}
    public String getIdApp(){
		return idApp;
	}
	public void setIdApp(String idApp){
		this.idApp = idApp;        
	}
}
