package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import javax.sql.DataSource;

public class SpSegEliminarTesoUserCaller extends ProcedureCaller
{ 
    /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_MOD" database procedure.
     *
     * O_COD_ERROR        NUMBER             Output
     * I_APP              NUMBER             Input
     * I_NOMBRE_MOD       VARCHAR2(4000)     Input
     */
    public static SpSegEliminarTesoUserResult execute(DataSource dataSource, BigDecimal iAppId,BigDecimal iUserId, BigDecimal iTesoId)
        throws java.sql.SQLException
    {
        SpSegEliminarTesoUserResult result = new SpSegEliminarTesoUserResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_ELIMINAR_TESO_USER(?,?,?,?)}");
            try
            {
                call.registerOutParameter(1, Types.NUMERIC);
                call.setBigDecimal(2, iAppId);
                call.setBigDecimal(3, iUserId);
                call.setBigDecimal(4, iTesoId);
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
