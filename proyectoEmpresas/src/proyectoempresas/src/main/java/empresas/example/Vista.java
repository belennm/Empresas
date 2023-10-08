package empresas.example;

/**
 * Clase que representa la vista del programa.
 */

public class Vista {

    Controlador controlador = new Controlador(); // Se crea una nueva instancia del controlador 

    public void show(){
        System.out.println("Bienvenido a Empresas");

        controlador.PageinAction();
        
    }
    
}



