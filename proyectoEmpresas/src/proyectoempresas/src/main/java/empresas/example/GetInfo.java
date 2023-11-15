package empresas.example;

import javax.swing.*;

import com.opencsv.CSVWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Clase que representa la obtención de información.
 */
public class GetInfo {

    private JFrame frame; 
    private JPanel panel;
    private JButton butCalculate;
    private JButton butInFixedCosts;
    private JButton butInputVariableCosts;
    private JTextField total_FixedCosts;
    private JTextField precioXUnit;
    private JTextField UnitsSell;
    private JTextField variableCostsXUnidad;
    private JTextArea result_area;

    //  los nombres de los costos fijos y variables  para solicitarlos en individual
    private String[] fixedCost_nombres = {
            "Amortización", "Alquiler", "Seguro" , "Salarios", "Servicios públicos", "Depreciación", "Gastos de interés", "Impuestos sobre la propiedad" , "Otros costos mensuales" , "Otros costos fijos adicionales"
    };

    private String[] variableCost_nombres = 
    {
            "Materiales directos", "Mano de obra por pieza" , "Suministros de producción", "Comisiones", "Flete de salida" , "Otros costos variables adicionales"
    };

    // mapas para almacenar los JTextFields que se generaron para costos fijos y variables
    private Map<String, JTextField> fixedCostFields = new HashMap<>();
    private Map<String, JTextField> variableCostFields = new HashMap<>();

