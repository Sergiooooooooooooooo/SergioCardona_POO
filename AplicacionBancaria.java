public class AplicacionBancaria {
    public static void main(String[] args) {
        // Crear algunos usuarios de ejemplo
        Usuario usuario1 = new Usuario("user1", "password1", "user1@example.com", "1234567890", "Dirección 1", "Nombre 1", "Apellido 1", "1111111111");
        Usuario usuario2 = new Usuario("user2", "password2", "user2@example.com", "0987654321", "Dirección 2", "Nombre 2", "Apellido 2", "2222222222");

        // Extraer los valores individuales de cada usuario
        String usuario1Nombre = usuario1.getUsuario();
        String usuario1Contraseña = usuario1.getContraseña();
        String usuario1Correo = usuario1.getCorreo();
        String usuario1Telefono = usuario1.getTelefono();
        String usuario1Direccion = usuario1.getDireccion();
        String usuario1NombreCompleto = usuario1.getNombre() + " " + usuario1.getApellido();
        String usuario1Cedula = usuario1.getCedula();

        String usuario2Nombre = usuario2.getUsuario();
        String usuario2Contraseña = usuario2.getContraseña();
        String usuario2Correo = usuario2.getCorreo();
        String usuario2Telefono = usuario2.getTelefono();
        String usuario2Direccion = usuario2.getDireccion();
        String usuario2NombreCompleto = usuario2.getNombre() + " " + usuario2.getApellido();
        String usuario2Cedula = usuario2.getCedula();

        // Agregar usuarios a la base de datos
        BaseDatosUsuarios.registrarUsuario(usuario1Nombre, usuario1Contraseña, usuario1Correo,
                usuario1Telefono, usuario1Direccion, usuario1.getNombre(), usuario1.getApellido(), usuario1Cedula);

        BaseDatosUsuarios.registrarUsuario(usuario2Nombre, usuario2Contraseña, usuario2Correo,
                usuario2Telefono, usuario2Direccion, usuario2.getNombre(), usuario2.getApellido(), usuario2Cedula);

        // Iniciar la ventana de inicio de sesión
        VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
    }
}

