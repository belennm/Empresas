
package empresas.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la información de la empresa.
 */
public class MainPage {

    private JFrame frame;
    private JLabel[] labels;
    private JTextField[] textFields;
    private JTextField nameEmpresa; 
    private JButton guardarContinueBoton;

    // declaración de variables para almacenar respuestas
    private String companyName; 

    // Campos para GetInfo
    private GetInfo getInfoPanel;

    // -------- PEDIR INFORMACIÓN ----------
    public MainPage(){
        
        frame = new JFrame("Información");
        frame.setSize(900, 600); // size de la pantalla
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout() );
        frame.setLocationRelativeTo(null) ;
        frame.getContentPane().setBackground(Color.BLACK);
        

        // título
        JLabel titleLabel = new JLabel("Información");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout()); // grid para desplegar la info
        GridBagConstraints griid = new GridBagConstraints();
        griid.insets = new Insets(5, 5, 5 , 5 ); // espacio entre casda uno

        labels =  new JLabel[9];
        textFields = new JTextField[9] ;

        Font questionFont = new Font( "Trebuchet MS", Font.BOLD, 16 );  // estilo preguntas
        Font textFieldFont = new Font( "Trebuchet MS", Font.PLAIN , 18); // estilo respuestas

         // campos para GetInfo
         getInfoPanel = new GetInfo(companyName) ;
         getInfoPanel.setVisible(false ); // inicialmente oculto
        

        // para el nombre 
        griid.gridx = 0;
        griid.gridy = 9 ; // se coloca abajo
        griid.anchor = GridBagConstraints.EAST;
        JLabel companyLabel =  new JLabel ( "Nombre de la empresa:" );
        companyLabel.setFont(questionFont);
        inputPanel.setBackground(Color.BLACK);
        companyLabel.setForeground(Color.WHITE);
        inputPanel.add(companyLabel , griid );

        griid.gridx = 1;
        griid.anchor = GridBagConstraints.WEST;
        nameEmpresa =  new JTextField();
        nameEmpresa.setBackground( Color.BLACK);
        nameEmpresa.setForeground( Color.WHITE);
        nameEmpresa.setFont(textFieldFont);
        nameEmpresa.setPreferredSize(new Dimension(200, 35)); // tamaño del campo de nombre
        inputPanel.add(nameEmpresa, griid);


        griid.gridy = 10;
        inputPanel.add(getInfoPanel.getInfoPanel(), griid);

        frame.add(inputPanel, BorderLayout.CENTER );
        

        guardarContinueBoton  = new JButton("Continuar" );

        // acción que se realiza al presionar el botón continuar
        guardarContinueBoton.addActionListener(new ActionListener(){

            @Override

            public void actionPerformed(ActionEvent e){

                saveRespuestas();
            }
        }
    );


        // display del botón para continuar 
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guardarContinueBoton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
       
    }


    private void saveRespuestas(){

        // try and catch para la obtención de datos
        try{


            // para el nombre de la empresa
            companyName = nameEmpresa.getText();

            // cerrar la ventana
            frame.dispose();

            // abrir mainpage
            Controlador controlador = new Controlador();
            controlador.MainPage();
       
      

        } 
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(frame, "Ingrese datos válidos.", "Error por dato inválido", JOptionPane.ERROR_MESSAGE );
        }
    }


}
