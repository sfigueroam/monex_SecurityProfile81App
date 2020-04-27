/*
 * @(#)SpSegInfoFuncionarioResult.java  04-ENE-2013 09:55
 * author M. Corona.
 */

package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import javax.sql.RowSet;

/**
 * Output parameters of procedure "PKG_SEGURIDAD_INTRANET.SP_ASIGNAR_ROL".
 */
public class SpAsignarRolResult implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    private BigDecimal codErrorOut;
    private BigDecimal existeRutOut;
    private BigDecimal existeRolOut;
    private String     msgErrorOut;


    /**
     * Create a new SpAsignarRolResult.
     */
    public SpAsignarRolResult() {}


	public BigDecimal getCodErrorOut() {
		return codErrorOut;
	}
	public void setCodErrorOut(BigDecimal codErrorOut) {
		this.codErrorOut = codErrorOut;
	}
	public BigDecimal getExisteRutOut() {
		return existeRutOut;
	}
	public void setExisteRutOut(BigDecimal existeRutOut) {
		this.existeRutOut = existeRutOut;
	}
	public BigDecimal getExisteRolOut() {
		return existeRolOut;
	}
	public void setExisteRolOut(BigDecimal existeRolOut) {
		this.existeRolOut = existeRolOut;
	}
	public String getMsgErrorOut() {
		return msgErrorOut;
	}
	public void setMsgErrorOut(String msgErrorOut) {
		this.msgErrorOut = msgErrorOut;
	}
	
}
