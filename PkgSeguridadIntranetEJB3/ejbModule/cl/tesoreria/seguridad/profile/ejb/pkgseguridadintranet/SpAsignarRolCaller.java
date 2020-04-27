/*
 * @(#)SpAsignarRolCaller.java  28-FEB-2013 11:02
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
 * Implements a caller of the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_ASIGNAR_ROL" database procedure.
 */
public class SpAsignarRolCaller extends ProcedureCaller
{
    /**
     * Executes the "SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_ASIGNAR_ROL" database procedure.
     *
     *  id_aplicacion_in  in number 
     *  nombre_rol_in     in nvarchar2
     *  rut_in            in number
     *  cod_error_out     out number
     *  existe_rut_out    out number
     *  existe_rol_out    out number
     *  msg_error_out     out nvarchar2)
     */
    public static SpAsignarRolResult execute(DataSource dataSource, BigDecimal id_aplicacion, String nombre_rol,BigDecimal rut)
        throws java.sql.SQLException
    {
        SpAsignarRolResult result = new SpAsignarRolResult();
        Connection conn = dataSource.getConnection();
        try
        {
            ArrayList resultSets = new ArrayList();
            String dbmsURL = conn.getMetaData().getURL();
            if (dbmsURL.startsWith("jdbc:oracle:thin"))
            {
                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_ASIGNAR_ROL(?,?,?,?,?,?,?)}");
                try
                {
                    call.setBigDecimal(1,id_aplicacion);
                    call.setString(2, nombre_rol);                    
                    call.setBigDecimal(3,rut);
                    
                    call.registerOutParameter(4, Types.NUMERIC);
                    call.registerOutParameter(5, Types.NUMERIC);
                    call.registerOutParameter(6, Types.NUMERIC);
                    call.registerOutParameter(7, Types.VARCHAR);

                    executeCall(call, resultSets);
                    
                    result.setCodErrorOut(call.getBigDecimal(4));
                    result.setExisteRutOut(call.getBigDecimal(5));
                    result.setExisteRolOut(call.getBigDecimal(6));
                    result.setMsgErrorOut(call.getString(7));
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
