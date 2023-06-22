import javax.swing.*; //Importa todas las clases y subpaquetes del paquete javax.swing, que proporciona componentes y utilidades para crear interfaces gráficas.
import java.awt.*; //contiene las clases fundamentales para la creación y manipulación de gráficos y componentes de interfaz de usuario.
import java.awt.event.ActionEvent; //se utilizan para manejar eventos de acciones, como clics de botón u otras interacciones con componentes de la interfaz gráfica.
import java.awt.event.ActionListener; //se utilizan para manejar eventos de acciones, como clics de botón u otras interacciones con componentes de la interfaz gráfica.

public class VentanaRegistro extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCedula;

    public VentanaRegistro() {
        super("Registro de Usuario");

        // Crear componentes
        JLabel lblUsuario = createLabel("Usuario:"); // Crear una etiqueta "Usuario"
        txtUsuario = createTextField(10); // Crear un campo de texto para el usuario
        JLabel lblContraseña = createLabel("Contraseña:"); // Crear una etiqueta "Contraseña"
        txtContraseña = createPasswordField(10); // Crear un campo de contraseña
        JLabel lblCorreo = createLabel("Correo:"); // Crear una etiqueta "Correo"
        txtCorreo = createTextField(10); // Crear un campo de texto para el correo
        JLabel lblTelefono = createLabel("Teléfono:"); // Crear una etiqueta "Teléfono"
        txtTelefono = createTextField(10); // Crear un campo de texto para el teléfono
        JLabel lblDireccion = createLabel("Dirección:"); // Crear una etiqueta "Dirección"
        txtDireccion = createTextField(10); // Crear un campo de texto para la dirección
        JLabel lblNombre = createLabel("Nombre:"); // Crear una etiqueta "Nombre"
        txtNombre = createTextField(10); // Crear un campo de texto para el nombre
        JLabel lblApellido = createLabel("Apellido:"); // Crear una etiqueta "Apellido"
        txtApellido = createTextField(10); // Crear un campo de texto para el apellido
        JLabel lblCedula = createLabel("Cédula:"); // Crear una etiqueta "Cédula"
        txtCedula = createTextField(10); // Crear un campo de texto para la cédula
        JButton btnRegistrar = createButton("Registrar"); // Crear un botón "Registrar"

        // Configurar panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(9, 2, 10, 10)); // Configurar el diseño del panel como una cuadrícula de 9 filas y 2 columnas con espacios de 10 píxeles
        panelPrincipal.setBackground(new Color(52, 73, 94)); // Establecer el color de fondo del panel
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Establecer un borde vacío alrededor del panel
        panelPrincipal.add(lblUsuario); // Agregar la etiqueta "Usuario" al panel
        panelPrincipal.add(txtUsuario); // Agregar el campo de texto del usuario al panel
        panelPrincipal.add(lblContraseña); // Agregar la etiqueta "Contraseña" al panel
        panelPrincipal.add(txtContraseña); // Agregar el campo de contraseña al panel
        panelPrincipal.add(lblCorreo); // Agregar la etiqueta "Correo" al panel
        panelPrincipal.add(txtCorreo); // Agregar el campo de texto del correo al panel
        panelPrincipal.add(lblTelefono); // Agregar la etiqueta "Teléfono" al panel
        panelPrincipal.add(txtTelefono); // Agregar el campo de texto del teléfono al panel
        panelPrincipal.add(lblDireccion); // Agregar la etiqueta "Dirección" al panel
        panelPrincipal.add(txtDireccion); // Agregar el campo de texto de la dirección al panel
        panelPrincipal.add(lblNombre); // Agregar la etiqueta "Nombre" al panel
        panelPrincipal.add(txtNombre); // Agregar el campo de texto del nombre al panel
        panelPrincipal.add(lblApellido); // Agregar la etiqueta "Apellido" al panel
        panelPrincipal.add(txtApellido); // Agregar el campo de texto del apellido al panel
        panelPrincipal.add(lblCedula); // Agregar la etiqueta "Cédula" al panel
        panelPrincipal.add(txtCedula); // Agregar el campo de texto de la cédula al panel
        panelPrincipal.add(btnRegistrar); // Agregar el botón "Registrar" al panel

        // Agregar panel principal al marco
        getContentPane().setBackground(new Color(236, 240, 241)); // Establecer el color de fondo del marco
        getContentPane().add(panelPrincipal); // Agregar el panel principal al contenido del marco

        // Configurar comportamiento del botón "Registrar"
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText(); // Obtener el texto del campo de texto del usuario
                String contraseña = new String(txtContraseña.getPassword()); // Obtener el texto del campo de contraseña
                String correo = txtCorreo.getText(); // Obtener el texto del campo de texto del correo
                String telefono = txtTelefono.getText(); // Obtener el texto del campo de texto del teléfono
                String direccion = txtDireccion.getText(); // Obtener el texto del campo de texto de la dirección
                String nombre = txtNombre.getText(); // Obtener el texto del campo de texto del nombre
                String apellido = txtApellido.getText(); // Obtener el texto del campo de texto del apellido
                String cedula = txtCedula.getText(); // Obtener el texto del campo de texto de la cédula

                if (usuario.isEmpty() || contraseña.isEmpty() || correo.isEmpty() ||
                        telefono.isEmpty() || direccion.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaRegistro.this,
                            "Por favor complete todos los campos",
                            "Campos incompletos", JOptionPane.WARNING_MESSAGE); // Mostrar un mensaje de advertencia si algún campo está vacío
                } else {
                    boolean registrado = BaseDatosUsuarios.registrarUsuario(usuario, contraseña,
                            correo, telefono, direccion, nombre, apellido, cedula); // Registrar el usuario en la base de datos

                    if (registrado) {
                        JOptionPane.showMessageDialog(VentanaRegistro.this,
                                "Registro exitoso. Inicie sesión con sus credenciales.",
                                "Registro exitoso", JOptionPane.INFORMATION_MESSAGE); // Mostrar un mensaje de éxito si el registro fue exitoso
                        abrirVentanaInicioSesion(); // Abrir la ventana de inicio de sesión
                        limpiarCampos(); // Limpiar los campos de texto
                    } else {
                        JOptionPane.showMessageDialog(VentanaRegistro.this,
                                "El usuario ya existe. Intente con otro nombre de usuario.",
                                "Registro fallido", JOptionPane.ERROR_MESSAGE); // Mostrar un mensaje de error si el registro falló
                    }
                }
            }
        });

        // Configurar propiedades del marco
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecer la operación de cierre al hacer clic en la "X"
        setSize(500, 450); // Establecer el tamaño del marco
        setLocationRelativeTo(null); // Centrar el marco en la pantalla
        setVisible(true); // Hacer visible el marco
    }

    // Métodos auxiliares para crear componentes con estilos predefinidos
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text); // Crear una etiqueta con el texto especificado
        label.setFont(new Font("Arial", Font.BOLD, 14)); // Establecer la fuente de la etiqueta
        label.setForeground(new Color(52, 152, 219)); // Establecer el color del texto de la etiqueta
        return label;
    }

    private JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns); // Crear un campo de texto con el número de columnas especificado
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); // Establecer la fuente del campo de texto
        textField.setForeground(new Color(44, 62, 80)); // Establecer el color del texto del campo de texto
        return textField;
    }

    private JPasswordField createPasswordField(int columns) {
        JPasswordField passwordField = new JPasswordField(columns); // Crear un campo de contraseña con el número de columnas especificado
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14)); // Establecer la fuente del campo de contraseña
        passwordField.setForeground(new Color(44, 62, 80)); // Establecer el color del texto del campo de contraseña
        return passwordField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text); // Crear un botón con el texto especificado
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Establecer la fuente del botón
        button.setBackground(new Color(52, 152, 219)); // Establecer el color de fondo del botón
        button.setForeground(Color.white); // Establecer el color del texto del botón
        button.setFocusPainted(false); // Desactivar el resaltado al obtener el foco
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Establecer un borde vacío alrededor del botón
        return button;
    }

    private void abrirVentanaInicioSesion() {
        VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion(); // Crear una instancia de la ventana de inicio de sesión
        setVisible(false); // Ocultar la ventana de registro
        dispose(); // Liberar los recursos asociados a la ventana de registro
    }

    private void limpiarCampos() {
        txtUsuario.setText(""); // Limpiar el campo de texto del usuario
        txtContraseña.setText(""); // Limpiar el campo de contraseña
        txtCorreo.setText(""); // Limpiar el campo de texto del correo
        txtTelefono.setText(""); // Limpiar el campo de texto del teléfono
        txtDireccion.setText(""); // Limpiar el campo de texto de la dirección
        txtNombre.setText(""); // Limpiar el campo de texto del nombre
        txtApellido.setText(""); // Limpiar el campo de texto del apellido
        txtCedula.setText(""); // Limpiar el campo de texto de la cédula
    }
}