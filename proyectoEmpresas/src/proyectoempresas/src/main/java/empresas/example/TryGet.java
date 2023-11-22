package empresas.example;

import java.util.Scanner;

public class TryGet {

    public static double calculateTotalFixedCosts() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calcular tus costos fijos mensuales");
        System.out.println("Los costos fijos son aquellos que no varían con las ventas o el volumen porque están basados en el tiempo. Para este cálculo, el período de tiempo es mensual.");
        
        String knowTotalFixedCosts;
        double totalFixedCosts = 0.0;

        while (true) {
            System.out.print("\n¿Conoces el total de tus costos fijos mensuales? (1 = Sí, 2 = No): ");
            knowTotalFixedCosts = scanner.nextLine();
            if (knowTotalFixedCosts.equals("1") || knowTotalFixedCosts.equals("2")) {
                break;
            } else {
                System.out.println("\nOpción inválida. Por favor, ingresa 1 para Sí o 2 para No.");
            }
        }

        if (knowTotalFixedCosts.equals("1")) {
            System.out.print("Total mensual de costos fijos: $");
            totalFixedCosts = scanner.nextDouble();
        } else if (knowTotalFixedCosts.equals("2")) {
            System.out.println("Debes ingresar los siguientes costos fijos individualmente:");
            totalFixedCosts = inputIndividualFixedCosts();
        }

        return totalFixedCosts;
    }

    public static double calculateSellingPricePerUnit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCalcular el precio al que venderás tus unidades o servicios");
        System.out.print("Precio por unidad: $");
        return scanner.nextDouble();
    }

    public static int calculateExpectedUnitSales() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEstablecer el número de unidades que esperas vender");
        System.out.print("Número de unidades a vender: ");
        return scanner.nextInt();
    }

    public static double calculateVariableCosts() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("\nCalcular los costos variables por unidad");
        
        String knowVariableCostPerUnit;
        
        while (true) {
            System.out.print("\n¿Conoces el costo variable por unidad? (1 = Sí, 2 = No): ");
            knowVariableCostPerUnit = scanner.nextLine();
            if (knowVariableCostPerUnit.equals("1") || knowVariableCostPerUnit.equals("2")) {
                break;
            } else {
                System.out.println("\nOpción inválida. Por favor, ingresa 1 para Sí o 2 para No.");
            }
        }
    
        if (knowVariableCostPerUnit.equals("1")) {
            System.out.print("Costos variables mensuales totales: $");
            return scanner.nextDouble();
        } else if (knowVariableCostPerUnit.equals("2")) {
            System.out.println("Debes ingresar los siguientes costos variables individualmente:");
            return inputIndividualVariableCosts();
        }
    
        return 0.0;
    }
    
    public static double inputIndividualFixedCosts() {
        Scanner scanner = new Scanner(System.in);

        double totalFixedCosts = 0.0;
        String[] fixedCosts = {
            "Amortización",
            "Alquiler",
            "Seguro",
            "Salarios",
            "Servicios públicos",
            "Depreciación",
            "Gastos de interés",
            "Impuestos sobre la propiedad",
            "Otros costos mensuales",
            "Otros costos fijos adicionales"
        };

        for (String cost : fixedCosts) {
            System.out.print(cost + ": $");
            totalFixedCosts += scanner.nextDouble();
        }

        return totalFixedCosts;
    }

    public static double inputIndividualVariableCosts() {
        Scanner scanner = new Scanner(System.in);

        double totalVariableCosts = 0.0;
        String[] variableCosts = {
            "Materiales directos",
            "Mano de obra por pieza",
            "Suministros de producción",
            "Comisiones",
            "Flete de salida",
            "Otros costos variables adicionales"
        };

        for (String cost : variableCosts) {
            System.out.print(cost + ": $");
            totalVariableCosts += scanner.nextDouble();
        }

        return totalVariableCosts;
    }

    public void showResults() {
        double totalFixedCosts = calculateTotalFixedCosts();
        double sellingPricePerUnit = calculateSellingPricePerUnit();
        int unitsToSell = calculateExpectedUnitSales();
        double variableCostsPerUnit = calculateVariableCosts();

        // Calcular los resultados
        double breakEvenUnits = totalFixedCosts / (sellingPricePerUnit - variableCostsPerUnit);
        double breakEvenRevenue = breakEvenUnits * sellingPricePerUnit;
        double contributionMarginRatio = ((sellingPricePerUnit - variableCostsPerUnit) / sellingPricePerUnit) * 100;

        // Mostrar los resultados
        System.out.println("\n--- Resultados del Punto de Equilibrio ---");
        System.out.println("Unidades necesarias para cubrir tus costos: " + breakEvenUnits + " unidades");
        System.out.println("Si vendes tus " + unitsToSell + " unidades previstas, tu ganancia será: $" + (unitsToSell * sellingPricePerUnit - unitsToSell * variableCostsPerUnit - totalFixedCosts));
        System.out.println("Ventas por unidad: $" + breakEvenRevenue);
        System.out.println("Índice de margen de contribución: " + contributionMarginRatio + "%");

        // Mostrar los datos ingresados por el usuario
        System.out.println("\nPerfil de Punto de Equilibrio: ");
        System.out.println("# de unidades");
        System.out.println(unitsToSell);
        System.out.println("Precio por Unidad:");
        System.out.println("$" + sellingPricePerUnit);
        System.out.println("Costos Fijos");
        System.out.println("$" + totalFixedCosts);
        System.out.println("Costos Variables por Unidad");
        System.out.println("$" + variableCostsPerUnit);
        
    }

}

