package empresas.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;



/**
 * Clase que representa el login del programa.
 */
public class LoginPage {
    private JFrame frame;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private Map<String, String> users = new HashMap<>();


    // --------------------PANTALLA DE INICIO DE SESIÓN-----------------------------

    public LoginPage() {
        frame = new JFrame("Inicio de Sesión");
        frame.setSize(900, 600); // tamaño pantalla
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout()); // se agrega un flowLayout a pantalla principal
        
    
        
        JPanel mainPanel = new JPanel();  // panel principal 
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setForeground(Color.BLACK);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    
        // usuario box
        userTextField = new JTextField("belenn", 15);
        userTextField.setBackground(Color.WHITE);
        userTextField.setForeground(Color.BLACK);

        // contraseña box
        passwordField = new JPasswordField("1234", 15);
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPanel.setBackground(Color.BLACK);
        userPanel.add(userTextField);
    
        JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passPanel.setBackground(Color.BLACK);
        passPanel.add(passwordField);
    

        // ingressar botón
        JButton signInButton = new JButton("Ingresar");
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                signIn();
            }
        } 
        );
    
        // registrarse botón
        JButton signUpButton = new JButton("Registrarse");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                signUp();
            }
        }
        );
        
        // ingresar box 
        JPanel signInPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        signInPanel.setBackground(Color.BLACK);
        signInPanel.add(signInButton);
    
        // registrarse box
        JPanel signUpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        signUpPanel.setBackground(Color.BLACK);
        signUpPanel.add(signUpButton);
    
        // añadir al panel
        mainPanel.add(userPanel);
        mainPanel.add(passPanel);
        mainPanel.add(signInPanel);
        mainPanel.add(signUpPanel);
        
        
        // letra 
        Font textF = new Font("Trebuchet MS", Font.PLAIN, 20);
        Font boxF = new Font("Trebuchet MS", Font.BOLD, 17);
        userTextField.setFont(textF);
        passwordField.setFont(textF);
        signInButton.setFont(boxF);
        signUpButton.setFont(boxF);
        

        // imagen de login
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);

        ImageIcon imageIcon = new ImageIcon("LoginEmpresas.png");
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.WEST);

        frame.add(panel);
    
        // propiedades para la vista de la pantalla

        frame.add(mainPanel);
        frame.setBackground(Color.BLACK);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null); // para que aparezca al centro de la pantalla
        frame.setVisible(true);
    
        loadData();
    }
    

    private void loadData(){
        try {
            BufferedReader readerBuff = new BufferedReader(new FileReader("usersData.csv"));
            String line;
            while ((line = readerBuff.readLine()) != null){
                String[] parts = line.split(",");
                users.put(parts[0], parts[1]);
            }
            readerBuff.close();
        } 
        catch (IOException e){ e.printStackTrace(); }
    }
// -----------------INGRESAR----------------------------------------------------------

    private void signIn(){

        // los valores originales de UIManager 
        Object originalUIpane_bg = UIManager.getDefaults().get("OptionPane.background");
        Object originalUIpanel_bg = UIManager.getDefaults().get("Panel.background");
        Object originalUIpane_ms = UIManager.getDefaults().get("OptionPane.messageForeground");
        Object originalUI_ms = UIManager.getDefaults().get("OptionPane.messageFont");
        
        String username = userTextField.getText();
        String password = new String(passwordField.getPassword());

        UIManager.put("OptionPane.background", Color.BLACK);
        UIManager.put("Panel.background", Color.BLACK);

        // mensaje de error font y estilo
        UIManager.put("OptionPane.messageForeground", Color.WHITE);  
        Font messageFont = new Font("Trebuchet MS", Font.BOLD, 15);
        UIManager.put("OptionPane.messageFont", messageFont);

    

        if (users.containsKey(username) && users.get(username).equals(password)) {
            JOptionPane.showMessageDialog(frame, "¡Se ha iniciado sesión con éxito!");
            frame.dispose(); // cerrar la pestaña

            // ---------- INFO DE LA EMPRESA --------------
            //new MainPage();

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new MainPage(username);
                }
            });
    

        }
        else{
            JOptionPane.showMessageDialog(frame, "La contraseña o el usuario es inválido.", "Error de Inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }

        // para restablecer estilo de UIMAnager
        UIManager.put("OptionPane.background", originalUIpane_bg);
        UIManager.put("Panel.background", originalUIpanel_bg);
        UIManager.put("OptionPane.messageForeground", originalUIpane_ms);
        UIManager.put("OptionPane.messageFont", originalUI_ms);
    }

    // -----------------REGISTRO----------------------------------------------------------

    private void signUp(){


        String username = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");

       
        if(users.containsKey(username)){
            JOptionPane.showMessageDialog(frame, "El nombre de usuario ya existe.", "Error por Usuario", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String password = JOptionPane.showInputDialog("Ingrese su contraseña:");
        String confirmPassword = JOptionPane.showInputDialog("Confirme su contraseña:");

        if (password.equals(confirmPassword)){
            users.put(username, password);
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("usersData.csv", true));
                bw.write(username + "," + password + "\n");
                bw.close();
            } 
            catch (IOException e){ e.printStackTrace();}
                
            JOptionPane.showMessageDialog(frame, "Se ha registrado correctamente");
        } 
        else{
            JOptionPane.showMessageDialog(frame, "Las contraseñas deben coincidir.", "Error por Contraseña", JOptionPane.ERROR_MESSAGE);
        }
    }


}
