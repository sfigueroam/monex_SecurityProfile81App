/*
 * @(#)SpSegBuscarInfoUserCaller.java  2008/09/09 16:44:58
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.195.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:jK1Bq1Aja14uJkelcLvyZo>>.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.sql.DataSource;

/**
 * Implements a caller of the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_INFO_USER" database procedure.
 */
public class SpSegBuscarInfoUserCaller extends ProcedureCaller
{
    /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_INFO_USER" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * CUR_RETURN         REF CURSOR         Output
     * I_RUT              VARCHAR2(4000)     Input
     */
    public static SpSegBuscarInfoUserResult execute(DataSource dataSource, String iRut)
        throws java.sql.SQLException
    {
        SpSegBuscarInfoUserResult result = new SpSegBuscarInfoUserResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            String dbmsURL = conn.getMetaData().getURL();
            if (dbmsURL.startsWith("jdbc:oracle:thin"))
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_INFO_USER(?,?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.registerOutParameter(2, ORACLE_CURSOR);
                    call.setString(3, iRut);
                    executeCall(call, resultSets);
                    result.setOCodError(call.getBigDecimal(1));
                    addResultSet((ResultSet) call.getObject(2), resultSets);
                }
                finally
                {
                    call.close();
                }
            }
            else
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_INFO_USER(?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.setString(2, iRut);
                    executeCall(call, resultSets);
                    result.setOCodError(call.getBigDecimal(1));
                }
                finally
                {
                    call.close();
                }
            }
            result.setRowSets(toRowSets(resultSets));
        }
        finally
        {
            conn.close();
        }
        return result;
    }
}