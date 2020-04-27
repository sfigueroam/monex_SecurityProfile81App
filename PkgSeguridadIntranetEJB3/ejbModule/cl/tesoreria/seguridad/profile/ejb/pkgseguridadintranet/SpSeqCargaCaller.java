

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import javax.sql.DataSource;


public class SpSeqCargaCaller extends ProcedureCaller
{

    public static SpSeqCargaResult execute(DataSource dataSource, String inValor)
        throws java.sql.SQLException
    {
        SpSeqCargaResult result = new SpSeqCargaResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_CARGA_MASIVA(?,?)}");
            try
            {
                call.registerOutParameter(1, Types.NUMERIC);
                call.setString(2, inValor);
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
