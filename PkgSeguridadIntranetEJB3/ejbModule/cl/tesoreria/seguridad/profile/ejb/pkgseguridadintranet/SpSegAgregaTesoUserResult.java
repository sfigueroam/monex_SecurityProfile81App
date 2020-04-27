package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet; 

import java.math.BigDecimal;
import javax.sql.RowSet;

public class SpSegAgregaTesoUserResult implements java.io.Serializable
{ 
    
    private static final long serialVersionUID = 1L;
    private BigDecimal myOCodError;
    private RowSet[] myRowSets;

    /**
     * Create a new SpSegBuscarInfoUserResult.
     */
    public SpSegAgregaTesoUserResult() {}

    /**
     * Gets the OCodError value of this SpSegBuscarInfoUserResult.
     */
    public BigDecimal getOCodError()
    {
        return myOCodError;
    }

    /**
     * Sets the OCodError value of this SpSegBuscarInfoUserResult.
     */
    public void setOCodError(BigDecimal value)
    {
        myOCodError = value;
    }

    /**
     * Sets the array of RowSets of this SpSegBuscarInfoUserResult.
     */
    void setRowSets(RowSet[] value)
    {
        myRowSets = value;
    }

    /**
     * Gets the number of RowSets of this SpSegBuscarInfoUserResult.
     */
    public int getRowSetCount()
    {
        return (myRowSets != null) ? myRowSets.length : 0;
    }

    /**
     * Gets the RowSet at the specified index.
     */
    public RowSet getRowSet(int index)
    {
        if (index < 0 || index >= getRowSetCount())
            throw new ArrayIndexOutOfBoundsException(index);
        return myRowSets[index];
    }
} 
