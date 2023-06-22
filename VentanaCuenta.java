import javax.swing.*; //Importa todas las clases y subpaquetes del paquete javax.swing, que proporciona componentes y utilidades para crear interfaces gráficas.
import java.awt.*; //contiene las clases fundamentales para la creación y manipulación de gráficos y componentes de interfaz de usuario.
import java.awt.event.ActionEvent; //se utilizan para manejar eventos de acciones, como clics de botón u otras interacciones con componentes de la interfaz gráfica.
import java.awt.event.ActionListener; //se utilizan para manejar eventos de acciones, como clics de botón u otras interacciones con componentes de la interfaz gráfica.

public class VentanaCuenta extends JFrame {
    private Usuario usuario; // Almacena el objeto Usuario asociado a esta ventana
    private JLabel lblSaldo; // Etiqueta para mostrar el saldo actual
    private JTextField txtRetiro; // Campo de texto para ingresar el valor de retiro
    private JTextField txtConsignacion; // Campo de texto para ingresar el valor de consignación

    public VentanaCuenta(Usuario usuario) {
        super("Cuenta"); // Título de la ventana

        this.usuario = usuario; // Asigna el usuario recibido como parámetro a la variable local

        // Crear componentes
        JLabel lblUsuario = createLabel("Usuario: " + usuario.getUsuario()); // Etiqueta con el nombre de usuario
        JLabel lblNombre = createLabel("Nombre: " + usuario.getNombre() + " " + usuario.getApellido()); // Etiqueta con el nombre completo del usuario
        JLabel lblCorreo = createLabel("Correo: " + usuario.getCorreo()); // Etiqueta con el correo del usuario
        JLabel lblTelefono = createLabel("Teléfono: " + usuario.getTelefono()); // Etiqueta con el teléfono del usuario
        JLabel lblDireccion = createLabel("Dirección: " + usuario.getDireccion()); // Etiqueta con la dirección del usuario
        JLabel lblCedula = createLabel("Cédula: " + usuario.getCedula()); // Etiqueta con la cédula del usuario
        JLabel lblSaldoTitulo = createLabel("Saldo:"); // Etiqueta para mostrar el título "Saldo"
        lblSaldo = createLabel(String.valueOf(usuario.getSaldo())); // Etiqueta para mostrar el saldo actual
        JLabel lblRetiro = createLabel("Valor del retiro:"); // Etiqueta para indicar el campo de texto de retiro
        txtRetiro = createTextField(10); // Campo de texto para ingresar el valor de retiro
        JButton btnRetirar = createButton("Retirar"); // Botón para realizar el retiro
        JLabel lblConsignacion = createLabel("Valor de la consignación:"); // Etiqueta para indicar el campo de texto de consignación
        txtConsignacion = createTextField(10); // Campo de texto para ingresar el valor de consignación
        JButton btnConsignar = createButton("Consignar"); // Botón para realizar la consignación
        JButton btnSolicitudCredito = createButton("Solicitud de crédito"); // Botón para realizar una solicitud de crédito

        // Configurar panel principal
        JPanel panelPrincipal = new JPanel(); // Panel principal que contendrá todos los componentes
        panelPrincipal.setLayout(new GridLayout(8, 2, 10, 10)); // Configura el diseño del panel como una cuadrícula de 8 filas y 2 columnas con espaciado
        panelPrincipal.setBackground(new Color(52, 73, 94)); // Establece el color de fondo del panel
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Establece un borde vacío alrededor del panel
        panelPrincipal.add(lblUsuario); // Agrega la etiqueta de usuario al panel
        panelPrincipal.add(lblNombre); // Agrega la etiqueta de nombre al panel
        panelPrincipal.add(lblCorreo); // Agrega la etiqueta de correo al panel
        panelPrincipal.add(lblCedula); // Agrega la etiqueta de cédula al panel
        panelPrincipal.add(lblTelefono); // Agrega la etiqueta de teléfono al panel
        panelPrincipal.add(lblDireccion); // Agrega la etiqueta de dirección al panel
        panelPrincipal.add(lblSaldoTitulo); // Agrega la etiqueta de título de saldo al panel
        panelPrincipal.add(lblSaldo); // Agrega la etiqueta de saldo al panel
        panelPrincipal.add(lblRetiro); // Agrega la etiqueta de retiro al panel
        panelPrincipal.add(txtRetiro); // Agrega el campo de texto de retiro al panel
        panelPrincipal.add(btnRetirar); // Agrega el botón de retiro al panel
        panelPrincipal.add(lblConsignacion); // Agrega la etiqueta de consignación al panel
        panelPrincipal.add(txtConsignacion); // Agrega el campo de texto de consignación al panel
        panelPrincipal.add(btnConsignar); // Agrega el botón de consignación al panel
        panelPrincipal.add(btnSolicitudCredito); // Agrega el botón de solicitud de crédito al panel

        // Agregar panel principal al marco
        getContentPane().setBackground(new Color(236, 240, 241)); // Establece el color de fondo del marco
        getContentPane().add(panelPrincipal); // Agrega el panel principal al contenido del marco

        // Configurar comportamiento del botón "Retirar"
        btnRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String retiroStr = txtRetiro.getText(); // Obtiene el valor del campo de texto de retiro
                if (retiroStr.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaCuenta.this,
                            "Por favor ingrese el valor del retiro",
                            "Campo vacío", JOptionPane.WARNING_MESSAGE); // Muestra un mensaje de advertencia si no se ingresa un valor de retiro
                } else {
                    double retiro = Double.parseDouble(retiroStr); // Convierte el valor de retiro a un número decimal
                    if (retiro <= usuario.getSaldo()) { // Verifica si el valor de retiro es menor o igual al saldo del usuario
                        usuario.setSaldo(usuario.getSaldo() - retiro); // Resta el valor de retiro al saldo del usuario
                        lblSaldo.setText(String.valueOf(usuario.getSaldo())); // Actualiza la etiqueta de saldo con el nuevo saldo
                        JOptionPane.showMessageDialog(VentanaCuenta.this,
                                "Retiro exitoso",
                                "Retiro", JOptionPane.INFORMATION_MESSAGE); // Muestra un mensaje de retiro exitoso
                    } else {
                        JOptionPane.showMessageDialog(VentanaCuenta.this,
                                "Saldo insuficiente",
                                "Retiro fallido", JOptionPane.ERROR_MESSAGE); // Muestra un mensaje de error si el saldo es insuficiente para el retiro
                    }
                }
                txtRetiro.setText(""); // Limpia el campo de texto de retiro
            }
        });

        // Configurar comportamiento del botón "Consignar"
        btnConsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consignacionStr = txtConsignacion.getText(); // Obtiene el valor del campo de texto de consignación
                if (consignacionStr.isEmpty()) {
                    JOptionPane.showMessageDialog(VentanaCuenta.this,
                            "Por favor ingrese el valor de la consignación",
                            "Campo vacío", JOptionPane.WARNING_MESSAGE); // Muestra un mensaje de advertencia si no se ingresa un valor de consignación
                } else {
                    double consignacion = Double.parseDouble(consignacionStr); // Convierte el valor de consignación a un número decimal
                    usuario.setSaldo(usuario.getSaldo() + consignacion); // Suma el valor de consignación al saldo del usuario
                    lblSaldo.setText(String.valueOf(usuario.getSaldo())); // Actualiza la etiqueta de saldo con el nuevo saldo
                    JOptionPane.showMessageDialog(VentanaCuenta.this,
                            "Consignación exitosa",
                            "Consignación", JOptionPane.INFORMATION_MESSAGE); // Muestra un mensaje de consignación exitosa
                }
                txtConsignacion.setText(""); // Limpia el campo de texto de consignación
            }
        });

        // Configurar comportamiento del botón "Solicitud de crédito"
        btnSolicitudCredito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String solicitudStr = JOptionPane.showInputDialog(VentanaCuenta.this, "Ingrese el valor de la solicitud:"); // Muestra un cuadro de diálogo para ingresar el valor de la solicitud
                if (solicitudStr != null && !solicitudStr.isEmpty()) {
                    double solicitud = Double.parseDouble(solicitudStr); // Convierte el valor de solicitud a un número decimal
                    if (solicitud >= 500000 && solicitud <= 2000000) { // Verifica si el valor de solicitud está dentro del rango permitido
                        usuario.setSaldo(usuario.getSaldo() + solicitud); // Suma el valor de solicitud al saldo del usuario
                        lblSaldo.setText(String.valueOf(usuario.getSaldo())); // Actualiza la etiqueta de saldo con el nuevo saldo
                        JOptionPane.showMessageDialog(VentanaCuenta.this,
                                "Su préstamo se realizó correctamente y tienes un plazo máximo de dos meses para pagarlo",
                                "Solicitud de crédito", JOptionPane.INFORMATION_MESSAGE); // Muestra un mensaje de solicitud de crédito exitosa
                    } else {
                        JOptionPane.showMessageDialog(VentanaCuenta.this,
                                "El valor de la solicitud debe estar entre 500.000 y 2.000.000",
                                "Solicitud de crédito", JOptionPane.WARNING_MESSAGE); // Muestra un mensaje de advertencia si el valor de solicitud está fuera del rango permitido
                    }
                }
            }
        });

        // Configurar propiedades del marco
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establece la operación de cierre del marco al cerrar la ventana
        setSize(700, 500); // Establece el tamaño del marco
        setLocationRelativeTo(null); // Centra el marco en la pantalla
        setVisible(true); // Hace visible el marco
    }

    // Métodos para crear componentes con estilos predefinidos

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text); // Crea una etiqueta con el texto especificado
        label.setFont(new Font("Arial", Font.BOLD, 14)); // Establece la fuente de la etiqueta
        label.setForeground(new Color(52, 152, 219)); // Establece el color del texto de la etiqueta
        return label;
    }

    private JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns); // Crea un campo de texto con el número de columnas especificado
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); // Establece la fuente del campo de texto
        textField.setForeground(new Color(44, 62, 80)); // Establece el color del texto del campo de texto
        return textField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text); // Crea un botón con el texto especificado
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Establece la fuente del botón
        button.setForeground(Color.WHITE); // Establece el color del texto del botón
        button.setBackground(new Color(41, 128, 185)); // Establece el color de fondo del botón
        return button;
    }
}