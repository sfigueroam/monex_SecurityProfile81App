package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet; 

import java.math.BigDecimal;

public class SpSegEliminarTesoUserResult implements java.io.Serializable
{ 
    
    private static final long serialVersionUID = 1L;
    private BigDecimal myOCodError;

    /**
     * Create a new SpSegInsertarModResult.
     */
    public SpSegEliminarTesoUserResult() {}

    /**
     * Gets the OCodError value of this SpSegInsertarModResult.
     */
    public BigDecimal getOCodError()
    {
        return myOCodError;
    }

    /**
     * Sets the OCodError value of this SpSegInsertarModResult.
     */
    public void setOCodError(BigDecimal value)
    {
        myOCodError = value;
    }
    
} 
