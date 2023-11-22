package empresas.example;

import javax.swing.*;
import java.awt.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Representa el controlador del programa.
 */
public class Controlador {

    private String username;
    private Controlador controlador;
    public JFrame frame;
    
    // ----- Llamar a login -------
    public void PageinAction() {

        new LoginPage();

    }

    // ------- Buscar el nombre de la empresa en el csv ---------
    private String getEmpresaName(String username){
        try(CSVReader reader = new CSVReader(new FileReader( "empresa_info.csv"))){
            List<String[]> records = reader.readAll() ;
            for(String[] record : records ) {
                if (record.length >= 2 && record[0].equals(username)){
                    return record[1]; //  el nombre de la empresa correspondiente al usuario 
                }
            }
        } 
        catch (IOException | CsvException e){
            e.printStackTrace();
        }
        return username;
    }
    

    // * --------------------- PÁGINA PRINCIPAL ---------------------------- *  
    public void MainPage(String username){
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
        frame.add(topPanel, BorderLayout.NORTH); 

        // show bienvenida en el centro
        JLabel welcomeLabel = new JLabel("Empresas " );
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        // tamaño de la fuente y  color 
        Font labelFont = new Font("Trebuchet MS", Font.BOLD, 20); 
        welcomeLabel.setFont(labelFont);
        welcomeLabel.setForeground(Color.WHITE);
        // un borde para la etiqueta con margen superior
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        frame.add(welcomeLabel, BorderLayout.NORTH);

        // imagen de logo
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);

        ImageIcon imageIcon = new ImageIcon("LoginEmpresas.png");
        Image image = imageIcon.getImage();

        // tamaño de la imagen
        int newWidth = 300; 
        int newHeight = 300 ; 
        Image newImage = image.getScaledInstance(newWidth, newHeight ,  Image.SCALE_SMOOTH);

        // se crea el nuevo ImageIcon
        ImageIcon newImageIcon =  new ImageIcon(newImage);
        JLabel imageLabel = new JLabel(newImageIcon);

        panel.add( imageLabel, BorderLayout.CENTER);

        frame.add(panel);

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

            // // inventario
            //JButton botonInventario = new JButton("Perfil");
            //setButtonProperties(botonInventario) ;
            //botonInventario.addActionListener(e -> pagInventario());
            //add(botonInventario);
            //add(Box.createRigidArea(new Dimension(0, verticalSpace)) );

            // // de personal
            // JButton botonGanancias = new JButton("Ganancias");
            // setButtonProperties(botonGanancias );
            // botonGanancias.addActionListener(e -> pagPersonal());
            // add(botonGanancias) ;
            // add(Box.createRigidArea(new Dimension(0, verticalSpace)));

            // // de equipo
            // JButton botonBreakPoint = new JButton("Equilibrio");
            // setButtonProperties(botonBreakPoint);
            // botonBreakPoint.addActionListener(e -> pagBreakPoint() );
            // add(botonBreakPoint);
            // add(Box.createRigidArea(new Dimension(0, verticalSpace))) ;

            // De Presupuesto
            JButton botonConsejos = new JButton("Consejos" );
            setButtonProperties(botonConsejos);
            botonConsejos.addActionListener(e -> pagPresupuesto()) ;
            add(botonConsejos);

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
        new Perfil( this, username);
    }

    private void pagPersonal() {
        frame.dispose(); // cerrar la pestaña

        // para restablecer estilo de UIMAnager
        UIManager.put("OptionPane.background", originalUIpane_bg);
        UIManager.put("Panel.background", originalUIpanel_bg);
        UIManager.put("OptionPane.messageForeground", originalUIpane_ms);
        UIManager.put("OptionPane.messageFont", originalUI_ms);

        // abrir la página de personal
        new Ganancias(this, username);
    }

    private void pagBreakPoint() {
        frame.dispose(); // cerrar la pestaña

        // para restablecer estilo de UIMAnager
        UIManager.put("OptionPane.background", originalUIpane_bg);
        UIManager.put("Panel.background", originalUIpanel_bg);
        UIManager.put("OptionPane.messageForeground", originalUIpane_ms);
        UIManager.put("OptionPane.messageFont", originalUI_ms);

        // abrir la página de equipo
        new Equilibrio(this, username);
    }

    private void pagPresupuesto() {
        frame.dispose(); // cerrar la pestaña

        // para restablecer estilo de UIMAnager
        UIManager.put("OptionPane.background", originalUIpane_bg);
        UIManager.put("Panel.background", originalUIpanel_bg);
        UIManager.put("OptionPane.messageForeground", originalUIpane_ms);
        UIManager.put("OptionPane.messageFont", originalUI_ms);

        // abrir la página de presupuesto
        new Consejos(this, username);
    }

    // reset de caracterísitcas de Ui
    Object originalUIpane_bg = UIManager.getDefaults().get("OptionPane.background");
    Object originalUIpane_ms = UIManager.getDefaults().get("OptionPane.messageForeground");
    Object originalUIpanel_bg = UIManager.getDefaults().get("Panel.background");
    Object originalUI_ms = UIManager.getDefaults().get("OptionPane.messageFont");

    private static Controlador instance;

    public String getUsername() {
        return this.username;
    }


}
