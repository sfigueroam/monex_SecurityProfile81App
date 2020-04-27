package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.sql.DataSource;

public class SpSegConsultaUserCaller extends ProcedureCaller
{ 
   /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_TESO_USER" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * CUR_RETURN         REF CURSOR         Output
     * I_USER             VARCHAR2(4000)     Input
     * I_APP_ID           NUMBER             Input
     */
    public static SpSegConsultaUserResult execute(DataSource dataSource, BigDecimal i_user_id)
        throws java.sql.SQLException
    {
        SpSegConsultaUserResult result = new SpSegConsultaUserResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            String dbmsURL = conn.getMetaData().getURL();
            if (dbmsURL.startsWith("jdbc:oracle:thin"))
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_CONSULTA_USER(?,?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.registerOutParameter(2, ORACLE_CURSOR);
                    call.setBigDecimal(3, i_user_id);
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
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_CONSULTA_USER(?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.setBigDecimal(2, i_user_id);
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
