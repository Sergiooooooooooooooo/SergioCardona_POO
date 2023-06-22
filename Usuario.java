public class Usuario {
    // Variables de instancia
    private String usuario;
    private String contraseña;
    private String correo;
    private String telefono;
    private String direccion;
    private String nombre;
    private String apellido;
    private double saldo;
    private String cedula;

    // Constructor de la clase Usuario
    public Usuario(String usuario, String contraseña, String correo, String telefono,
                   String direccion, String nombre, String apellido, String cedula) {
        // Inicializar las variables de instancia con los valores proporcionados
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = 0.0;
        this.cedula = cedula;
    }

    // Getters y setters

    // Método getter para obtener el valor de "usuario"
    public String getUsuario() {
        return usuario;
    }

    // Método getter para obtener el valor de "contraseña"
    public String getContraseña() {
        return contraseña;
    }

    // Método getter para obtener el valor de "correo"
    public String getCorreo() {
        return correo;
    }

    // Método getter para obtener el valor de "telefono"
    public String getTelefono() {
        return telefono;
    }

    // Método getter para obtener el valor de "direccion"
    public String getDireccion() {
        return direccion;
    }

    // Método getter para obtener el valor de "nombre"
    public String getNombre() {
        return nombre;
    }

    // Método getter para obtener el valor de "apellido"
    public String getApellido() {
        return apellido;
    }

    // Método getter para obtener el valor de "saldo"
    public double getSaldo() {
        return saldo;
    }

    // Método setter para asignar un valor a "saldo"
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método getter para obtener el valor de "cedula"
    public String getCedula() {
        return cedula;
    }
}