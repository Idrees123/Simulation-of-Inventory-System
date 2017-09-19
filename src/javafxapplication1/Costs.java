/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

/**
 *
 * @author Idrees
 */
public class Costs {
    double SP,setupCost,HolddingCost,unitCost,penaltyCost;

    public Costs(double SP, double setupCost, double HolddingCost, double unitCost,double penaltyCost) {
        this.SP = SP;
        this.setupCost = setupCost;
        this.HolddingCost = HolddingCost;
        this.unitCost = unitCost;
        this.penaltyCost=penaltyCost;
    }

    public Costs() {
    }
    
}
