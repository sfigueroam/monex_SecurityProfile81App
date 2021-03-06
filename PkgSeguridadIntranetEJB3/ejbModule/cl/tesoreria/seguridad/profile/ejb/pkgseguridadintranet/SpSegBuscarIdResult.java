/*
 * @(#)SpSegBuscarIdResult.java  2008/09/09 16:44:58
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.195.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:4jSI8Kn-dPXpryBa0IKht7>>.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;

/**
 * Output parameters of procedure "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ID".
 */
public class SpSegBuscarIdResult implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    private BigDecimal myOCodError;
    private String myOStrid;

    /**
     * Create a new SpSegBuscarIdResult.
     */
    public SpSegBuscarIdResult() {}

    /**
     * Gets the OCodError value of this SpSegBuscarIdResult.
     */
    public BigDecimal getOCodError()
    {
        return myOCodError;
    }

    /**
     * Sets the OCodError value of this SpSegBuscarIdResult.
     */
    public void setOCodError(BigDecimal value)
    {
        myOCodError = value;
    }

    /**
     * Gets the OStrid value of this SpSegBuscarIdResult.
     */
    public String getOStrid()
    {
        return myOStrid;
    }

    /**
     * Sets the OStrid value of this SpSegBuscarIdResult.
     */
    public void setOStrid(String value)
    {
        myOStrid = value;
    }
}
