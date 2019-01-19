/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import db.dbActions;


/**
 *
 * @author Fiftak
 */
public class Gui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         dbActions dbA=new dbActions();
         dbA.connect();
         new startingFrame(dbA).setVisible(true);
         

    }
    
}
