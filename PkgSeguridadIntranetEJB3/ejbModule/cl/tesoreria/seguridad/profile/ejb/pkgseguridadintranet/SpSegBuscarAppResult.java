/*
 * @(#)SpSegBuscarAppResult.java  2008/09/09 16:44:58
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.195.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:5vNTBT5HaQmitxkyD+S2c5>>.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import javax.sql.RowSet;

/**
 * Output parameters of procedure "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_APP".
 */
public class SpSegBuscarAppResult implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    private BigDecimal myOCodError;
    private RowSet[] myRowSets;

    /**
     * Create a new SpSegBuscarAppResult.
     */
    public SpSegBuscarAppResult() {}

    /**
     * Gets the OCodError value of this SpSegBuscarAppResult.
     */
    public BigDecimal getOCodError()
    {
        return myOCodError;
    }

    /**
     * Sets the OCodError value of this SpSegBuscarAppResult.
     */
    public void setOCodError(BigDecimal value)
    {
        myOCodError = value;
    }

    /**
     * Sets the array of RowSets of this SpSegBuscarAppResult.
     */
    void setRowSets(RowSet[] value)
    {
        myRowSets = value;
    }

    /**
     * Gets the number of RowSets of this SpSegBuscarAppResult.
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
