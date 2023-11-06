package BreakEvenPoint;

import java.util.Scanner;

public class Controlador {
    private Empresa empresa;
    private Scanner scanner;

    // Constructor
    public Controlador() {
        this.empresa = new Empresa(0, 0, 0, 0);
        this.scanner = new Scanner(System.in);
    }

    // Logica para interacutar con el modelo
    public void iniciar() {
        System.out.println("¿Conoce los datos del costo fijo mensual? (si/no)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Ingrese el costo fijo mensual:");
            double monthlyFixedCost = scanner.nextDouble();
            empresa.setMonthlyFixedCost(monthlyFixedCost);
        } else {
            System.out.println("Ingrese los siguientes datos para calcular el costo fijo mensual:");
            System.out.println("Amortización:");
            double amortizacion = scanner.nextDouble();
            System.out.println("Renta:");
            double renta = scanner.nextDouble();
            System.out.println("Seguro:");
            double seguro = scanner.nextDouble();
            System.out.println("Salarios:");
            double salarios = scanner.nextDouble();
            System.out.println("Utilidades:");
            double utilidades = scanner.nextDouble();
            System.out.println("Depreciación:");
            double depreciacion = scanner.nextDouble();
            System.out.println("Gasto de interés:");
            double gastoInteres = scanner.nextDouble();
            System.out.println("Impuestos a la propiedad:");
            double impuestosPropiedad = scanner.nextDouble();
            System.out.println("Otro costo mensual:");
            double otroCostoMensual = scanner.nextDouble();
            System.out.println("Otro costo fijo:");
            double otroCostoFijo = scanner.nextDouble();

            double monthlyFixedCost = empresa.calculateMonthlyFixedCost(amortizacion, renta, seguro, salarios, utilidades, depreciacion, gastoInteres, impuestosPropiedad, otroCostoMensual, otroCostoFijo);
            System.out.println("El costo fijo mensual es: " + monthlyFixedCost);
        }

        System.out.println("¿Conoce el precio por unidad? (si/no)");
        String respuesta2 = scanner.nextLine();

        if (respuesta2.equalsIgnoreCase("si")) {
            System.out.println("Ingrese el precio por unidad:");
            double perUnitPrice = scanner.nextDouble();
            empresa.setPerUnitPrice(perUnitPrice);
        } else {
            System.out.println("Ingrese los siguientes datos para calcular el precio por unidad:");
            System.out.println("Material directo:");
            double directMaterial = scanner.nextDouble();
            System.out.println("Mano de obra a destajo:");
            double pieceRateLabor = scanner.nextDouble();
            System.out.println("Suministros de producción:");
            double productionSupplies = scanner.nextDouble();
            System.out.println("Comisiones:");
            double commissions = scanner.nextDouble();
            System.out.println("Flete de salida:");
            double freightOut = scanner.nextDouble();
            System.out.println("Otro costo variable:");
            double otherVariableCost = scanner.nextDouble();

            double perUnitPrice = empresa.calculateVariableCostPerUnit(directMaterial, pieceRateLabor, productionSupplies, commissions, freightOut, otherVariableCost);
            System.out.println("El precio por unidad es: " + perUnitPrice);
        }


        double breakEvenPoint = empresa.calculateBreakEvenPoint();
        System.out.println("El punto de equilibrio es: " + breakEvenPoint);
    }
}
