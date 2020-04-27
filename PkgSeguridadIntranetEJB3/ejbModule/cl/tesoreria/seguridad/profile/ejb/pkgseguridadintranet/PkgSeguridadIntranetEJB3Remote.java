package cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet;

import java.math.BigDecimal;
import javax.ejb.Remote;

@Remote
public interface PkgSeguridadIntranetEJB3Remote {

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.sp_asignar_rol" database procedure.
	 * 28-Feb-2013 10:44:01 by mcorona
	 */
	public SpAsignarRolResult spAsignarRol(BigDecimal id_aplicacion,
			String nombre_rol, BigDecimal rut)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_AUDITORIA_FUNCIONARIO" database
	 * procedure.
	 */
	public SpAuditoriaFuncionarioResult spAuditoriaFuncionario(String iUserName)
			throws PkgSeguridadIntranetException;

	public SpCargaValidacionUserResult spCargaMasiva(
			cl.tesoreria.seguridad.profile.vo.CargaMasiva cmasiva)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ROL_USR" database
	 * procedure.
	 */
	public SpSegAgregaTesoUserResult spSegAgregaTesoUsr(BigDecimal iUserId,
			BigDecimal iTesoId) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRA" database
	 * procedure.
	 */
	public SpSegAplTesoUserResult spSegAplTesoUsr(BigDecimal i_user_id)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ACT" database
	 * procedure.
	 */
	public SpSegBuscarActResult spSegBuscarAct(String iVisible, BigDecimal iPage)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ACT_NO_ROL" database
	 * procedure.
	 */
	public SpSegBuscarActNoRolResult spSegBuscarActNoRol(String iVisible,
			BigDecimal iRol) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ACT_ROL" database
	 * procedure.
	 */
	public SpSegBuscarActRolResult spSegBuscarActRol(String iVisible,
			BigDecimal iRol) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_APP" database
	 * procedure.
	 */
	public SpSegBuscarAppResult spSegBuscarApp()
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_APP_MOD" database
	 * procedure.
	 */
	public SpSegBuscarAppModResult spSegBuscarAppMod(BigDecimal iIdMod)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRA" database
	 * procedure.
	 */
	public SpSegBuscarGraResult spSegBuscarGra(String iGrantEstado)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRA_URL" database
	 * procedure.
	 */
	public SpSegBuscarGraUrlResult spSegBuscarGraUrl(String iUser, String iUrl)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GROUPS_USER" database
	 * procedure.
	 */
	public SpSegBuscarGroupsUserResult spSegBuscarGroupsUser(BigDecimal iUserId)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRU_NO_ROL" database
	 * procedure.
	 */
	public SpSegBuscarGruNoRolResult spSegBuscarGruNoRol(String iIdRol,
			String iRolEstado) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRU_NOMBRE" database
	 * procedure.
	 */
	public SpSegBuscarGruNombreResult spSegBuscarGruNombre(String iGroup)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRU_ROL" database
	 * procedure.
	 */
	public SpSegBuscarGruRolResult spSegBuscarGruRol(String iRol,
			String iRolestado) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ID" database
	 * procedure.
	 */
	public SpSegBuscarIdResult spSegBuscarId(BigDecimal iAppId, String iUser)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_INFO_USER" database
	 * procedure.
	 */
	public SpSegBuscarInfoUserResult spSegBuscarInfoUser(String iRut)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_MOD" database
	 * procedure.
	 */
	public SpSegBuscarModResult spSegBuscarMod(BigDecimal iApp)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_PAG" database
	 * procedure.
	 */
	public SpSegBuscarPagResult spSegBuscarPag(BigDecimal iMod, BigDecimal iApp)
			throws PkgSeguridadIntranetException;

