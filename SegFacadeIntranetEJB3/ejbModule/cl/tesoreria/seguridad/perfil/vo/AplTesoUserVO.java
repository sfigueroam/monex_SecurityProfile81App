package cl.tesoreria.seguridad.perfil.vo; 

import java.math.BigDecimal;

public class AplTesoUserVO implements java.io.Serializable
{
    
    public BigDecimal userId=null;
    public BigDecimal aplId=null;
    public BigDecimal tesoId=null;
    public String userName=null;
    public String aplDesc=null;
    public String tesoDesc=null;
    
    public AplTesoUserVO(){}
    
    public BigDecimal getUserId()
    {
        return this.userId;
    }
    
    public void setUserId(BigDecimal userId)
    {
        this.userId=userId;
    }
    
    public BigDecimal getAplId()
    {
        return this.aplId;
    }
    
    public void setAplId(BigDecimal aplId)
    {
        this.aplId=aplId;
        
    }
    
    public BigDecimal getTesoId()
    {
        return this.tesoId;
    }
    
    public void setTesoId(BigDecimal tesoId)
    {
        this.tesoId=tesoId; 
    }
    
    public String getUserName()
    {
        return this.userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName=userName;    
    }
    
    public String getAplDesc()
    {
        return this.aplDesc;
    }
    
    public void setAplDesc(String aplDesc)
    {
        this.aplDesc=aplDesc;    
    }
    
    public String getTesoDesc()
    {
        return this.tesoDesc;
    }
    
    public void setTesoDesc(String tesoDesc)
    {
        this.tesoDesc=tesoDesc;    
    }
    
    
} 
