import com.jcraft.jsch.*;


public class SSHManager {
	
	private Session session; //Herramienta para crear una conexion con servidor SSH
	private String host;
	private String user;
	private String password;
	
	public SSHManager (String host, String user, String password) {
		this.host = host;
		this.user = user;
		this.password = password;
		
	}
	
	
	
	

}