    // obtención de información
    public GetInfo(String companyName){

        // título de la ventana
        frame =  new JFrame( "Información") ;

        // creación del nuevo panel
        panel  = new JPanel( );
        
        // para que se muestre verticalmente
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS ));
        //
        frame.setSize(900, 600);

        // establecer el tamaño de cada Field
        total_FixedCosts = new JTextField(10);
        precioXUnit = new JTextField(10);
        UnitsSell =  new JTextField(10);
        variableCostsXUnidad = new JTextField(10);
        result_area = new  JTextArea(10, 30);
        JTextField field = new JTextField(10);
        field.setBackground(Color.BLACK);
        field.setForeground(Color.BLACK);

       // color
       panel.setBackground(Color.BLACK);
        panel.setForeground(Color.WHITE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBackground(Color.BLACK);
       frame.setLocationRelativeTo(null); // para que aparezca al centro de la pantalla
        frame.setVisible(true);

        
      

        // botón para calcular
        butCalculate = new JButton("Calcular Punto de Equilibrio" );
        
        // realiza la acción de calcular
        butCalculate.addActionListener(new ActionListener(){

            // acción para mostrar los cálculos
            public void actionPerformed(ActionEvent e){
                calcular_Show() ;
            }

        });



        // botón para ingresar costos fijos por individual
        butInFixedCosts = new JButton( "Ingresar Costos Fijos Individuales");
        
        butInFixedCosts.addActionListener( new ActionListener(){

            // realizar la acción de performace para el botón
            public void actionPerformed(ActionEvent e){
                inputIndividualCosts(fixedCost_nombres, "fijos", fixedCostFields);
            }

        });

        // botón para ingresar costos variables por individual
        butInputVariableCosts = new  JButton( "Ingresar Costos Variables Individuales" );
       

        butInputVariableCosts.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                inputIndividualCosts(variableCost_nombres, "variables", variableCostFields);
            }

        } );

        
        // añadir componentes al panel
        panel.add( new JLabel( "Total de Costos Fijos: "));
        panel.add(total_FixedCosts);
        panel.add(butInFixedCosts);
        panel.add(new JLabel("Precio por Unidad: ") );
        panel.add( precioXUnit);
        panel.add(new  JLabel("Unidades a Vender: "));
        panel.add(UnitsSell);
        panel.add(new  JLabel("Costo Variable por Unidad: "));
        panel.add(variableCostsXUnidad );
        panel.add(butInputVariableCosts );
        panel.add(butCalculate);
        panel.add(new JScrollPane(result_area ));

        //** */
        setColors(panel);

        // crear el frame del panel
        frame.add(panel);
        frame.pack() ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        

        
    }

    // para poder mostrar GetInfo en MAinPage
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public JPanel getInfoPanel() {
        return panel;
    }

    public void setFrameVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public boolean isFrameVisible() {
        return frame.isVisible();
    }

    // configurar los colores
    private void setColors(Component component){

        if (component instanceof JPanel || component instanceof JScrollPane){
            component.setBackground(Color.BLACK);
            component.setForeground(Color.WHITE);
        }

        if (component instanceof JButton){
            ((JButton) component).setBackground(Color.lightGray);
            ((JButton) component).setForeground(Color.BLACK);
        }

        // botón punto de equilibrio
        if (component instanceof JButton && component.equals(butCalculate)){
            ( (JButton ) component).setBackground( Color.green); 
            ( (JButton) component).setForeground(Color.black );
        }

        if(component instanceof JLabel){
            ( (JLabel) component).setForeground(Color.WHITE );
        }


        if(component instanceof JTextField){
            component.setBackground(Color.BLACK);
            component.setForeground(Color.WHITE);
        }

        if (component instanceof JTextArea){
            ((JTextArea ) component).setBackground( Color.BLACK);
            ((JTextArea) component ).setForeground(Color.WHITE );
        }

        if (component instanceof Container ){
            for( Component child : ((Container) component).getComponents()){
                setColors(child);
            }
        }
    }


    //------------------------- DATOS INDIVIDUALES ------------------------------------------
    // para solicitar costos individuales
    private void inputIndividualCosts( String[]  costNames, String costType, Map<String, JTextField > fieldsMap ){
        JPanel  costPanel =  new JPanel(new GridLayout(0, 2, 10, 10));

        // ciclo for para que se muestren los datos por individuales y el espacio para solicitar
        for(String costName :  costNames){
             JLabel label = new JLabel( costName + ": $") ;
            JTextField field =  new JTextField(10);
           
            fieldsMap.put(costName ,  field);
            costPanel.add( label);
            costPanel.add(field);
        }

        // opción para ingresar datos
        int result  = JOptionPane.showConfirmDialog(frame, costPanel, "Ingrese los costos " +  costType , JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE );

                // si se ingresan datos, comprobar que se ingresen datos y que los datos ingresados sean válidos
                if(result == JOptionPane.OK_OPTION ){
                    // sumar y actualizar los costos fijos
                    double totalFixedCost  = 0 ;
                    for( Map.Entry<String, JTextField > entry : fixedCostFields.entrySet()){
                       // try and catch para 
                        try{
                            double value =  Double.parseDouble(entry.getValue().getText()) ;
                            totalFixedCost +=  value;
                        } 
                        catch (NumberFormatException nfe){
                            JOptionPane.showMessageDialog( frame, "Por favor, ingrese un dato válido para " + entry.getKey() );
                            
                            return;
                        }
                    }

                    // total de los Fixed Costs
                    total_FixedCosts.setText(String.valueOf(totalFixedCost ) );
                
                    // para costos variables
                    double totalVariableCost = 0;

                    // verificar si se han ingresado datos y en ese caso verificar que el dato ingresado sea válido
                    for (Map.Entry<String, JTextField > entry :  variableCostFields.entrySet( )){
                        
                        // try and catch para verificar que sea válido
                        try{
                            double value =  Double.parseDouble(entry.getValue().getText());
                            totalVariableCost +=  value;
                        } 
                        catch (NumberFormatException nfe){
                            JOptionPane.showMessageDialog(frame, "Por favor, ingrese un dato válido para " + entry.getKey());
                            return;
                        }
                    }

                    // total de variable para costos por unidad
                    variableCostsXUnidad.setText(String.valueOf(totalVariableCost));
                }
                
    }

    //--------------------------------CSV GUARDAR DATOS ---------------------------------------------------
        private void saveResultsToCSV(String fileName, double breakEvenPointUnits, double totalFixedCosts, double variableCostsPerUnit, double pricePerUnit, double unitsToSell) {
        try{
            FileWriter writer = new FileWriter(fileName );

            CSVWriter csvWriter = new CSVWriter(writer ) ;
            
            // encabezados 
            String[] headers = { "Punto de Equilibrio", "Total de Costos Fijos", "Costos Variables por Unidad", "Precio por Unidad", "Unidades a Vender" };
            csvWriter.writeNext(headers);

            // los datos de los resultados
            String[] data = { String.valueOf(breakEvenPointUnits), String.valueOf(totalFixedCosts), String.valueOf(variableCostsPerUnit), String.valueOf(pricePerUnit), String.valueOf(unitsToSell) };
            csvWriter.writeNext(data);

            // cerrar  el  CSV para no tener problemas
            csvWriter.close();

            // mostrar al usuario que los resultados se han guardado 
            JOptionPane.showMessageDialog(frame, "Resultados guardados en " + fileName);
        } 
        
        catch (IOException e){
            JOptionPane.showMessageDialog(frame, "Error al guardar los resultados en un archivo CSV");
        }
    }

    // ----------------------------------- CÁLCULOS ---------------------------------------------------------------
    private void calcular_Show(){
        // try and catch para los cálculos, verifica que los datos sean válidos
        try{
            // variables 
            double totalFixedCosts;
            double totalVariableCosts;
            double pricePerUnit = Double.parseDouble(precioXUnit.getText());
            double unitsToSell = Double.parseDouble(UnitsSell.getText());
            double variableCostsPerUnit;
    
            // mira si el campo del costo fijo cuenta con un valor
            if( !total_FixedCosts.getText().trim().isEmpty( )){
                totalFixedCosts  = Double.parseDouble(total_FixedCosts.getText() );
            } 
            else{
                // suma  los valores de los campos  de los costos fijos individuales
                totalFixedCosts = fixedCostFields.values().stream().filter(field -> !field.getText().trim().isEmpty()) .mapToDouble(field -> Double.parseDouble(field.getText()) ).sum();
            }
    
            // mira si el campo del costo variable por unidad tiene un valor
            if( !variableCostsXUnidad.getText() .trim().isEmpty() ) {
                variableCostsPerUnit = Double.parseDouble(variableCostsXUnidad.getText());
            } 
            else{
                // suma los valores de los campos de costos variables individuales
                variableCostsPerUnit = variableCostFields.values().stream().filter( field ->  !field.getText().trim().isEmpty()).mapToDouble(field -> Double.parseDouble(field.getText()) ).sum() ;
            }
    
            // cálculo del punto de equilibrio
            double breakEvenPointUnits = totalFixedCosts / ( pricePerUnit - variableCostsPerUnit );

            // --------------- MOSTRAR ----------------
            result_area.setText("El punto de equilibrio es: "  + breakEvenPointUnits +  " unidades.\n");
            result_area.append("Total de costos fijos: " + totalFixedCosts  + "\n");
            result_area.append("Costo variable por unidad: "   + variableCostsPerUnit + "\n");
            result_area.append("Precio por unidad: " + pricePerUnit +    "\n" );
    
            // indica si se alcanzó el punto de equilibrio o no, en caso de no alcanzarse se muestra cuántas unidades más se necesitan
            if( unitsToSell >= breakEvenPointUnits ){
                result_area.append("\nCon " + unitsToSell  + " unidades, usted ALCANZARÁ el punto de equilibrio.") ;
            }
            else {
                result_area.append("\nCon " + unitsToSell +  " unidades, usted NO alcanzará el punto de equilibrio." ) ;
                
                double additionalUnitsNeeded =  breakEvenPointUnits -  unitsToSell;

                result_area.append("\nUnidades adicionales necesarias para alcanzar el punto de equilibrio: " + String.format("%.2f", additionalUnitsNeeded) );

               
            }
    
             // guardar a csv 
            saveResultsToCSV("resultados.csv", breakEvenPointUnits, totalFixedCosts, variableCostsPerUnit, pricePerUnit, unitsToSell);
        } 
        catch (NumberFormatException e){
            result_area.setText("Por favor, ingrese datos válidos.");
        }

        
    }




    
 
}
