package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import java.sql.Date;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

import cl.tesoreria.seguridad.profile.vo.CargaMasiva;

/**
 * Session Bean implementation class PkgSeguridadIntranetEJB3
 */
@Stateless(mappedName = "cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.PkgSeguridadIntranetEJB3")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PkgSeguridadIntranetEJB3 implements
		PkgSeguridadIntranetEJB3Remote, PkgSeguridadIntranetEJB3Local {

	@Resource(lookup = "java:/jdbc/seguridadDS")
	DataSource dataSource;

	/**
	 * Default constructor.
	 */
	public PkgSeguridadIntranetEJB3() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SpAsignarRolResult spAsignarRol(BigDecimal id_aplicacion,
			String nombre_rol, BigDecimal rut)
			throws PkgSeguridadIntranetException {
		try {
			return SpAsignarRolCaller.execute(dataSource, id_aplicacion,
					nombre_rol, rut);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.sp_asignar_rol", ex);
		}
	}

	@Override
	public SpAuditoriaFuncionarioResult spAuditoriaFuncionario(String iUserName)
			throws PkgSeguridadIntranetException {
		try {
			return SpAuditoriaFuncionarioCaller.execute(dataSource, iUserName);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_AUDITORIA_FUNCIONARIO", ex);
		}
	}

	@Override
	public SpCargaValidacionUserResult spCargaMasiva(CargaMasiva cmasiva)
			throws PkgSeguridadIntranetException {
		try {
			return SpCargaValidacionUserCaller.execute(dataSource, cmasiva);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_VALIDA_CARGA_MASIVA", ex);
		}
	}

	@Override
	public SpSegAgregaTesoUserResult spSegAgregaTesoUsr(BigDecimal iUserId,
			BigDecimal iTesoId) throws PkgSeguridadIntranetException {
		try {
			return SpSegAgregaTesoUserCaller.execute(dataSource, iUserId,
					iTesoId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_AGREGA_TESO_USR", ex);
		}
	}

	@Override
	public SpSegAplTesoUserResult spSegAplTesoUsr(BigDecimal i_user_id)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegAplTesoUserCaller.execute(dataSource, i_user_id);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_APL_TESO_USER", ex);
		}
	}

	@Override
	public SpSegBuscarActResult spSegBuscarAct(String iVisible, BigDecimal iPage)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarActCaller.execute(dataSource, iVisible, iPage);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ACT", ex);
		}
	}

	@Override
	public SpSegBuscarActNoRolResult spSegBuscarActNoRol(String iVisible,
			BigDecimal iRol) throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarActNoRolCaller
					.execute(dataSource, iVisible, iRol);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ACT_NO_ROL", ex);
		}
	}

	@Override
	public SpSegBuscarActRolResult spSegBuscarActRol(String iVisible,
			BigDecimal iRol) throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarActRolCaller.execute(dataSource, iVisible, iRol);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ACT_ROL", ex);
		}
	}

	@Override
	public SpSegBuscarAppResult spSegBuscarApp()
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarAppCaller.execute(dataSource);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_APP", ex);
		}
	}

	@Override
	public SpSegBuscarAppModResult spSegBuscarAppMod(BigDecimal iIdMod)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarAppModCaller.execute(dataSource, iIdMod);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_APP_MOD", ex);
		}
	}

	@Override
	public SpSegBuscarGraResult spSegBuscarGra(String iGrantEstado)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarGraCaller.execute(dataSource, iGrantEstado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRA", ex);
		}
	}

	@Override
	public SpSegBuscarGraUrlResult spSegBuscarGraUrl(String iUser, String iUrl)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarGraUrlCaller.execute(dataSource, iUser, iUrl);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRA_URL", ex);
		}
	}

	@Override
	public SpSegBuscarGroupsUserResult spSegBuscarGroupsUser(BigDecimal iUserId)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarGroupsUserCaller.execute(dataSource, iUserId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GROUPS_USER", ex);
		}
	}

	@Override
	public SpSegBuscarGruNoRolResult spSegBuscarGruNoRol(String iIdRol,
			String iRolEstado) throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarGruNoRolCaller.execute(dataSource, iIdRol,
					iRolEstado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRU_NO_ROL", ex);
		}
	}

	@Override
	public SpSegBuscarGruNombreResult spSegBuscarGruNombre(String iGroup)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarGruNombreCaller.execute(dataSource, iGroup);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRU_NOMBRE", ex);
		}
	}

	@Override
	public SpSegBuscarGruRolResult spSegBuscarGruRol(String iRol,
			String iRolestado) throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarGruRolCaller
					.execute(dataSource, iRol, iRolestado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRU_ROL", ex);
		}
	}

	@Override
	public SpSegBuscarIdResult spSegBuscarId(BigDecimal iAppId, String iUser)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarIdCaller.execute(dataSource, iAppId, iUser);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ID", ex);
		}
	}

	@Override
	public SpSegBuscarInfoUserResult spSegBuscarInfoUser(String iRut)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarInfoUserCaller.execute(dataSource, iRut);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_INFO_USER", ex);
		}
	}

	@Override
	public SpSegBuscarModResult spSegBuscarMod(BigDecimal iApp)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarModCaller.execute(dataSource, iApp);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_MOD", ex);
		}
	}

	@Override
	public SpSegBuscarPagResult spSegBuscarPag(BigDecimal iMod, BigDecimal iApp)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarPagCaller.execute(dataSource, iMod, iApp);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_PAG", ex);
		}
	}

	@Override
	public SpSegBuscarRechazadosResult spSegBuscarRechazados(BigDecimal i_carga)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRechazadosCaller.execute(dataSource, i_carga);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_RECHAZADOS", ex);
		}
	}

	@Override
	public SpSegBuscarRolResult spSegBuscarRol(String iRolestado,
			BigDecimal iAplId) throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRolCaller.execute(dataSource, iRolestado, iAplId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL", ex);
		}
	}

	@Override
	public SpSegBuscarRolGruResult spSegBuscarRolGru(String iGroup,
			String iRolestado, BigDecimal iAppid)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRolGruCaller.execute(dataSource, iGroup,
					iRolestado, iAppid);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_GRU", ex);
		}
	}

	@Override
	public SpSegBuscarRolNoGruResult spSegBuscarRolNoGru(String iGroup,
			String iRolestado, String iRoltipo, BigDecimal iAppid)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRolNoGruCaller.execute(dataSource, iGroup,
					iRolestado, iRoltipo, iAppid);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NO_GRU", ex);
		}
	}

	@Override
	public SpSegBuscarRolNoUsrResult spSegBuscarRolNoUsr(String iUser,
			String iRolestado, String iRoltipo, BigDecimal iAppid)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRolNoUsrCaller.execute(dataSource, iUser,
					iRolestado, iRoltipo, iAppid);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NO_USR", ex);
		}
	}

	@Override
	public SpSegBuscarRolNombreResult spSegBuscarRolNombre(String iRolnombre,
			String iRolestado, BigDecimal iAplId)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRolNombreCaller.execute(dataSource, iRolnombre,
					iRolestado, iAplId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NOMBRE", ex);
		}
	}

	@Override
	public SpSegBuscarRolTipoResult spSegBuscarRolTipo(String iRoltipo,
			String iRolestado, BigDecimal iAplId)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRolTipoCaller.execute(dataSource, iRoltipo,
					iRolestado, iAplId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_TIPO", ex);
		}
	}

	@Override
	public SpSegBuscarRolTipoNombreResult spSegBuscarRolTipoNombre(
			String iRoltipo, String iRolnombre, BigDecimal iAplId)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRolTipoNombreCaller.execute(dataSource, iRoltipo,
					iRolnombre, iAplId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_TIPO_NOMBRE", ex);
		}
	}

	@Override
	public SpSegBuscarRolUsrResult spSegBuscarRolUsr(String iUser,
			String iRolestado, BigDecimal iAppid)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRolUsrCaller.execute(dataSource, iUser,
					iRolestado, iAppid);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_USR", ex);
		}
	}

	@Override
	public SpSegBuscarRutUserResult spSegBuscarRutUser(BigDecimal iIdUser)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarRutUserCaller.execute(dataSource, iIdUser);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_RUT_USER", ex);
		}
	}

	@Override
	public SpSegBuscarTesoUserResult spSegBuscarTesoUser(String iUser,
			BigDecimal iAppId) throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarTesoUserCaller.execute(dataSource, iUser, iAppId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_TESO_USER", ex);
		}
	}

	@Override
	public SpSegBuscarTesoreriasResult spSegBuscarTesorerias()
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarTesoreriasCaller.execute(dataSource);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_TESORERIAS", ex);
		}
	}

	@Override
	public SpSegBuscarUsersGroupResult spSegBuscarUsersGroup(BigDecimal iGroupId)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarUsersGroupCaller.execute(dataSource, iGroupId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USERS_GROUP", ex);
		}
	}

	@Override
	public SpSegBuscarUsrConNombreResult spSegBuscarUsrConNombre(String iUser)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarUsrConNombreCaller.execute(dataSource, iUser);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USR_CON_NOMBRE", ex);
		}
	}

	@Override
	public SpSegBuscarUsrNoRolResult spSegBuscarUsrNoRol(String iIdRol,
			String iRolEstado) throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarUsrNoRolCaller.execute(dataSource, iIdRol,
					iRolEstado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USR_NO_ROL", ex);
		}
	}

	@Override
	public SpSegBuscarUsrNombreResult spSegBuscarUsrNombre(String iUser)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarUsrNombreCaller.execute(dataSource, iUser);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USR_NOMBRE", ex);
		}
	}

	@Override
	public SpSegBuscarUsrRolResult spSegBuscarUsrRol(String iRol,
			String iRolestado) throws PkgSeguridadIntranetException {
		try {
			return SpSegBuscarUsrRolCaller
					.execute(dataSource, iRol, iRolestado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USR_ROL", ex);
		}
	}

	@Override
	public SpSegConsultaAplTesoUserResult spSegConsultaAplTesoUsr(
			BigDecimal i_user_id, BigDecimal i_teso_id, BigDecimal i_apl_id)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegConsultaAplTesoUserCaller.execute(dataSource,
					i_user_id, i_teso_id, i_apl_id);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_CONSULTA_APL_TESO_USER", ex);
		}
	}

	@Override
	public SpSegConsultaUserResult spSegConsultaUsr(BigDecimal i_user_id)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegConsultaUserCaller.execute(dataSource, i_user_id);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_CONSULTA_USER", ex);
		}
	}

	@Override
	public SpSegEliminarTesoUserResult spSegEliminarTesoUsr(BigDecimal iAppId,
			BigDecimal iUserId, BigDecimal iTesoId)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegEliminarTesoUserCaller.execute(dataSource, iAppId,
					iUserId, iTesoId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_ELIMINAR_TESO_USR", ex);
		}
	}

	@Override
	public SpSegInfoFuncionarioResult spSegInfoFuncionario(BigDecimal iRut,
			String iDv) throws PkgSeguridadIntranetException {
		try {
			return SpSegInfoFuncionarioCaller.execute(dataSource, iRut, iDv);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INFO_FUNCIONARIO", ex);
		}
	}

	@Override
	public SpSegInsertarActResult spSegInsertarAct(String iActRuta,
			BigDecimal iIdPage, String iActNombre, String iActVisible)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarActCaller.execute(dataSource, iActRuta,
					iIdPage, iActNombre, iActVisible);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ACT", ex);
		}
	}

	@Override
	public SpSegInsertarAppResult spSegInsertarApp(String iNombreApp)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarAppCaller.execute(dataSource, iNombreApp);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_APP", ex);
		}
	}

	@Override
	public SpSegInsertarGraResult spSegInsertarGra(String iNombreGrant)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarGraCaller.execute(dataSource, iNombreGrant);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_GRA", ex);
		}
	}

	@Override
	public SpSegInsertarIdResult spSegInsertarId(BigDecimal iGrantId,
			BigDecimal iRol, BigDecimal iPagina, String iUrl,
			Date iFechaInicio, Date iFechaTermino)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarIdCaller.execute(dataSource, iGrantId, iRol,
					iPagina, iUrl, iFechaInicio, iFechaTermino);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ID", ex);
		}
	}

	@Override
	public SpSegInsertarModResult spSegInsertarMod(BigDecimal iApp,
			String iNombreMod) throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarModCaller.execute(dataSource, iApp, iNombreMod);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_MOD", ex);
		}
	}

	@Override
	public SpSegInsertarPagResult spSegInsertarPag(String iNombrePag,
			BigDecimal iIdMod, BigDecimal iIdApp)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarPagCaller.execute(dataSource, iNombrePag,
					iIdMod, iIdApp);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_PAG", ex);
		}
	}

	@Override
	public SpSegInsertarRolResult spSegInsertarRol(String iNombreRol,
			String iRolTipo, BigDecimal iRolJerarq, String iRolEstado,
			BigDecimal iAplId) throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarRolCaller.execute(dataSource, iNombreRol,
					iRolTipo, iRolJerarq, iRolEstado, iAplId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL", ex);
		}
	}

	@Override
	public SpSegInsertarRolGruResult spSegInsertarRolGru(BigDecimal iGroupId,
			BigDecimal iRol, Date iFechaInicio, Date iFechaTermino,
			String iRolEstado) throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarRolGruCaller.execute(dataSource, iGroupId,
					iRol, iFechaInicio, iFechaTermino, iRolEstado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL_GRU", ex);
		}
	}

	@Override
	public SpSegInsertarRolUsrResult spSegInsertarRolUsr(BigDecimal iRol,
			BigDecimal iUserId, Date iFechaInicio, Date iFechaTermino,
			String iRolEstado) throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarRolUsrCaller.execute(dataSource, iRol, iUserId,
					iFechaInicio, iFechaTermino, iRolEstado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL_USR", ex);
		}
	}

	@Override
	public SpSegInsertarRutUserResult spSegInsertarRutUser(BigDecimal iIdUser,
			BigDecimal iRut, String iDv) throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarRutUserCaller.execute(dataSource, iIdUser,
					iRut, iDv);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_RUT_USER", ex);
		}
	}

	@Override
	public SpSegInsertarTesoUserResult spSegInsertarTesoUser(BigDecimal iAppId,
			BigDecimal iUserId, BigDecimal iTesoId)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegInsertarTesoUserCaller.execute(dataSource, iAppId,
					iUserId, iTesoId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_TESO_USER", ex);
		}
	}

	@Override
	public SpSegListaRechazadosResult spSegListaRechazados(BigDecimal i_carga,
			String tipo) throws PkgSeguridadIntranetException {
		try {
			return SpSegListaRechazadosCaller
					.execute(dataSource, i_carga, tipo);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_RECHAZADOS", ex);
		}
	}

	@Override
	public SpSegModificarActResult spSegModificarAct(String iActRuta,
			BigDecimal iPage, String iActNombre, String iActVisible)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarActCaller.execute(dataSource, iActRuta, iPage,
					iActNombre, iActVisible);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ACT", ex);
		}
	}

	@Override
	public SpSegModificarAppResult spSegModificarApp(BigDecimal iApp,
			String iNombreApp) throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarAppCaller
					.execute(dataSource, iApp, iNombreApp);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_APP", ex);
		}
	}

	@Override
	public SpSegModificarGraResult spSegModificarGra(BigDecimal iGrant,
			String iNombreGrant, String iGrantEstado)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarGraCaller.execute(dataSource, iGrant,
					iNombreGrant, iGrantEstado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_GRA", ex);
		}
	}

	@Override
	public SpSegModificarIdResult spSegModificarId(BigDecimal iGrantId,
			BigDecimal iRol, BigDecimal iPagina, BigDecimal iModulo,
			BigDecimal iApp, String iUrl, Date iFechaInicio, Date iFechaTermino)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarIdCaller.execute(dataSource, iGrantId, iRol,
					iPagina, iModulo, iApp, iUrl, iFechaInicio, iFechaTermino);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ID", ex);
		}
	}

	@Override
	public SpSegModificarModResult spSegModificarMod(BigDecimal iMod,
			BigDecimal iApp, String iNombreMod)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarModCaller.execute(dataSource, iMod, iApp,
					iNombreMod);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_MOD", ex);
		}
	}

	@Override
	public SpSegModificarPagResult spSegModificarPag(BigDecimal iPage,
			String iNombrePag, BigDecimal iIdMod, BigDecimal iIdApp)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarPagCaller.execute(dataSource, iPage,
					iNombrePag, iIdMod, iIdApp);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_PAG", ex);
		}
	}

	@Override
	public SpSegModificarRolResult spSegModificarRol(BigDecimal iRol,
			String iNombreRol, String iRolTipo, BigDecimal iRolJerarq,
			String iRolEstado, BigDecimal iAplId)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarRolCaller.execute(dataSource, iRol,
					iNombreRol, iRolTipo, iRolJerarq, iRolEstado, iAplId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ROL", ex);
		}
	}

	@Override
	public SpSegModificarRolGruResult spSegModificarRolGru(BigDecimal iGroupId,
			BigDecimal iRol, Date iFechaInicio, Date iFechaTermino,
			String iRolEstado) throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarRolGruCaller.execute(dataSource, iGroupId,
					iRol, iFechaInicio, iFechaTermino, iRolEstado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ROL_GRU", ex);
		}
	}

	@Override
	public SpSegModificarRolUsrResult spSegModificarRolUsr(BigDecimal iRol,
			BigDecimal iUserId, Date iFechaInicio, Date iFechaTermino,
			String iRolEstado) throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarRolUsrCaller.execute(dataSource, iRol,
					iUserId, iFechaInicio, iFechaTermino, iRolEstado);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ROL_USR", ex);
		}
	}

	@Override
	public SpSegModificarTesoUserResult spSegModificarTesoUsr(
			BigDecimal iAppId, BigDecimal iUserId, BigDecimal iTesoId)
			throws PkgSeguridadIntranetException {
		try {
			return SpSegModificarTesoUserCaller.execute(dataSource, iAppId,
					iUserId, iTesoId);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_TESO_USR", ex);
		}
	}

	@Override
	public SpSeqCargaResult spSeqCarga(String inStr)
			throws PkgSeguridadIntranetException {
		try {
			return SpSeqCargaCaller.execute(dataSource, inStr);
		} catch (java.sql.SQLException ex) {
			throw new PkgSeguridadIntranetException(
					"PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_APP", ex);
		}
	}

}
