/*
 * @(#)SpSegInsertarModCaller.java  2008/09/09 16:44:59
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.195.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:gwhvk6d4UUSEquHdQsEU-8>>.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import javax.sql.DataSource;

/**
 * Implements a caller of the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_MOD" database procedure.
 */
public class SpSegInsertarRutUserCaller extends ProcedureCaller
{
    /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_MOD" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * I_APP              NUMBER             Input
     * I_NOMBRE_MOD       VARCHAR2(4000)     Input
     */
    public static SpSegInsertarRutUserResult execute(DataSource dataSource, BigDecimal iIdUser, BigDecimal iRut,String iDv)
        throws java.sql.SQLException
    {
        SpSegInsertarRutUserResult result = new SpSegInsertarRutUserResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_RUT_USER(?,?,?,?)}");
            try
            {
                call.registerOutParameter(1, Types.NUMERIC);
                call.setBigDecimal(2, iIdUser);
                call.setBigDecimal(3, iRut);
                call.setString(4, iDv);
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