/*
 * @(#)SpSegBuscarRolNombreCaller.java  2008/09/09 16:44:58
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.195.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:32SIIP0pl8dyUgM5653B8V>>.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.sql.DataSource;

/**
 * Implements a caller of the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NOMBRE" database procedure.
 */
public class SpSegBuscarRolNombreCaller extends ProcedureCaller
{
    /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NOMBRE" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * CUR_RETURN         REF CURSOR         Output
     * I_ROLNOMBRE        VARCHAR2(4000)     Input
     * I_ROLESTADO        VARCHAR2(4000)     Input
     * I_APL_ID           NUMBER             Input
     */
    public static SpSegBuscarRolNombreResult execute(DataSource dataSource, String iRolnombre, String iRolestado, BigDecimal iAplId)
        throws java.sql.SQLException
    {
        SpSegBuscarRolNombreResult result = new SpSegBuscarRolNombreResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            String dbmsURL = conn.getMetaData().getURL();
            if (dbmsURL.startsWith("jdbc:oracle:thin"))
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NOMBRE(?,?,?,?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.registerOutParameter(2, ORACLE_CURSOR);
                    call.setString(3, iRolnombre);
                    call.setString(4, iRolestado);
                    call.setBigDecimal(5, iAplId);
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
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NOMBRE(?,?,?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.setString(2, iRolnombre);
                    call.setString(3, iRolestado);
                    call.setBigDecimal(4, iAplId);
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
