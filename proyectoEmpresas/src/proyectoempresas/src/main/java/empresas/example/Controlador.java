package empresas.example;

import javax.swing.*;
import java.awt.*;

/**
 * Representa el controlador del programa.
 */
public class Controlador {

    private String username;

    public JFrame frame;
    
    // ----- Llamar a login -------
    public void PageinAction() {

        new LoginPage();

    }
    

    // * --------------------- PÁGINA PRINCIPAL ---------------------------- *  
    public void MainPage(){
        UIManager.put("OptionPane.background", Color.BLACK);
        UIManager.put("Panel.background", Color.BLACK);

        // mensaje de error font y estilo
        UIManager.put("OptionPane.messageForeground", Color.WHITE);  
        Font messageFont = new Font("Trebuchet MS", Font.BOLD, 15);
        UIManager.put("OptionPane.messageFont", messageFont);

        
        // ---------- PÁGINA INICIO ---------
        frame = new JFrame("Empresa");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.setLayout(new BorderLayout()); // para el frame

        // ---------- Llamar Menú de opciones ---------
        SideMenuPanel sideMenu = new SideMenuPanel();
        frame.add(sideMenu, BorderLayout.WEST);

        // ------------ SALIR ------------
        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(e -> {
            frame.dispose(); // cierra la ventana 
            System.exit(0);  // Termina el programa
        });
        

        //--- Alinear ---
        // alinear el botón  de salir a la derecha
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(exitButton);
        frame.add(topPanel, BorderLayout.NORTH); // Añade el panel con el botón en la parte superior

        // Show bienvenida en el centro
        JLabel welcomeLabel = new JLabel("¡Bienvenido a la pantalla de inicio!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(welcomeLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
    
    
    // ------------------ MENÚ DE OPCIONES ------------------------

    class SideMenuPanel extends JPanel {

        // Estilo para los botones
        Dimension butSize = new Dimension(175, 55); 
        Font butFont = new Font("Trebuchet MS", Font.BOLD, 18);
        int verticalSpace = 15;  // espacio entre cada botón

        public SideMenuPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            // para alinear verticalmente
            add(Box.createVerticalGlue());

            // inventario
            JButton botonInventario = new JButton("Inventario");
            setButtonProperties(botonInventario) ;
            botonInventario.addActionListener(e -> pagInventario());
            add(botonInventario);
            add(Box.createRigidArea(new Dimension(0, verticalSpace)) );

            // de personal
            JButton botonPersonal = new JButton("Personal");
            setButtonProperties(botonPersonal );
            botonPersonal.addActionListener(e -> pagPersonal());
            add(botonPersonal) ;
            add(Box.createRigidArea(new Dimension(0, verticalSpace)));

            // de equipo
            JButton botonBreakPoint = new JButton("Costos");
            setButtonProperties(botonBreakPoint);
            botonBreakPoint.addActionListener(e -> pagBreakPoint() );
            add(botonBreakPoint);
            add(Box.createRigidArea(new Dimension(0, verticalSpace))) ;

            // De Presupuesto
            JButton botonPresupuesto = new JButton("Presupuesto" );
            setButtonProperties(botonPresupuesto);
            botonPresupuesto.addActionListener(e -> pagPresupuesto()) ;
            add(botonPresupuesto);

            // para alinear verticalmente
            add(Box.createVerticalGlue());
        }

        // aplicar el estilo a los botones
        private void setButtonProperties(JButton button) {
            button.setPreferredSize(butSize);
            button.setMinimumSize(butSize); 
            button.setMaximumSize(butSize);
            button.setFont(butFont);
       
        }
            
    }


    // ------------- LLEVAR A CADA PÁGINA ----------------

    private void pagInventario() {
        // los valores originales de UIManager 

        frame.dispose(); // cerrar la pestaña

        // para restablecer estilo de UIMAnager
        UIManager.put("OptionPane.background", originalUIpane_bg);
        UIManager.put("Panel.background", originalUIpanel_bg);
        UIManager.put("OptionPane.messageForeground", originalUIpane_ms);
        UIManager.put("OptionPane.messageFont", originalUI_ms);

        // abrir la página de inventario
        new Inventario();
    }

    private void pagPersonal() {
        frame.dispose(); // cerrar la pestaña

        // para restablecer estilo de UIMAnager
        UIManager.put("OptionPane.background", originalUIpane_bg);
        UIManager.put("Panel.background", originalUIpanel_bg);
        UIManager.put("OptionPane.messageForeground", originalUIpane_ms);
        UIManager.put("OptionPane.messageFont", originalUI_ms);

        // abrir la página de personal
        new Personal();
    }

    private void pagBreakPoint() {
        frame.dispose(); // cerrar la pestaña

        // para restablecer estilo de UIMAnager
        UIManager.put("OptionPane.background", originalUIpane_bg);
        UIManager.put("Panel.background", originalUIpanel_bg);
        UIManager.put("OptionPane.messageForeground", originalUIpane_ms);
        UIManager.put("OptionPane.messageFont", originalUI_ms);

        // abrir la página de equipo
        new BreakPoint(username);
    }

    private void pagPresupuesto() {
        frame.dispose(); // cerrar la pestaña

        // para restablecer estilo de UIMAnager
        UIManager.put("OptionPane.background", originalUIpane_bg);
        UIManager.put("Panel.background", originalUIpanel_bg);
        UIManager.put("OptionPane.messageForeground", originalUIpane_ms);
        UIManager.put("OptionPane.messageFont", originalUI_ms);

        // abrir la página de presupuesto
        new Presupuesto();
    }

    // reset de caracterísitcas de Ui
    Object originalUIpane_bg = UIManager.getDefaults().get("OptionPane.background");
    Object originalUIpane_ms = UIManager.getDefaults().get("OptionPane.messageForeground");
    Object originalUIpanel_bg = UIManager.getDefaults().get("Panel.background");
    Object originalUI_ms = UIManager.getDefaults().get("OptionPane.messageFont");
}
