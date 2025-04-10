import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class BibliotecaApp extends JFrame {

    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> materialList = new JList<>(listModel);

    public BibliotecaApp() {
        // Configuración de la ventana
        setTitle("Gestión de Biblioteca");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/icono.png"));
            setIconImage(icono.getImage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el icono: " + e.getMessage());
        }

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 245, 245));
        setContentPane(mainPanel);

        // Panel de entrada (Norte)
        JPanel inputPanel = createInputPanel();
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Lista de materiales (Centro)
        JScrollPane scrollPane = new JScrollPane(materialList);
        customizeScrollPane(scrollPane);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(createTitledBorder("Agregar Nuevo Material", new Color(0, 150, 136)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Componentes
        addLabelAndComponent(panel, gbc, 0, "Tipo de Material:", createStyledComboBox());
        addLabelAndComponent(panel, gbc, 1, "Título:", createStyledTextField());
        addLabelAndComponent(panel, gbc, 2, "Autor:", createStyledTextField()); // Nuevo campo
        addLabelAndComponent(panel, gbc, 3, "Año:", createStyledTextField());
        addLabelAndComponent(panel, gbc, 4, "Detalle:", createStyledTextField());

        // Botones
        JButton agregarBtn = createStyledButton("Agregar Material", new Color(0, 150, 136)); // Turquesa sólido
        JButton limpiarBtn = createStyledButton("Limpiar Campos", new Color(255, 87, 34)); // Naranja sólido

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(agregarBtn);
        buttonPanel.add(limpiarBtn);
        panel.add(buttonPanel, gbc);

        // Acciones
        agregarBtn.addActionListener(e -> agregarMaterial());
        limpiarBtn.addActionListener(e -> limpiarCampos());

        return panel;
    }

    private JComboBox<String> createStyledComboBox() {
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Libro", "Revista", "DVD"});
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboBox.setBackground(Color.WHITE);
        return comboBox;
    }

    private JTextField createStyledTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        return textField;
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                // Fondo sólido personalizado
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(color);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); // Bordes redondeados
                g2.dispose();
                super.paintComponent(g);
            }
        };
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE); // Texto blanco
        button.setOpaque(false);
        button.setContentAreaFilled(false); // Desactiva el fondo por defecto
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20)); // Padding
        button.setFocusPainted(false);
        return button;
    }
    

    private void customizeScrollPane(JScrollPane scrollPane) {
        scrollPane.setBorder(createTitledBorder("Materiales Registrados", new Color(33, 150, 243)));
        materialList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        materialList.setBackground(new Color(250, 250, 250));
    }

    private TitledBorder createTitledBorder(String title, Color color) {
        TitledBorder border = BorderFactory.createTitledBorder(title);
        border.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        border.setTitleColor(color);
        return border;
    }

    private void addLabelAndComponent(JPanel panel, GridBagConstraints gbc, int row, String labelText, JComponent component) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(component, gbc);
    }

    private void agregarMaterial() {
        JComboBox<String> tipoMaterial = (JComboBox<String>) ((JPanel) getContentPane().getComponent(0)).getComponent(1);
        JTextField tituloField = (JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(3);
        JTextField autorField = (JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(5); // Nuevo campo
        JTextField añoField = (JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(7);
        JTextField detalleField = (JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(9);

        String material = tipoMaterial.getSelectedItem() + ": " + tituloField.getText() + 
            " - Autor: " + autorField.getText() + // Incluye el autor
            " (" + añoField.getText() + ") - " + detalleField.getText();
        listModel.addElement(material);
        limpiarCampos();
    }

    private void limpiarCampos() {
        JComboBox<String> tipoMaterial = (JComboBox<String>) ((JPanel) getContentPane().getComponent(0)).getComponent(1);
        JTextField tituloField = (JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(3);
        JTextField autorField = (JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(5); // Nuevo campo
        JTextField añoField = (JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(7);
        JTextField detalleField = (JTextField) ((JPanel) getContentPane().getComponent(0)).getComponent(9);

        tipoMaterial.setSelectedIndex(0);
        tituloField.setText("");
        autorField.setText(""); // Limpia el campo de autor
        añoField.setText("");
        detalleField.setText("");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            BibliotecaApp app = new BibliotecaApp();
            app.setVisible(true);
        });
    }
}
