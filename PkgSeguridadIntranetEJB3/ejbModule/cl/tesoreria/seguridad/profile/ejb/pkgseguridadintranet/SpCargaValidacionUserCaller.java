package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import cl.tesoreria.seguridad.profile.vo.CargaMasiva;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.sql.DataSource;


public class SpCargaValidacionUserCaller extends ProcedureCaller
{

    public static SpCargaValidacionUserResult execute(DataSource dataSource, CargaMasiva cmasiva)
        throws java.sql.SQLException
    {
        SpCargaValidacionUserResult result = new SpCargaValidacionUserResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            String dbmsURL = conn.getMetaData().getURL();
            if (dbmsURL.startsWith("jdbc:oracle:thin"))
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_VALIDA_CARGA_MASIVA(?,?,?,?,?,?,?,?)}");
                try
                {
                    call.registerOutParameter(1, ORACLE_CURSOR);
                    call.setString(2, cmasiva.getRut());
                    call.setString(3, cmasiva.getPass());
                    call.setString(4, cmasiva.getDescripcion());
                    call.setString(5, cmasiva.getRol());
                    call.setString(6, cmasiva.getTipoCarga());
                    call.setString(7, cmasiva.getIdCarga());
                    call.setString(8, cmasiva.getIdApp());
                    
                    executeCall(call, resultSets);
                }
                finally
                {
                    call.close();
                }
            }
            else
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_VALIDA_CARGA_MASIVA(?,?,?,?,?,?,?)}");
                try
                {

                    call.setString(2, cmasiva.getRut());
                    call.setString(3, cmasiva.getPass());
                    call.setString(4, cmasiva.getDescripcion());
                    call.setString(5, cmasiva.getRol());
                    call.setString(6, cmasiva.getObservacion());
                    call.setString(7, cmasiva.getIdCarga());
                    call.setString(8, cmasiva.getIdApp());
                    executeCall(call, resultSets);
                }
                finally
                {
                    call.close();
                }
            }
        }
        finally
        {
            conn.close();
        }
        return result;
    }
}
