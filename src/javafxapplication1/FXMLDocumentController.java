/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.sun.jmx.snmp.BerDecoder;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Idrees
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField SimulationLenght;
    @FXML
    private TextField InitailInventoryLevel;
    @FXML
    private TextField FixedCostOrSetUpCost;
    @FXML
    private TextField UnitCost;
    @FXML
    private TextField HoldingCost;
    @FXML
    private TextField QOfBacklogAllow;
    @FXML
    private TextField Policysmalls;
    @FXML
    private TextField PolicyLargeS;
    @FXML
    private TextField Demands;
    @FXML
    private TextField ProbablilityOfDemands;
    private TextField sp;
    @FXML
    private TextField PalentyCost;
    @FXML
    private TextField sp1;
    
   SimulationTable simtable;
    TableRow[] table;
    
    @FXML
    private AnchorPane Dt;
    @FXML
    private Label finalresult;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Costs currentCost=new Costs();
        Policy currentPolicy=new Policy();
        currentCost.HolddingCost=Double.parseDouble(HoldingCost.getText());
        currentCost.SP=Double.parseDouble(sp1.getText());
        currentCost.setupCost=Double.parseDouble(FixedCostOrSetUpCost.getText());
        currentCost.unitCost=Double.parseDouble(UnitCost.getText());
        currentCost.penaltyCost=Double.parseDouble(PalentyCost.getText());
        currentPolicy.InventoryInitial=Integer.parseInt(InitailInventoryLevel.getText());
        currentPolicy.S=Integer.parseInt(PolicyLargeS.getText());
        currentPolicy.s=Integer.parseInt(Policysmalls.getText());
        currentPolicy.backlog=Integer.parseInt(QOfBacklogAllow.getText());
   Simulation sim= new Simulation(currentPolicy,currentCost,Integer.parseInt(SimulationLenght.getText()),Demands.getText(),ProbablilityOfDemands.getText());
    //  obj.MakeInterval();
      //obj.Calculation();
   double total=0;
   table=sim.runSimulator();
        for (TableRow table1 : table) {
            total+=table1.TotalRevenue;
        }
   //obj.show();
 simtable=  new SimulationTable(table);
 simtable.setVisible(true);
        System.out.println("Profit after "+SimulationLenght.getText()+"days is "+(int)total);
        Dt.setVisible(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        // TODO
     //     Dt.setVisible(false);
    }    

    @FXML
    private void handleButtonActionDt(ActionEvent event) {
        simtable.getGraph(table);
    }
    
    
}
