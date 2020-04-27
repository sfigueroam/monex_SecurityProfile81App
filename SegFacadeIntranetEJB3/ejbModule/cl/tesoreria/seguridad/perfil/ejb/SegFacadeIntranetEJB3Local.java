package cl.tesoreria.seguridad.perfil.ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.ejb.Local;

import cl.tesoreria.seguridad.perfil.vo.AplTesoUserVO;
import cl.tesoreria.seguridad.perfil.vo.UserSecurityVO;
import cl.tesoreria.seguridad.perfil.vo.UserVO;
import cl.tesoreria.seguridad.profile.Users;

@Local
public interface SegFacadeIntranetEJB3Local {

	public String getPermisosUser(BigDecimal appId, String user)
			throws Exception;

	public BigDecimal getPermisosUserUrl(String userName, String url)
			throws Exception;

	public ArrayList getTesoreriasUser(BigDecimal appId, String user)
			throws Exception;

	public ArrayList getTesorerias() throws Exception;

	public Users getInfoUser(String rut) throws Exception;

	public Users getRutUser(BigDecimal rutUser) throws Exception;

	public Users getUserName(String userName) throws Exception;

	public UserVO getAuditoriaFuncionario(String userName) throws Exception;

	public AplTesoUserVO getConsultaAplTesoUser(BigDecimal idUser,
			BigDecimal idApl, BigDecimal idTeso) throws Exception;

	public ArrayList getTesoreiasAplUser(BigDecimal idUser) throws Exception;

	public UserSecurityVO getConsultaUser(BigDecimal idUser) throws Exception;

	public String testSaludar(String strMiguelCorona) throws Exception;
}
