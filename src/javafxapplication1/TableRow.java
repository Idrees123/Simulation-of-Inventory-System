/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edsitor.
 */
package javafxapplication1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author Idrees
 */
public class TableRow {

    public TableRow(int dayno, int InitialInventory, int Demand, int InventoryLevel, int Z, double SalesRevenue, double OrderCost, double HolidingCost, double PenaltyCost, double TotalRevenue) {
        this.dayno = dayno;
        this.InitialInventory = InitialInventory;
        this.Demand = Demand;
        this.InventoryLevel = InventoryLevel;
        this.Z = Z;
        this.SalesRevenue = SalesRevenue;
        this.OrderCost = OrderCost;
        this.HolidingCost = HolidingCost;
        this.PenaltyCost = PenaltyCost;
        this.TotalRevenue = TotalRevenue;
    }
  TableRow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDayno() {
        return dayno;
    }

    public void setDayno(int dayno) {
        this.dayno = dayno;
    }

    public int getInitialInventory() {
        return InitialInventory;
    }

    public void setInitialInventory(int InitialInventory) {
        this.InitialInventory = InitialInventory;
    }

    public int getDemand() {
        return Demand;
    }

    public void setDemand(int Demand) {
        this.Demand = Demand;
    }

    public int getInventoryLevel() {
        return InventoryLevel;
    }

    public void setInventoryLevel(int InventoryLevel) {
        this.InventoryLevel = InventoryLevel;
    }

    public int getZ() {
        return Z;
    }

    public void setZ(int Z) {
        this.Z = Z;
    }

    public double getSalesRevenue() {
        return SalesRevenue;
    }

    public void setSalesRevenue(double SalesRevenue) {
        this.SalesRevenue = SalesRevenue;
    }

    public double getOrderCost() {
        return OrderCost;
    }

    public void setOrderCost(double OrderCost) {
        this.OrderCost = OrderCost;
    }

    public double getHolidingCost() {
        return HolidingCost;
    }

    public void setHolidingCost(double HolidingCost) {
        this.HolidingCost = HolidingCost;
    }

    public double getPenaltyCost() {
        return PenaltyCost;
    }

    public void setPenaltyCost(double PenaltyCost) {
        this.PenaltyCost = PenaltyCost;
    }

    public double getTotalRevenue() {
        return TotalRevenue;
    }

    public void setTotalRevenue(double TotalRevenue) {
        this.TotalRevenue = TotalRevenue;
    }
    int dayno,InitialInventory,Demand,InventoryLevel,Z;
    double SalesRevenue,OrderCost,HolidingCost,PenaltyCost,TotalRevenue;
    
  
    
}