	public SpSegBuscarRechazadosResult spSegBuscarRechazados(BigDecimal i_carga)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL" database
	 * procedure.
	 */
	public SpSegBuscarRolResult spSegBuscarRol(String iRolestado,
			BigDecimal iAplId) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_GRU" database
	 * procedure.
	 */
	public SpSegBuscarRolGruResult spSegBuscarRolGru(String iGroup,
			String iRolestado, BigDecimal iAppid)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NO_GRU" database
	 * procedure.
	 */
	public SpSegBuscarRolNoGruResult spSegBuscarRolNoGru(String iGroup,
			String iRolestado, String iRoltipo, BigDecimal iAppid)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NO_USR" database
	 * procedure.
	 */
	public SpSegBuscarRolNoUsrResult spSegBuscarRolNoUsr(String iUser,
			String iRolestado, String iRoltipo, BigDecimal iAppid)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_NOMBRE" database
	 * procedure.
	 */
	public SpSegBuscarRolNombreResult spSegBuscarRolNombre(String iRolnombre,
			String iRolestado, BigDecimal iAplId)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_TIPO" database
	 * procedure.
	 */
	public SpSegBuscarRolTipoResult spSegBuscarRolTipo(String iRoltipo,
			String iRolestado, BigDecimal iAplId)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_TIPO_NOMBRE"
	 * database procedure.
	 */
	public SpSegBuscarRolTipoNombreResult spSegBuscarRolTipoNombre(
			String iRoltipo, String iRolnombre, BigDecimal iAplId)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ROL_USR" database
	 * procedure.
	 */
	public SpSegBuscarRolUsrResult spSegBuscarRolUsr(String iUser,
			String iRolestado, BigDecimal iAppid)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_RUT_USER" database
	 * procedure.
	 */
	public SpSegBuscarRutUserResult spSegBuscarRutUser(BigDecimal iIdUser)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_TESO_USER" database
	 * procedure.
	 */
	public SpSegBuscarTesoUserResult spSegBuscarTesoUser(String iUser,
			BigDecimal iAppId) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_TESORERIAS" database
	 * procedure.
	 */
	public SpSegBuscarTesoreriasResult spSegBuscarTesorerias()
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USERS_GROUP" database
	 * procedure.
	 */
	public SpSegBuscarUsersGroupResult spSegBuscarUsersGroup(BigDecimal iGroupId)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USR_CON_NOMBRE"
	 * database procedure.
	 */
	public SpSegBuscarUsrConNombreResult spSegBuscarUsrConNombre(String iUser)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USR_NO_ROL" database
	 * procedure.
	 */
	public SpSegBuscarUsrNoRolResult spSegBuscarUsrNoRol(String iIdRol,
			String iRolEstado) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USR_NOMBRE" database
	 * procedure.
	 */
	public SpSegBuscarUsrNombreResult spSegBuscarUsrNombre(String iUser)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_USR_ROL" database
	 * procedure.
	 */
	public SpSegBuscarUsrRolResult spSegBuscarUsrRol(String iRol,
			String iRolestado) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRA" database
	 * procedure.
	 */
	public SpSegConsultaAplTesoUserResult spSegConsultaAplTesoUsr(
			BigDecimal i_user_id, BigDecimal i_teso_id, BigDecimal i_apl_id)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_GRA" database
	 * procedure.
	 */
	public SpSegConsultaUserResult spSegConsultaUsr(BigDecimal i_user_id)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ROL_USR" database
	 * procedure.
	 */
	public SpSegEliminarTesoUserResult spSegEliminarTesoUsr(BigDecimal iAppId,
			BigDecimal iUserId, BigDecimal iTesoId)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INFO_FUNCIONARIO" database
	 * procedure.
	 */
	public SpSegInfoFuncionarioResult spSegInfoFuncionario(BigDecimal iRut,
			String iDv) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ACT" database
	 * procedure.
	 */
	public SpSegInsertarActResult spSegInsertarAct(String iActRuta,
			BigDecimal iIdPage, String iActNombre, String iActVisible)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_APP" database
	 * procedure.
	 */
	public SpSegInsertarAppResult spSegInsertarApp(String iNombreApp)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_GRA" database
	 * procedure.
	 */
	public SpSegInsertarGraResult spSegInsertarGra(String iNombreGrant)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ID" database
	 * procedure.
	 */
	public SpSegInsertarIdResult spSegInsertarId(BigDecimal iGrantId,
			BigDecimal iRol, BigDecimal iPagina, String iUrl,
			java.sql.Date iFechaInicio, java.sql.Date iFechaTermino)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_MOD" database
	 * procedure.
	 */
	public SpSegInsertarModResult spSegInsertarMod(BigDecimal iApp,
			String iNombreMod) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_PAG" database
	 * procedure.
	 */
	public SpSegInsertarPagResult spSegInsertarPag(String iNombrePag,
			BigDecimal iIdMod, BigDecimal iIdApp)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL" database
	 * procedure.
	 */
	public SpSegInsertarRolResult spSegInsertarRol(String iNombreRol,
			String iRolTipo, BigDecimal iRolJerarq, String iRolEstado,
			BigDecimal iAplId) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL_GRU" database
	 * procedure.
	 */
	public SpSegInsertarRolGruResult spSegInsertarRolGru(BigDecimal iGroupId,
			BigDecimal iRol, java.sql.Date iFechaInicio,
			java.sql.Date iFechaTermino, String iRolEstado)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_ROL_USR" database
	 * procedure.
	 */
	public SpSegInsertarRolUsrResult spSegInsertarRolUsr(BigDecimal iRol,
			BigDecimal iUserId, java.sql.Date iFechaInicio,
			java.sql.Date iFechaTermino, String iRolEstado)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_RUT_USER" database
	 * procedure.
	 */
	public SpSegInsertarRutUserResult spSegInsertarRutUser(BigDecimal iIdUser,
			BigDecimal iRut, String iDv) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_INSERTAR_TESO_USER" database
	 * procedure.
	 */
	public SpSegInsertarTesoUserResult spSegInsertarTesoUser(BigDecimal iAppId,
			BigDecimal iUserId, BigDecimal iTesoId)
			throws PkgSeguridadIntranetException;

