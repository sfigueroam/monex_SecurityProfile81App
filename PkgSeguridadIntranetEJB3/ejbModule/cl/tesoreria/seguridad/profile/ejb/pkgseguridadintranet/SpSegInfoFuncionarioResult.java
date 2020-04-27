/*
 * @(#)SpSegInfoFuncionarioResult.java  04-ENE-2013 09:55
 * author M. Corona.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import javax.sql.RowSet;

/**
 * Output parameters of procedure "PKG_SEGURIDAD_INTRANET.SP_SEG_INFO_FUNCIONARIO".
 */
public class SpSegInfoFuncionarioResult implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    private BigDecimal myOCodError;
    private RowSet[] myRowSets;

    /**
     * Create a new SpSegInfoFuncionarioResult.
     */
    public SpSegInfoFuncionarioResult() {}

    /**
     * Gets the OCodError value of this SpSegInfoFuncionarioResult.
     */
    public BigDecimal getOCodError()
    {
        return myOCodError;
    }

    /**
     * Sets the OCodError value of this SpSegInfoFuncionarioResult.
     */
    public void setOCodError(BigDecimal value)
    {
        myOCodError = value;
    }

    /**
     * Sets the array of RowSets of this SpSegInfoFuncionarioResult.
     */
    void setRowSets(RowSet[] value)
    {
        myRowSets = value;
    }

    /**
     * Gets the number of RowSets of this SpSegInfoFuncionarioResult.
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
