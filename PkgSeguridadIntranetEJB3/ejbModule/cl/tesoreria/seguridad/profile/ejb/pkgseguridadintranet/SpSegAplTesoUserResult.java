package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet; 
import java.math.BigDecimal;
import javax.sql.RowSet;

public class SpSegAplTesoUserResult implements java.io.Serializable
{ 
    private static final long serialVersionUID = 1L;
    private BigDecimal myOCodError;
    private RowSet[] myRowSets;
    
    public SpSegAplTesoUserResult(){}
    
    public BigDecimal getOCodError()
    {
        return myOCodError;
    }
    
    
    /**
     * Sets the OCodError value of this SpSegBuscarPagResult.
     */
    public void setOCodError(BigDecimal value)
    {
        myOCodError = value;
    }

    /**
     * Sets the array of RowSets of this SpSegBuscarPagResult.
     */
    void setRowSets(RowSet[] value)
    {
        myRowSets = value;
    }

    /**
     * Gets the number of RowSets of this SpSegBuscarPagResult.
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
