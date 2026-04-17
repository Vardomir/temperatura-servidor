import com.jcraft.jsch.*;


public class SSHManager {
	
	private Session session; //Herramienta para crear una conexion con servidor SSH
	private String host;
	private String user;
	private String password;
	
	// La clase sshmanager recibe los parametros del servidor, el usuario y la contraseña
	public SSHManager (String host, String user, String password) {
		this.host = host;
		this.user = user;
		this.password = password;
		
	}
	
	//El objeto Session requiere este codigo para la conexion
	public void connectar() throws JSchException {
	
		JSch jsch = new JSch();
		session = jsch.getSession(user, host, 22);
		session.setPassword(password);
		
		//Para saltar la verificacion de huella digital (StrictHostKeyChecking)
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
      
        /**
         * Si no tiene la huella digital del servidor jsch no permite la conexion al no poder validar que es quien dice ser
         * de esta manera con java.util.Properties creamos un objeto configuracion clave-valor
         * con la instruccion especifica a StrictHostKeyChecking de que no debe hacer dicha validacion
         * y se la pasamos a la configuracion de session
         * **/
        
        session.connect();
        System.out.println("Conexion establecida");
	}
	
	
	
	

}
