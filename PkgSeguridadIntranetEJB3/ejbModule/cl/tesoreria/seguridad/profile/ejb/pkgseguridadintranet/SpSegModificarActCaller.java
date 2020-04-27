/*
 * @(#)SpSegModificarPagCaller.java  2008/09/09 16:44:59
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.195.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:ZSAUbqIa-cO05u3i97YDNB>>.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import javax.sql.DataSource;

/**
 * Implements a caller of the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ACT" database procedure.
 */
public class SpSegModificarActCaller extends ProcedureCaller
{
    /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ACT" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * I_ACT_RUTA         VRACHAR2(1000)      Input
     * I_ID_PAGE             NUMBER           Input
     * I_ACT_NOMBRE       VARCHAR2(4000)      Input
     * I_ACT_VISIBLE      VARCHAR2(1)         Input 
     * 
     */
    public static SpSegModificarActResult execute(DataSource dataSource,String iActRuta, BigDecimal iPage, String iActNombre, String iVisible)
        throws java.sql.SQLException
    {
        SpSegModificarActResult result = new SpSegModificarActResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ACT(?,?,?,?,?)}");
            try
            {
                call.registerOutParameter(1, Types.NUMERIC);
                call.setString(2, iActRuta);
                call.setBigDecimal(3, iPage);
                call.setString(4, iActNombre);
                call.setString(5,iVisible);
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