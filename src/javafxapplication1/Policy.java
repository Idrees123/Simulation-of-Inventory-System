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
public class Policy {
    int s,S,backlog,InventoryInitial;

    public Policy(int s, int S, int backlog, int InventoryInitial) {
        this.s = s;
        this.S = S;
        this.backlog = backlog;
        this.InventoryInitial = InventoryInitial;
    }

    public Policy() {
    }
}