	public SpSegListaRechazadosResult spSegListaRechazados(BigDecimal i_carga,
			String tipo) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ACT" database
	 * procedure.
	 */
	public SpSegModificarActResult spSegModificarAct(String iActRuta,
			BigDecimal iPage, String iActNombre, String iActVisible)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_APP" database
	 * procedure.
	 */
	public SpSegModificarAppResult spSegModificarApp(BigDecimal iApp,
			String iNombreApp) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_GRA" database
	 * procedure.
	 */
	public SpSegModificarGraResult spSegModificarGra(BigDecimal iGrant,
			String iNombreGrant, String iGrantEstado)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ID" database
	 * procedure.
	 */
	public SpSegModificarIdResult spSegModificarId(BigDecimal iGrantId,
			BigDecimal iRol, BigDecimal iPagina, BigDecimal iModulo,
			BigDecimal iApp, String iUrl, java.sql.Date iFechaInicio,
			java.sql.Date iFechaTermino) throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_MOD" database
	 * procedure.
	 */
	public SpSegModificarModResult spSegModificarMod(BigDecimal iMod,
			BigDecimal iApp, String iNombreMod)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_PAG" database
	 * procedure.
	 */
	public SpSegModificarPagResult spSegModificarPag(BigDecimal iPage,
			String iNombrePag, BigDecimal iIdMod, BigDecimal iIdApp)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ROL" database
	 * procedure.
	 */
	public SpSegModificarRolResult spSegModificarRol(BigDecimal iRol,
			String iNombreRol, String iRolTipo, BigDecimal iRolJerarq,
			String iRolEstado, BigDecimal iAplId)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ROL_GRU" database
	 * procedure.
	 */
	public SpSegModificarRolGruResult spSegModificarRolGru(BigDecimal iGroupId,
			BigDecimal iRol, java.sql.Date iFechaInicio,
			java.sql.Date iFechaTermino, String iRolEstado)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ROL_USR" database
	 * procedure.
	 */
	public SpSegModificarRolUsrResult spSegModificarRolUsr(BigDecimal iRol,
			BigDecimal iUserId, java.sql.Date iFechaInicio,
			java.sql.Date iFechaTermino, String iRolEstado)
			throws PkgSeguridadIntranetException;

	/**
	 * Executes the "PKG_SEGURIDAD_INTRANET.SP_SEG_MODIFICAR_ROL_USR" database
	 * procedure.
	 */
	public SpSegModificarTesoUserResult spSegModificarTesoUsr(
			BigDecimal iAppId, BigDecimal iUserId, BigDecimal iTesoId)
			throws PkgSeguridadIntranetException;

	public SpSeqCargaResult spSeqCarga(String inStr)
			throws PkgSeguridadIntranetException;

}
