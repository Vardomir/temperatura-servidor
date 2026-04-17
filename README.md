#Dependencias
- Utilizo com.github.mwiede para conexiones SFTP/SSH en este caso JSch
- Utilizo org.openjfx para crear interfaces gráficas de usuario

#SSH Manager
- Utilizo Session del paquete JSch para crear el tunel documentandome con https://epaul.github.io/jsch-documentation/javadoc/
- Creo el objeto SSHManager que va a recibir los parametros de usuario, password y host 
- Utilizo la clase SeguridadSHH para preguntar si estamos seguros de que el servidor es seguro