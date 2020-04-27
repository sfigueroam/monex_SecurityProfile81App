package cl.tesoreria.seguridad.perfil.ejb;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.RowSet;

import cl.tesoreria.seguridad.perfil.vo.AplTesoUserVO;
import cl.tesoreria.seguridad.perfil.vo.UserSecurityVO;
import cl.tesoreria.seguridad.perfil.vo.UserVO;
import cl.tesoreria.seguridad.profile.Users;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.PkgSeguridadIntranetException;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpAuditoriaFuncionarioResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegAplTesoUserResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegBuscarGraUrlResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegBuscarIdResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegBuscarInfoUserResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegBuscarRutUserResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegBuscarTesoUserResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegBuscarTesoreriasResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegBuscarUsrNombreResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegConsultaAplTesoUserResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegConsultaUserResult;
import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.PkgSeguridadIntranetEJB3Local;
/**
 * Session Bean implementation class SegFacadeIntranetEJB3
 */
@Stateless(mappedName = "cl.tesoreria.seguridad.perfil.ejb.SegFacadeIntranetEJB3")
public class SegFacadeIntranetEJB3 implements SegFacadeIntranetEJB3Remote, SegFacadeIntranetEJB3Local {

    /**
     * Default constructor. 
     */
    private @EJB  PkgSeguridadIntranetEJB3Local pkgSeguridadIntranetEJB3Local;
    
	public SegFacadeIntranetEJB3() {
        // TODO Auto-generated constructor stub
    }
    /*
    public PkgSeguridadIntranetLocal getPkgSeguridadIntranetEJB3() throws NamingException, CreateException, RemoteException
    {
        if (pkgSeguridadIntranetLocal == null)
        {
            Context ctx = new InitialContext();
            Object o = ctx.lookup("cl/tesoreria/seguridad/profile/ejb/pkgseguridadintranet/PkgSeguridadIntranetLocalHome");

            pkgSeguridadIntranetLocalHome = (PkgSeguridadIntranetLocalHome)PortableRemoteObject.narrow(o, PkgSeguridadIntranetLocalHome.class);
            pkgSeguridadIntranetLocal = pkgSeguridadIntranetLocalHome.create();
        }
        return pkgSeguridadIntranetLocal;
         
    }
    */
    
