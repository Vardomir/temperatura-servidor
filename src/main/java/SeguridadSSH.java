import com.jcraft.jsch.UserInfo;
import javax.swing.JOptionPane;

public class SeguridadSSH implements UserInfo {

	@Override
	public boolean promptYesNo(String message) {
		
		//JSch llama a esto si la clave es nueva o ha cambiado
		int resultado = JOptionPane.showConfirmDialog(null, message, "Servidor desconocido, ¿esta seguro de que es seguro?",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		//TODO no he guardado aun el known_hosts y si el usuario marca no lanza excepcion
		return resultado == JOptionPane.YES_OPTION;
	}
	
	@Override
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		//TODO inseguro de cuando sale este mensaje
	}
	
	// Métodos obligatorios de la interfaz que no usare porque ya le pase la contraseña directamente a la 'Session'
	@Override
	public String getPassphrase() {return null;	}

	@Override
	public String getPassword() {return null;}

	@Override
	public boolean promptPassword(String message) {return false;}

	@Override
	public boolean promptPassphrase(String message) {return false;}





}
