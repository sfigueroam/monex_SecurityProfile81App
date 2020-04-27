package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.sql.DataSource;

public class SpSegListaRechazadosCaller extends ProcedureCaller
{ 

    public static SpSegListaRechazadosResult execute(DataSource dataSource, BigDecimal i_carga, String tipo)
        throws java.sql.SQLException
    {
        SpSegListaRechazadosResult result = new SpSegListaRechazadosResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            String dbmsURL = conn.getMetaData().getURL();
            if (dbmsURL.startsWith("jdbc:oracle:thin"))
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_LISTA_RECHAZADOS(?,?,?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.registerOutParameter(2, ORACLE_CURSOR);
                    call.setBigDecimal(3, i_carga);
                    call.setString(4, tipo);
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
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_LISTA_RECHAZADOS(?,?,?)}");
                try
                {
                    call.registerOutParameter(1, Types.NUMERIC);
                    call.setBigDecimal(2, i_carga);
                     call.setString(3, tipo);
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
