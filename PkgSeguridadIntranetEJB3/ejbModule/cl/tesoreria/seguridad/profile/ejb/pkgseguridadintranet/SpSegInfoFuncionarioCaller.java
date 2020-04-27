/*
 * @(#)SpSegInfoFuncionarioCaller.java  04-ENE-2013 09:55
 * author M. Corona.
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
 * Implements a caller of the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INFO_FUNCIONARIO" database procedure.
 */
public class SpSegInfoFuncionarioCaller extends ProcedureCaller
{
    /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INFO_FUNCIONARIO" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * CUR_RETURN         REF CURSOR         Output
     * I_RUT              NUMBER             Input
     * I_Dv               VARCHAR2           Input
     */
    public static SpSegInfoFuncionarioResult execute(DataSource dataSource, BigDecimal iRut, String iDv)
        throws java.sql.SQLException
    {
        SpSegInfoFuncionarioResult result = new SpSegInfoFuncionarioResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            String dbmsURL = conn.getMetaData().getURL();
            if (dbmsURL.startsWith("jdbc:oracle:thin"))
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INFO_FUNCIONARIO(?,?,?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.registerOutParameter(2, ORACLE_CURSOR);
                    call.setBigDecimal(3,iRut);
                    call.setString(4, iDv);                    
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
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INFO_FUNCIONARIO(?,?,?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.setBigDecimal(2,iRut);
                    call.setString(3, iDv);                    
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
