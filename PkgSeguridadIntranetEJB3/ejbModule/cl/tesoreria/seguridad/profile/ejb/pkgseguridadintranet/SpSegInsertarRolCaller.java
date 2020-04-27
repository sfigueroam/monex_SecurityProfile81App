/*
 * @(#)SpSegInsertarRolCaller.java  2008/09/09 16:44:59
 *
 * This file was generated by "OBCOM SQL Wizard" version 5.1.195.
 * Copyright (c) OBCOM INGENIERIA S.A. (Chile) All rights reserved.
 * OBCOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * DO NOT EDIT THIS FILE <<Signature:HAreiCna60l8nUy2qGM+la>>.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import javax.sql.DataSource;

/**
 * Implements a caller of the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL" database procedure.
 */
public class SpSegInsertarRolCaller extends ProcedureCaller
{
    /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * I_NOMBRE_ROL       VARCHAR2(4000)     Input
     * I_ROL_TIPO         VARCHAR2(4000)     Input
     * I_ROL_JERARQ       NUMBER             Input
     * I_ROL_ESTADO       VARCHAR2(4000)     Input
     * I_APL_ID           NUMBER             Input
     */
    public static SpSegInsertarRolResult execute(DataSource dataSource, String iNombreRol, String iRolTipo, BigDecimal iRolJerarq, String iRolEstado, BigDecimal iAplId)
        throws java.sql.SQLException
    {
        SpSegInsertarRolResult result = new SpSegInsertarRolResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL(?,?,?,?,?,?)}");
            try
            {
                call.registerOutParameter(1, Types.NUMERIC);
                call.setString(2, iNombreRol);
                call.setString(3, iRolTipo);
                call.setBigDecimal(4, iRolJerarq);
                call.setString(5, iRolEstado);
                call.setBigDecimal(6, iAplId);
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
