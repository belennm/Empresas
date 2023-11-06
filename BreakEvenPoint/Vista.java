package BreakEvenPoint;

import java.util.Scanner;

public class Vista {
    private Scanner scanner;

    // Constructor
    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    // Metodo para mostrar el mensaje al usuario
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Metodo para obtener los input del usuario
    public String getInput() {
        return scanner.nextLine();
    }

    // Metodo para obtener el double input del usuario
    public double getDoubleInput() {
        return scanner.nextDouble();
    }

    // Metodo para mostrar el break-even point
    public void displayBreakEvenPoint(double breakEvenPoint) {
        System.out.println("El punto de equilibrio es: " + breakEvenPoint);
    }

    // Methodo para mostrar el monthly fixed cost
    public void displayMonthlyFixedCost(double monthlyFixedCost) {
        System.out.println("El costo fijo mensual es: " + monthlyFixedCost);
    }

    // Metodo para mostrar el per unit price
    public void displayPerUnitPrice(double perUnitPrice) {
        System.out.println("El precio por unidad es: " + perUnitPrice);
    }

    // Metodo para mostrar el variable cost per unit
    public void displayVariableCostPerUnit(double variableCostPerUnit) {
        System.out.println("El costo variable por unidad es: " + variableCostPerUnit);
    }
}
