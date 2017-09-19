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
public class Simulation {

    Policy cp;
    Costs cc;
    int SimulationLength;
    String Demands;

    String ProbablilityOfDemands;
    String[] ArrayDemands;
    String[] Probability;
    double[] Interval;
    TableRow[] table;

    public Simulation(Policy cp, Costs cc, int SimulationLength, String Demands, String ProbablilityOfDemands) {
        this.cp = cp;
        this.cc = cc;
        this.SimulationLength = SimulationLength;
        this.Demands = Demands;
        this.ProbablilityOfDemands = ProbablilityOfDemands;

        Probability = ProbablilityOfDemands.split(",");
        MakeInterval();
        ArrayDemands = Demands.split(",");

    }

    TableRow[] runSimulator() {
        table = new TableRow[SimulationLength];
        Boolean Orderplace = true;
        int orderDay = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = new TableRow(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            table[i].dayno = i + 1;
            table[i].Demand = Demands(Math.random());
            if (i - orderDay == 2) {
                Orderplace = true;
            }
            if (i == 0) {
                table[i].InitialInventory = cp.InventoryInitial;
            } else {
                if (i != 1) {
                    table[i].InitialInventory = table[i - 1].InventoryLevel + table[i - 2].Z;

                } else {
                    table[i].InitialInventory = table[i - 1].InventoryLevel;
                }
            }
            if (table[i].InitialInventory - table[i].Demand >= cp.backlog) {
                table[i].InventoryLevel = table[i].InitialInventory - table[i].Demand;
            } else {
                table[i].InventoryLevel = cp.backlog;
                table[i].PenaltyCost = Math.abs(table[i].InitialInventory - table[i].Demand - cp.backlog) * cc.penaltyCost;
            }
            if (table[i].InventoryLevel <= cp.s && Orderplace == true) {
                table[i].Z = cp.S - table[i].InventoryLevel;
                Orderplace = false;
                orderDay = i;
            }
            table[i].SalesRevenue = (table[i].InitialInventory - table[i].InventoryLevel) * cc.SP;
            if (table[i].Z > 0) {
                table[i].OrderCost = cc.setupCost + cc.unitCost * table[i].Z;
            }
            if (table[i].InventoryLevel > 0) {
                table[i].HolidingCost = cc.HolddingCost * table[i].InventoryLevel;
            }
            table[i].TotalRevenue = table[i].SalesRevenue - table[i].HolidingCost - table[i].PenaltyCost - table[i].OrderCost;

        }
        return table;

    }

    void MakeInterval() {
        Interval = new double[Probability.length + 1];
        Interval[0] = 0;
        for (int i = 1; i < Probability.length; i++) {

            Interval[i] = Interval[i - 1] + Double.parseDouble(Probability[i - 1]);
        //temp=Interval[i];

            System.out.println("interval" + Interval[i]);
        }
        Interval[Interval.length - 1] = 1;

    }

    int Demands(Double Value) {
        for (int i = 0; i < Interval.length; i++) {
            if (Value >= Interval[i] && Value < Interval[i + 1]) {
                return Integer.parseInt(ArrayDemands[i]);
            }
        }

        return 0;
    }

}
