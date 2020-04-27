package cl.tesoreria.seguridad.perfil.vo; 

import java.math.BigDecimal;
import java.sql.Date;
public class UserSecurityVO 
{ 
    public BigDecimal userId=null;
    public String userName=null;
    public java.sql.Date creationDate=null;
    public java.sql.Date modifiedDate=null;
    
    public UserSecurityVO(){}
    
    public BigDecimal getUserId()
    {
        return this.userId;
    }
    
    public void setUserId(BigDecimal userId)
    {
        this.userId=userId;
        
    }
    
    public String getUserName()
    {
        return this.userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName=userName;
    }
    
    public java.sql.Date getCreationDate()
    {
        return this.creationDate;
        }
        
    public void setCreationDate(java.sql.Date creationDate)
    {
        this.creationDate=creationDate;
        
    }
    
    public java.sql.Date getModifiedDate()
    {
        return this.modifiedDate;    
    }
    
    public void setModifiedDate(java.sql.Date modifiedDate)
    {
        this.modifiedDate=modifiedDate;    
    }    
    
} 
