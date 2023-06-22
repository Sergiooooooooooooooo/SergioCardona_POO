import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDatosUsuarios {
    // Lista estática para almacenar los usuarios
    private static List<Usuario> usuarios = new ArrayList<>();

    // Método para autenticar un usuario en la base de datos
    public static boolean autenticarUsuario(String usuario, String contraseña) {
        // Iterar sobre la lista de usuarios
        for (Usuario u : usuarios) {
            // Verificar si las credenciales coinciden con algún usuario en la lista
            if (u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                return true; // Autenticación exitosa
            }
        }
        return false; // Autenticación fallida
    }

    // Método para registrar un nuevo usuario en la base de datos
    public static boolean registrarUsuario(String usuario, String contraseña, String correo,
                                           String telefono, String direccion, String nombre, String apellido, String cedula) {
        // Verificar si el usuario ya existe en la base de datos
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                return false; // El usuario ya existe
            }
        }

        // Crear un nuevo objeto Usuario y agregarlo a la lista de usuarios
        Usuario nuevoUsuario = new Usuario(usuario, contraseña, correo, telefono, direccion, nombre, apellido, cedula);
        usuarios.add(nuevoUsuario);
        return true; // Registro exitoso
    }

    // Método para obtener un usuario de la base de datos
    public static Usuario obtenerUsuario(String usuario) {
        // Buscar el usuario por su nombre de usuario
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                return u; // Devolver el usuario encontrado
            }
        }
        return null; // Usuario no encontrado
    }
}