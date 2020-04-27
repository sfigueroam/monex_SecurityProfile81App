package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet; 

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import javax.sql.DataSource;

public class SpSegConsultaAplTesoUserCaller extends ProcedureCaller
{
     public static SpSegConsultaAplTesoUserResult execute(DataSource dataSource, BigDecimal i_user_id, BigDecimal i_teso_id, BigDecimal i_apl_user)
        throws java.sql.SQLException
    {
        SpSegConsultaAplTesoUserResult result = new SpSegConsultaAplTesoUserResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            String dbmsURL = conn.getMetaData().getURL();
            if (dbmsURL.startsWith("jdbc:oracle:thin"))
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_CONSULTA_APL_TESO_USER(?,?,?,?,?)}");
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
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_CONSULTA_APL_TESO_USER(?,?,?,?}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.setBigDecimal(3, i_user_id);
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
