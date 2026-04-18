import com.jcraft.jsch.*;
import java.io.File;


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
		
		/*
		 * Ruta de archivo known_hosts
		 * */
		String sshDir = System.getProperty("user.home") + File.separator + ".ssh";
		new File(sshDir).mkdir(); //Carpeta oculta si no existe
		jsch.setKnownHosts(sshDir+ File.separator + "known_hosts");
		
		
		session = jsch.getSession(user, host, 22);
		session.setPassword(password);
		
		// Clase de seguridad personalizada
		session.setUserInfo(new SeguridadSSH());
			
		//Timeout de 10 segundos
		session.connect(10000);
		System.out.print("Conexión segura establecida con " + host);
		
		HostKeyRepository hkr = jsch.getHostKeyRepository();
		if (hkr instanceof KnownHosts) {
	        // Esto escribe físicamente las nuevas claves en el archivo known_hosts
	        ((KnownHosts) hkr).sync(); 
	        System.out.println("Archivo known_hosts actualizado en disco.");
	}
	
	public void Desconectar() {
		//Si session no es nulo y esta coenctado
		if session != null && session.isConnected(){
			session.disconnect();
			System.out.println("Desconectado del Servidor");
		}
	}
	
	
	
	

}
