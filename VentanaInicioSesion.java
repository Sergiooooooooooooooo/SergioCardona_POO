import javax.swing.*; //Importa todas las clases y subpaquetes del paquete javax.swing, que proporciona componentes y utilidades para crear interfaces gráficas.
import java.awt.*; //contiene las clases fundamentales para la creación y manipulación de gráficos y componentes de interfaz de usuario.
import java.awt.event.ActionEvent; //se utilizan para manejar eventos de acciones, como clics de botón u otras interacciones con componentes de la interfaz gráfica.
import java.awt.event.ActionListener; //se utilizan para manejar eventos de acciones, como clics de botón u otras interacciones con componentes de la interfaz gráfica.

public class VentanaInicioSesion extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;

    public VentanaInicioSesion() {
        super("Inicio de Sesión");

        // Crear componentes
        JLabel lblTitulo = createCenteredLabel("Nos alegra verte de nuevo :)"); // Etiqueta para el título centrado
        JLabel lblUsuario = createLabel("Usuario:"); // Etiqueta para el campo de usuario
        txtUsuario = createTextField(10); // Campo de texto para el usuario
        JLabel lblContraseña = createLabel("Contraseña:"); // Etiqueta para el campo de contraseña
        txtContraseña = createPasswordField(10); // Campo de contraseña
        JButton btnIniciarSesion = createButton("Iniciar Sesión"); // Botón para iniciar sesión
        JButton btnRegistrarse = createButton("Registrarse"); // Botón para registrarse

        // Configurar panel principal
        JPanel panelPrincipal = new JPanel(); // Panel principal
        panelPrincipal.setLayout(new GridLayout(4, 2, 10, 10)); // Diseño del panel (4 filas, 2 columnas)
        panelPrincipal.setBackground(new Color(52, 73, 94)); // Color de fondo del panel
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Borde del panel
        panelPrincipal.add(lblTitulo); // Agregar el título al panel
        panelPrincipal.add(new JLabel()); // Espacio en blanco
        panelPrincipal.add(lblUsuario); // Agregar la etiqueta de usuario al panel
        panelPrincipal.add(txtUsuario); // Agregar el campo de texto de usuario al panel
        panelPrincipal.add(lblContraseña); // Agregar la etiqueta de contraseña al panel
        panelPrincipal.add(txtContraseña); // Agregar el campo de contraseña al panel
        panelPrincipal.add(btnIniciarSesion); // Agregar el botón "Iniciar Sesión" al panel
        panelPrincipal.add(btnRegistrarse); // Agregar el botón "Registrarse" al panel

        // Agregar panel principal al marco
        getContentPane().setBackground(new Color(236, 240, 241)); // Color de fondo del marco
        getContentPane().add(panelPrincipal); // Agregar el panel principal al contenido del marco

        // Configurar comportamiento del botón "Iniciar Sesión"
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText(); // Obtener el texto del campo de usuario
                String contraseña = new String(txtContraseña.getPassword()); // Obtener el texto del campo de contraseña

                if (usuario.isEmpty() || contraseña.isEmpty()) {
                    // Mostrar un mensaje de advertencia si los campos están vacíos
                    JOptionPane.showMessageDialog(VentanaInicioSesion.this,
                            "Por favor ingrese el usuario y la contraseña",
                            "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean autenticado = BaseDatosUsuarios.autenticarUsuario(usuario, contraseña);

                    if (autenticado) {
                        // Abrir la ventana de cuenta si el usuario se autentica correctamente
                        Usuario usuarioActual = BaseDatosUsuarios.obtenerUsuario(usuario);
                        abrirVentanaCuenta(usuarioActual);
                        limpiarCampos(); // Limpiar los campos de usuario y contraseña
                    } else {
                        // Mostrar un mensaje de error si el usuario no se autentica correctamente
                        JOptionPane.showMessageDialog(VentanaInicioSesion.this,
                                "Usuario o contraseña incorrectos",
                                "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Configurar comportamiento del botón "Registrarse"
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de registro y limpiar los campos de usuario y contraseña
                abrirVentanaRegistro();
                limpiarCampos();
            }
        });

        // Configurar propiedades del marco
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar el marco
        setSize(500, 350); // Tamaño del marco
        setLocationRelativeTo(null); // Posicionar el marco en el centro de la pantalla
        setVisible(true); // Hacer visible el marco
    }

    private JLabel createCenteredLabel(String text) {
        JLabel label = new JLabel(text); // Crear una etiqueta con el texto proporcionado
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente y estilo de la etiqueta
        label.setForeground(new Color(236, 240, 241)); // Color del texto de la etiqueta
        label.setHorizontalAlignment(SwingConstants.CENTER); // Alinear el texto al centro
        return label; // Devolver la etiqueta creada
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text); // Crear una etiqueta con el texto proporcionado
        label.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente y estilo de la etiqueta
        label.setForeground(new Color(236, 240, 241)); // Color del texto de la etiqueta
        return label; // Devolver la etiqueta creada
    }

    private JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns); // Crear un campo de texto con el número de columnas especificado
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y estilo del campo de texto
        textField.setBackground(new Color(108, 122, 137)); // Color de fondo del campo de texto
        textField.setForeground(Color.white); // Color del texto del campo de texto
        return textField; // Devolver el campo de texto creado
    }

    private JPasswordField createPasswordField(int columns) {
        JPasswordField passwordField = new JPasswordField(columns); // Crear un campo de contraseña con el número de columnas especificado
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y estilo del campo de contraseña
        passwordField.setBackground(new Color(108, 122, 137)); // Color de fondo del campo de contraseña
        passwordField.setForeground(Color.white); // Color del texto del campo de contraseña
        return passwordField; // Devolver el campo de contraseña creado
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text); // Crear un botón con el texto proporcionado
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente y estilo del botón
        button.setBackground(new Color(41, 128, 185)); // Color de fondo del botón
        button.setForeground(Color.white); // Color del texto del botón
        button.setFocusPainted(false); // Evitar que el botón obtenga el enfoque visual
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Borde del botón (espacio interior)
        return button; // Devolver el botón creado
    }

    private void abrirVentanaCuenta(Usuario usuario) {
        VentanaCuenta ventanaCuenta = new VentanaCuenta(usuario); // Crear una nueva ventana de cuenta con el usuario proporcionado
        setVisible(false); // Ocultar la ventana de inicio de sesión actual
        dispose(); // Liberar los recursos utilizados por la ventana de inicio de sesión actual
    }

    private void abrirVentanaRegistro() {
        VentanaRegistro ventanaRegistro = new VentanaRegistro(); // Crear una nueva ventana de registro
        setVisible(false); // Ocultar la ventana de inicio de sesión actual
        dispose(); // Liberar los recursos utilizados por la ventana de inicio de sesión actual
    }

    private void limpiarCampos() {
        txtUsuario.setText(""); // Limpiar el campo de usuario
        txtContraseña.setText(""); // Limpiar el campo de contraseña
    }
}