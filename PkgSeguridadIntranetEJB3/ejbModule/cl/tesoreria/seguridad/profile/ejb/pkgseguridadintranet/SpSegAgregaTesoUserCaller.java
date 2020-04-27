package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import javax.sql.DataSource;

public class SpSegAgregaTesoUserCaller extends ProcedureCaller
{ 
    
   /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_GRA" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * I_NOMBRE_GRANT     VARCHAR2(4000)     Input
     */
    public static SpSegAgregaTesoUserResult execute(DataSource dataSource, BigDecimal iUserId, BigDecimal iTesoId)
        throws java.sql.SQLException
    {
        SpSegAgregaTesoUserResult result = new SpSegAgregaTesoUserResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_AGREGA_TESO_USER(?,?,?)}");
            try
            {
                call.registerOutParameter(1, Types.NUMERIC);
                call.setBigDecimal(2, iUserId);
                call.setBigDecimal(3, iTesoId);
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
