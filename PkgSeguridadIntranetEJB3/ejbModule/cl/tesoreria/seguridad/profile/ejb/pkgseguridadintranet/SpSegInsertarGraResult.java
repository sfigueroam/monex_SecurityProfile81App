/*
 * @(#)SpSegInsertarGraResult.java  2008/09/09 16:44:58
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.195.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:4C88ZjbhtEEl5ThwEHfYV0>>.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;

/**
 * Output parameters of procedure "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_GRA".
 */
public class SpSegInsertarGraResult implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    private BigDecimal myOCodError;

    /**
     * Create a new SpSegInsertarGraResult.
     */
    public SpSegInsertarGraResult() {}

    /**
     * Gets the OCodError value of this SpSegInsertarGraResult.
     */
    public BigDecimal getOCodError()
    {
        return myOCodError;
    }

    /**
     * Sets the OCodError value of this SpSegInsertarGraResult.
     */
    public void setOCodError(BigDecimal value)
    {
        myOCodError = value;
    }
}
