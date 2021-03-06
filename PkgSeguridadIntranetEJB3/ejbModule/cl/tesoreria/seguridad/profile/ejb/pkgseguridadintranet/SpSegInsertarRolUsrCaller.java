/*
 * @(#)SpSegInsertarRolUsrCaller.java  2008/09/09 16:44:59
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.195.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:X3tVzbQQiOqsu1S1I4V2pM>>.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Types;
import javax.sql.DataSource;

/**
 * Implements a caller of the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL_USR" database procedure.
 */
public class SpSegInsertarRolUsrCaller extends ProcedureCaller
{
    /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL_USR" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * I_ROL              NUMBER             Input
     * I_USER_ID          NUMBER             Input
     * I_FECHA_INICIO     DATE               Input
     * I_FECHA_TERMINO    DATE               Input
     * I_ROL_ESTADO       VARCHAR2(4000)     Input
     */
    public static SpSegInsertarRolUsrResult execute(DataSource dataSource, BigDecimal iRol, BigDecimal iUserId, Date iFechaInicio, Date iFechaTermino, String iRolEstado)
        throws java.sql.SQLException
    {
        SpSegInsertarRolUsrResult result = new SpSegInsertarRolUsrResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL_USR(?,?,?,?,?,?)}");
            try
            {
                call.registerOutParameter(1, Types.NUMERIC);
                call.setBigDecimal(2, iRol);
                call.setBigDecimal(3, iUserId);
                call.setDate(4, iFechaInicio);
                call.setDate(5, iFechaTermino);
                call.setString(6, iRolEstado);
                executeCall(call, resultSets);
                result.setOCodError(call.getBigDecimal(1));
            }
            finally
            {
                call.close();
            }
        }
        finally
        {
            conn.close();
        }
        return result;
    }
}