    @Override
    public String getPermisosUser(BigDecimal appId, String user) throws Exception
    {
        boolean sw = false;
        String strId=null;
        BigDecimal codError=null;
        try
        {  
            SpSegBuscarIdResult segBuscarId=pkgSeguridadIntranetEJB3Local.spSegBuscarId(appId,user);
            strId = segBuscarId.getOStrid();
            codError = segBuscarId.getOCodError();
            if (codError.equals(new BigDecimal(0)))
            {
                sw = true; 
            }   
        }
        catch (PkgSeguridadIntranetException e)
        {
            e.printStackTrace();
          /* Recuperar Excepcion */
            SQLException se = (SQLException)e.getCause();
            System.out.println("\nERROR_CODE = " +
                               se.getErrorCode() +
                               "\nMESSAGE=" +
                               se.getMessage() +
                               "\n");
            throw new Exception(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        if (sw)
        {
            return strId;
        }
        else
        {
            return null;   
        }   
     
    } 
  
  
    @Override
    public BigDecimal getPermisosUserUrl(String userName, String url) throws Exception
    {
        boolean sw = false;
        BigDecimal pageId=null;
        BigDecimal codError=null;
        try
        {  
            SpSegBuscarGraUrlResult segBuscarPageId=pkgSeguridadIntranetEJB3Local.spSegBuscarGraUrl(userName,url);
            pageId = segBuscarPageId.getOPageId();
            
            codError = segBuscarPageId.getOCodError();
            if (codError.equals(new BigDecimal(0)))
            {
                sw = true; 
            }   
        }
        catch (PkgSeguridadIntranetException e)
        {
            e.printStackTrace();
          /* Recuperar Excepcion */
            SQLException se = (SQLException)e.getCause();
            System.out.println("\nERROR_CODE = " +
                               se.getErrorCode() +
                               "\nMESSAGE=" +
                               se.getMessage() +
                               "\n");
            throw new Exception(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        if (sw)
        {
            return pageId;
        }
        else
        {
            return null;   
        }   
     
    } 
   
    
  
    @Override
    public ArrayList getTesoreriasUser(BigDecimal appId, String user)  throws Exception
    {
        ArrayList lista = null;
        SpSegBuscarTesoUserResult segBuscarTeso=null;
        RowSet rs=null;
        
        boolean sw = false;
        try
        {  
            segBuscarTeso = pkgSeguridadIntranetEJB3Local.spSegBuscarTesoUser(user,appId);
            if (segBuscarTeso.getOCodError().equals(new BigDecimal(0)))
            {
               
                if (segBuscarTeso.getRowSetCount() > 0)
                {
                    rs = segBuscarTeso.getRowSet(0);
                }
                lista = new ArrayList();
                while (rs.next())
                {
                    
                    String[] array = new String[]{rs.getBigDecimal(1).toString(),
                                                        rs.getString(2),
                                                        rs.getBigDecimal(3).toString(),
                                                        rs.getString(4),
                                                        rs.getString(5),
                                                        rs.getBigDecimal(6).toString(),
                                                        rs.getBigDecimal(7).toString(),
                                                        rs.getString(8),
                                                        rs.getBigDecimal(9).toString(),
                                                        rs.getString(10)};
                  
                    lista.add(array);
                }   
                        
                  
                sw = true; 
            }   
        
        }
        catch (PkgSeguridadIntranetException e)
        {
            e.printStackTrace();
          /* Recuperar Excepcion */
            SQLException se = (SQLException)e.getCause();
            System.out.println("\nERROR_CODE = " +
                               se.getErrorCode() +
                               "\nMESSAGE=" +
                               se.getMessage() +
                               "\n");
            throw new Exception(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        if (sw)
        {
            return lista;
        }
        else
        {
            return null;   
        }   
     
    } 
    
    
    @Override
    public ArrayList getTesorerias() throws Exception
    {
        ArrayList lisTesorerias = null;
        SpSegBuscarTesoreriasResult segBusTesorerias=null;
        RowSet rs=null;
        
        boolean sw = false;
        try
        {  
            segBusTesorerias = pkgSeguridadIntranetEJB3Local.spSegBuscarTesorerias();
            if (segBusTesorerias.getOCodError().equals(new BigDecimal(0)))
            {
               
                if (segBusTesorerias.getRowSetCount() > 0)
                {
                    rs = segBusTesorerias.getRowSet(0);
                }
                lisTesorerias = new ArrayList();
                while (rs.next())
                {
                    
                    String[] array = new String[]{(rs.getBigDecimal(1) != null ? rs.getBigDecimal(1).toString() : ""),
                                                        rs.getString(2),
                                                        (rs.getBigDecimal(3) != null ? rs.getBigDecimal(3).toString() : ""),
                                                        rs.getString(4),
                                                        rs.getString(5),
                                                        (rs.getBigDecimal(6) != null ? rs.getBigDecimal(6).toString() : ""),
                                                        (rs.getBigDecimal(7) != null ? rs.getBigDecimal(7).toString() : ""),
                                                        rs.getString(8)};
                  
                    lisTesorerias.add(array);
                }   
                        
                  
                sw = true; 
            }   
        
        }
        catch (PkgSeguridadIntranetException e)
        {
            e.printStackTrace();
          /* Recuperar Excepcion */
            SQLException se = (SQLException)e.getCause();
            System.out.println("\nERROR_CODE = " +
                               se.getErrorCode() +
                               "\nMESSAGE=" +
                               se.getMessage() +
                               "\n");
            throw new Exception(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        if (sw)
        {
            return lisTesorerias;
        }else {
            return null;   
        }   
     
    } 
    
    
    @Override
    public Users getInfoUser(String rut) throws Exception
    {
        SpSegBuscarInfoUserResult segBusInfoUser=null;
        RowSet rs=null;
        
        boolean sw = false;
        String[] rutValue=null;
        Users usersDoc= new cl.tesoreria.seguridad.profile.ObjectFactory().createUsers();
        //UsersDocument usersDoc=UsersDocument.Factory.newInstance();
        //UsersDocument.Users users=usersDoc.addNewUsers();  
        //UsersDocument.Users.User user=null;
        
        //List<Users.User> listaUser = usersDoc.getUser();
        List<Users.User> listaUser = new ArrayList<Users.User>();
        try
        {  
            segBusInfoUser = pkgSeguridadIntranetEJB3Local.spSegBuscarInfoUser(rut);
            if (segBusInfoUser.getOCodError().equals(new BigDecimal(0)))
            {
               
                if (segBusInfoUser.getRowSetCount() > 0)
                {
                    rs = segBusInfoUser.getRowSet(0);
                }
                while (rs.next())
                {
                    
                    //user = users.addNewUser();
                	Users.User user = new cl.tesoreria.seguridad.profile.ObjectFactory().createUsersUser();
                    user.setNombres(rs.getString("NOMBRES"));
                    rutValue = rs.getString("RUT").split("-");
                    user.setRut(new BigDecimal(rutValue[0]));
                    user.setDv(rutValue[1]);
                    user.setApePaterno(rs.getString("APPATERNO"));
                    user.setApeMaterno(rs.getString("APMATERNO"));
                    user.setTesoreria(rs.getString("TESORERIA"));
                    user.setCodUbicacion(rs.getBigDecimal("COD_UBIC"));
                    user.setDepto(rs.getString("DEPARTAMENTO"));
                    user.setSeccion(rs.getString("SECCION"));
                    user.setCargo(rs.getString("CARGO"));
                    user.setFuncion(rs.getString("FUNCION"));
                    user.setAnexo(rs.getString("ANEXO"));
                    user.setEstado(rs.getString("APPATERNO"));
                    user.setEmail(rs.getString("EMAIL"));
                    
                    listaUser.add(user);
                }   
                        
                usersDoc.setUser(listaUser);  
                sw = true; 
            }   
        
        }
        catch (PkgSeguridadIntranetException e)
        {
            e.printStackTrace();
          /* Recuperar Excepcion */
            SQLException se = (SQLException)e.getCause();
            System.out.println("\nERROR_CODE = " +
                               se.getErrorCode() +
                               "\nMESSAGE=" +
                               se.getMessage() +
                               "\n");
            throw new Exception(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        if (sw)
        {
            return usersDoc;
        }
        else
        {
            return null;   
        }   
     
    } 
    
    
    @Override
    public Users getRutUser(BigDecimal rutUser) throws Exception
    {
        boolean sw = false;
        String strId=null;
        BigDecimal codError=null;
        RowSet rs=null;
        Users usersDoc= new cl.tesoreria.seguridad.profile.ObjectFactory().createUsers();
        //UsersDocument.Users users=usersDoc.addNewUsers();  
        //UsersDocument.Users.User user=null;
        
        //List<Users.User> listaUser = usersDoc.getUser();
        List<Users.User> listaUser = new ArrayList<Users.User>();
        try
        {  
            SpSegBuscarRutUserResult segBusRutUser=pkgSeguridadIntranetEJB3Local.spSegBuscarRutUser(rutUser);
            codError = segBusRutUser.getOCodError();
            if (codError.equals(new BigDecimal(0)))
            {
                if (segBusRutUser.getRowSetCount() > 0)
                {
                    rs = segBusRutUser.getRowSet(0);
                }
                while (rs.next())
                {
                    //user = users.addNewUser();
                	Users.User user = new cl.tesoreria.seguridad.profile.ObjectFactory().createUsersUser();
                	user.setRut(rs.getBigDecimal("USER_RUT"));
                    user.setDv(rs.getString("USER_DV"));
                    user.setUserId(rs.getBigDecimal("USER_ID"));
                    listaUser.add(user);
                } 
                sw = true;    
                //Llenar Lista de Usuarios
                usersDoc.setUser(listaUser);
            }   
        }
        catch (PkgSeguridadIntranetException e)
        {
            e.printStackTrace();
          /* Recuperar Excepcion */
            SQLException se = (SQLException)e.getCause();
            System.out.println("\nERROR_CODE = " +
                               se.getErrorCode() +
                               "\nMESSAGE=" +
                               se.getMessage() +
                               "\n");
            throw new Exception(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        if (sw)
        {
            return usersDoc;
        }
        else
        {
            return null;   
        }   
     
    } 
                    
    
    @Override
    public Users getUserName(String userName) throws Exception
    {
        boolean sw = false;
        String strId=null;
        BigDecimal codError=null;
        RowSet rs=null;
        Users usersDoc= new cl.tesoreria.seguridad.profile.ObjectFactory().createUsers();
        //UsersDocument usersDoc=UsersDocument.Factory.newInstance();
        //UsersDocument.Users users=usersDoc.addNewUsers();  
        //UsersDocument.Users.User user=null;
        
        //List<Users.User> listaUser = usersDoc.getUser();
        List<Users.User> listaUser = new ArrayList<Users.User>();
        try
        {  
            SpSegBuscarUsrNombreResult segBusUserName= pkgSeguridadIntranetEJB3Local.spSegBuscarUsrNombre(userName);
            codError = segBusUserName.getOCodError();
            if (codError.equals(new BigDecimal(0)))
            {
                if (segBusUserName.getRowSetCount() > 0)
                {
                    rs = segBusUserName.getRowSet(0);
                }
                while (rs.next())
                {
                    //user = users.addNewUser();
                	Users.User user = new cl.tesoreria.seguridad.profile.ObjectFactory().createUsersUser();
                    user.setUserId(rs.getBigDecimal("USER_ID"));
                    user.setUserName(rs.getString("USER_NAME"));
                 /*user.setFechaCreacion(rs.getDate("CREATION_DATE"));
                 user.setFechaMod(rs.getDate("MODIFIED_DATE"));*/
                    listaUser.add(user);
                }   
                
                usersDoc.setUser(listaUser);
                sw = true; 
            }   
        }
        catch (PkgSeguridadIntranetException e)
        {
            e.printStackTrace();
          /* Recuperar Excepcion */
            SQLException se = (SQLException)e.getCause();
            System.out.println("\nERROR_CODE = " +
                               se.getErrorCode() +
                               "\nMESSAGE=" +
                               se.getMessage() +
                               "\n");
            throw new Exception(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        if (sw)
        {
            return usersDoc;
        }
        else
        {
            return null;   
        }   
     
    } 
   
   
    @Override
    public UserVO getAuditoriaFuncionario(String userName) throws Exception
    {
        boolean sw = false;
        String strId=null;
        BigDecimal codError=null;
        RowSet rs=null;
        UserVO userVO=new UserVO();
      /*UsersDocument usersDoc=UsersDocument.Factory.newInstance();
      UsersDocument.Users users=usersDoc.addNewUsers();  
      UsersDocument.Users.User user=null;*/
        try
        {  
            SpAuditoriaFuncionarioResult segBusUserName= pkgSeguridadIntranetEJB3Local.spAuditoriaFuncionario(userName);
            codError = segBusUserName.getOCodError();
            if (codError.equals(new BigDecimal(0)))
            {
                if (segBusUserName.getRowSetCount() > 0)
                {
                    rs = segBusUserName.getRowSet(0);
                }
                while (rs.next())
                {
                 //user=users.addNewUser();
                    userVO.setUserId(rs.getBigDecimal("USER_ID"));
                    userVO.setDv(rs.getString("USER_DV"));
                    userVO.setRut(rs.getBigDecimal("USER_RUT"));
                    userVO.setRutTesoreria(rs.getBigDecimal("TESO_RUT"));
                    userVO.setDvTesoreria(rs.getString("TESO_DV"));
                    userVO.setCodUbicacion(rs.getBigDecimal("COD_UBIC"));
                    userVO.setApePaterno(rs.getString("APELLIDO_PATERNO"));
                    userVO.setApeMaterno(rs.getString("APELLIDO_MATERNO"));
                    userVO.setNombres(rs.getString("NOMBRES"));
                    userVO.setEmail(rs.getString("EMAIL"));
                 /*user.setFechaCreacion(rs.getDate("CREATION_DATE"));
                 user.setFechaMod(rs.getDate("MODIFIED_DATE"));*/
                }     
                sw = true; 
            }   
        }
        catch (PkgSeguridadIntranetException e)
        {
            e.printStackTrace();
          /* Recuperar Excepcion */
            SQLException se = (SQLException)e.getCause();
            System.out.println("\nERROR_CODE = " +
                               se.getErrorCode() +
                               "\nMESSAGE=" +
                               se.getMessage() +
                               "\n");
            throw new Exception(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        if (sw)
        {
            return userVO;
        }
        else
        {
            return null;   
        }   
         
         
    }
     
    
    @Override
    public AplTesoUserVO getConsultaAplTesoUser(BigDecimal idUser, BigDecimal idApl, BigDecimal idTeso) throws Exception
    {
        boolean sw = false;
        String strId=null;
        BigDecimal codError=null;
        RowSet rs=null;
        AplTesoUserVO aplTesoUserVo=new AplTesoUserVO();
        try
        {
            
            SpSegConsultaAplTesoUserResult consAplTesoUsrRs= pkgSeguridadIntranetEJB3Local.spSegConsultaAplTesoUsr(idUser,idApl,idTeso);
            codError = consAplTesoUsrRs.getOCodError();
            if (codError.equals(new BigDecimal(0)))
            {
                if (consAplTesoUsrRs.getRowSetCount() > 0)
                {
                    rs = consAplTesoUsrRs.getRowSet(0);
                }
                while (rs.next())
                {
                 //user=users.addNewUser();
                    aplTesoUserVo.setUserId(rs.getBigDecimal(1));
                    aplTesoUserVo.setUserName(rs.getString(2));
                    aplTesoUserVo.setAplId(rs.getBigDecimal(3));
                    aplTesoUserVo.setAplDesc(rs.getString(4));
                    aplTesoUserVo.setUserId(rs.getBigDecimal(5));
                    aplTesoUserVo.setTesoDesc(rs.getString(6));           
                 /*user.setFechaCreacion(rs.getDate("CREATION_DATE"));
                 user.setFechaMod(rs.getDate("MODIFIED_DATE"));*/
                }     
                sw = true; 
            }   
        
        
        }
        catch (PkgSeguridadIntranetException e)
        {
            e.printStackTrace();
          /* Recuperar Excepcion */
            SQLException se = (SQLException)e.getCause();
            System.out.println("\nERROR_CODE = " +
                               se.getErrorCode() +
                               "\nMESSAGE=" +
                               se.getMessage() +
                               "\n");
            throw new Exception(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception(e);
        }
        if (sw)
        {
            return aplTesoUserVo;
        }
        else
        {
            return null;   
        }   
         
    }
    
    @Override
    public ArrayList getTesoreiasAplUser(BigDecimal idUser) throws Exception
    {
        ArrayList arrTesoreriasAplUser = new ArrayList();
        SpSegAplTesoUserResult segAplTesoUser=null;
        BigDecimal codError=null;
        RowSet rs=null;
        
        boolean sw = false;
        
        
        try
        {
            
            SpSegAplTesoUserResult spSegAplTesoUser= pkgSeguridadIntranetEJB3Local.spSegAplTesoUsr(idUser);
            codError = spSegAplTesoUser.getOCodError();
            if (codError.equals(new BigDecimal(0)))
            {
                if (spSegAplTesoUser.getRowSetCount() > 0)
                {
                    rs = spSegAplTesoUser.getRowSet(0);
                }
                while (rs.next())
                {
                 //user=users.addNewUser();
                    AplTesoUserVO aplTesoUserVo=new AplTesoUserVO();
                    aplTesoUserVo.setUserId(rs.getBigDecimal(1));
                    aplTesoUserVo.setUserName(rs.getString(2));
                    aplTesoUserVo.setAplId(rs.getBigDecimal(3));
                    aplTesoUserVo.setAplDesc(rs.getString(4));
                    aplTesoUserVo.setTesoId(rs.getBigDecimal(5));
                    aplTesoUserVo.setTesoDesc(rs.getString(6));   
                    
                    arrTesoreriasAplUser.add(aplTesoUserVo);        
                 /*user.setFechaCreacion(rs.getDate("CREATION_DATE"));
                 user.setFechaMod(rs.getDate("MODIFIED_DATE"));*/
                }     
                sw = true; 
            }   
        
        
        }
        catch (PkgSeguridadIntranetException e){
          e.printStackTrace();
          /* Recuperar Excepcion */
          SQLException se = (SQLException) e.getCause();
          System.out.println("\nERROR_CODE = "+se.getErrorCode()+"\nMESSAGE="+se.getMessage()+"\n");
          throw new Exception(e.getMessage());
      }catch(Exception e){
          e.printStackTrace();
          throw new Exception(e);
      }
      if (sw)
        {
            return arrTesoreriasAplUser;
        }else
        {
            return null;   
        }   
      
          
    }
    
    @Override
    public UserSecurityVO getConsultaUser(BigDecimal idUser) throws Exception
    {
        boolean sw = false;
        String strId=null;
        BigDecimal codError=null;
        RowSet rs=null;
        UserSecurityVO userVo=new  UserSecurityVO();
        try
        {
       
        SpSegConsultaUserResult consUsrRs= pkgSeguridadIntranetEJB3Local.spSegConsultaUsr(idUser);
       
        codError=consUsrRs.getOCodError();
       
          if (codError.equals(new BigDecimal(0)))
          {
       
             if(consUsrRs.getRowSetCount() > 0)
             {
                 rs = consUsrRs.getRowSet(0);
             }
       
             while (rs.next())
             {
       
                 //user=users.addNewUser();
                 userVo.setUserId(rs.getBigDecimal(1));
       
                 userVo.setUserName(rs.getString(2));
       
               //  userVo.setCreationDate(rs.getDate(3));
               //  userVo.setModifiedDate(rs.getDate(4));
                          
                 /*user.setFechaCreacion(rs.getDate("CREATION_DATE"));
                 user.setFechaMod(rs.getDate("MODIFIED_DATE"));*/
             }     
             sw = true; 
          }   
        
        
        }catch(PkgSeguridadIntranetException e){
          e.printStackTrace();
          /* Recuperar Excepcion */
          SQLException se = (SQLException) e.getCause();
          System.out.println("\nERROR_CODE = "+se.getErrorCode()+"\nMESSAGE="+se.getMessage()+"\n");
          throw new Exception(e.getMessage());
      }catch(Exception e){
          e.printStackTrace();
          throw new Exception(e);
      }
      if (sw)
        {
            return userVo;
        }else
        {
            return null;   
        }   
        
   }
   

   @Override
   public String testSaludar(String strMiguelCorona) throws Exception
   {
      return("Hola " + strMiguelCorona + " !! (04-ene-2013 13:50)" );
   }

}
