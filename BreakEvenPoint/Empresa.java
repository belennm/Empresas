package BreakEvenPoint;

public class Empresa {
    private double monthlyFixedCost;
    private double perUnitPrice;
    private double numberOfUnitsToSell;
    private double variableCostPerUnit;

    // Constructor
    public Empresa(double monthlyFixedCost, double perUnitPrice, double numberOfUnitsToSell, double variableCostPerUnit) {
        this.monthlyFixedCost = monthlyFixedCost;
        this.perUnitPrice = perUnitPrice;
        this.numberOfUnitsToSell = numberOfUnitsToSell;
        this.variableCostPerUnit = variableCostPerUnit;
    }

    // Getters y Setters
    public double getMonthlyFixedCost() {
        return monthlyFixedCost;
    }

    public void setMonthlyFixedCost(double monthlyFixedCost) {
        this.monthlyFixedCost = monthlyFixedCost;
    }

    public double getPerUnitPrice() {
        return perUnitPrice;
    }

    public void setPerUnitPrice(double perUnitPrice) {
        this.perUnitPrice = perUnitPrice;
    }

    public double getNumberOfUnitsToSell() {
        return numberOfUnitsToSell;
    }

    public void setNumberOfUnitsToSell(double numberOfUnitsToSell) {
        this.numberOfUnitsToSell = numberOfUnitsToSell;
    }

    public double getVariableCostPerUnit() {
        return variableCostPerUnit;
    }

    public void setVariableCostPerUnit(double variableCostPerUnit) {
        this.variableCostPerUnit = variableCostPerUnit;
    }

    // Logica para calcular el monthly fixed cost
    public double calculateMonthlyFixedCost(double amortization, double rent, double insurance, double salaries, double utilities, double depreciation, double interestExpense, double propertyTaxes, double otherMonthlyCost, double otherFixedCost) {
        this.monthlyFixedCost = amortization + rent + insurance + salaries + utilities + depreciation + interestExpense + propertyTaxes + otherMonthlyCost + otherFixedCost;
        return this.monthlyFixedCost;
    }

    // Logica para calcular su variable cost per unit
    public double calculateVariableCostPerUnit(double directMaterial, double pieceRateLabor, double productionSupplies, double commissions, double freightOut, double otherVariableCost) {
        this.variableCostPerUnit = directMaterial + pieceRateLabor + productionSupplies + commissions + freightOut + otherVariableCost;
        return this.variableCostPerUnit;
    }

    // Logic para calcular el break-even point
    public double calculateBreakEvenPoint() {
        return this.monthlyFixedCost / (this.perUnitPrice - this.variableCostPerUnit);
    }
}
