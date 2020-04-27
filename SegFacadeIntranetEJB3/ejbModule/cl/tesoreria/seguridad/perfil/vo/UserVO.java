package cl.tesoreria.seguridad.perfil.vo; 

import java.math.BigDecimal;

public class UserVO implements java.io.Serializable 
{ 
   public BigDecimal rut=null;
   public String dv=null;
   public String nombres=null;
   public String apePaterno=null;
   public String apeMaterno=null;
   public String email=null;
   public BigDecimal rutTesoreria=null;
   public String dvTesoreria=null;
   public BigDecimal codUbicacion=null;
   public BigDecimal codError=null;
   public BigDecimal userId=null;
   
    public UserVO() 
    { 
    }
    public BigDecimal getUserId()
    {
        return this.userId;
    }
    public void setUserId(BigDecimal userId)
    {
        this.userId=userId;
    }
    public BigDecimal getRut()
    {
        return this.rut;
    }
    public void setRut(BigDecimal rut)
    {
        this.rut=rut;
    }
     public String getDv()
    {
        return this.dv;
    }
    public void setDv(String dvUser)
    {
        this.dv=dvUser;
    }
    public String getNombres()
    {
        return this.nombres;
    }
    public void setNombres(String nombres)
    {
        this.nombres=nombres;
    } 
    public String getApePaterno()
    {
        return this.apePaterno;
    }
    public void setApePaterno(String apePaterno)
    {
        this.apePaterno=apePaterno;
    }
    public String getApeMaterno()
    {
        return this.apeMaterno;
    }
    public void setApeMaterno(String apeMaterno)
    {
        this.apeMaterno=apeMaterno;
    } 
    public String getEmail()
    {
        return this.apePaterno;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }                       
    public BigDecimal getRutTesoreria()
    {
        return this.rutTesoreria;
    }
    public void setRutTesoreria(BigDecimal rutTesoreria)
    {
        this.rutTesoreria=rutTesoreria;
    }
     public String getDvTesoreria()
    {
        return this.dvTesoreria;
    }
    public void setDvTesoreria(String dvTesoreria)
    {
        this.dvTesoreria=dvTesoreria;
    }
     public BigDecimal getCodUbicacion()
    {
        return this.codUbicacion;
    }
    public void setCodUbicacion(BigDecimal codUbicacion)
    {
        this.codUbicacion=codUbicacion;
    }
     public BigDecimal getCodError()
    {
        return this.codError;
    }
    public void setCodError(BigDecimal codError)
    {
        this.codError=codError;
    }
} 
