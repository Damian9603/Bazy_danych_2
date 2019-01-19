/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import db.dbActions;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fiftak
 */
public class zamowienieGUI extends javax.swing.JFrame {

    private int nrKlienta=0;
    private dbActions dbA;
    private String [][] wyb={};
    float suma=0;
    /**
     * Creates new form zamowienieGUI
     */
    public zamowienieGUI(int nr, String [][] wybrane) {
        
        nrKlienta=nr;
        dbA=new dbActions();
        wyb=wybrane;
        initComponents();
        DefaultTableModel model = (DefaultTableModel) tabelaWybranych.getModel();
        for (String[] zamowienia1 : wybrane) {
            model.addRow(zamowienia1);
        }
        
        for(int i=0;i<wybrane.length;i++)
        {
            suma+=Float.parseFloat(wybrane[i][2]);
        }
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        String koszt = df.format(suma);
        calkowityKoszt.setText(koszt);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calkowityKoszt = new javax.swing.JTextField();
        wyborKuriera = new javax.swing.JComboBox<>();
        kurierfirmaLabel = new javax.swing.JLabel();
        buttonAnulujZamowienie = new javax.swing.JButton();
        buttonDokonczZamowienie = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaWybranych = new javax.swing.JTable();
        uwagiLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        uwagiTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        calkowityKoszt.setEditable(false);
        calkowityKoszt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calkowityKosztActionPerformed(evt);
            }
        });

        wyborKuriera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UPSKurier", "KurJerzy", "DPDKurier", "PocztaPolska", "INPost", "Sendit", "Tovax", "FedEX" }));

        kurierfirmaLabel.setText("Wybór firmy kurierskiej");

        buttonAnulujZamowienie.setText("Anuluj");
        buttonAnulujZamowienie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnulujZamowienieActionPerformed(evt);
            }
        });

        buttonDokonczZamowienie.setText("Zamów");
        buttonDokonczZamowienie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDokonczZamowienieActionPerformed(evt);
            }
        });

        tabelaWybranych.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producent", "Model", "Cena", "Rozmiar", "Kolor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaWybranych);

        uwagiLabel.setText("Uwagi:");

        jLabel1.setText("Całkowity koszt");

        uwagiTextArea.setColumns(20);
        uwagiTextArea.setRows(5);
        jScrollPane1.setViewportView(uwagiTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wyborKuriera, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kurierfirmaLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(uwagiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonDokonczZamowienie, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonAnulujZamowienie, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calkowityKoszt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(kurierfirmaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wyborKuriera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(uwagiLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAnulujZamowienie, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDokonczZamowienie, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(calkowityKoszt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage,  titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    private void buttonAnulujZamowienieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnulujZamowienieActionPerformed
        // TODO add your handling code here:
        zamowienieGUI obj1 = new zamowienieGUI(nrKlienta, wyb);
        klientGUI obj2 = new klientGUI(nrKlienta);
        
        obj2.setVisible(true);
        obj1.setVisible(false);
            dispose();
    }//GEN-LAST:event_buttonAnulujZamowienieActionPerformed

    private void calkowityKosztActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calkowityKosztActionPerformed
        
    }//GEN-LAST:event_calkowityKosztActionPerformed

    private void buttonDokonczZamowienieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDokonczZamowienieActionPerformed
         String kurier = wyborKuriera.getItemAt(wyborKuriera.getSelectedIndex());
         String uwagi = uwagiTextArea.getText();
         DefaultTableModel model = (DefaultTableModel) tabelaWybranych.getModel();
         int amount = model.getRowCount();
         int result = dbA.createOder(amount, suma, uwagi, kurier, nrKlienta);
         if(result==-1)
         {
             infoBox("Nie udało się utworzyć zamówienia", "Błąd!");
         }
         else 
         {
                for(int i=0; i<model.getRowCount();i++)
            {
                 String producent = (String) model.getValueAt(i, 0);
                String mod = (String) model.getValueAt(i, 1);
                String cena = (String) model.getValueAt(i, 2);
                String rozmiar = (String) model.getValueAt(i, 3);
                String kolor = (String) model.getValueAt(i, 4);
                int id=dbA.getItemID(Integer.parseInt(rozmiar), producent, kolor, mod, Float.parseFloat(cena));
                boolean res=dbA.createListOrder(result, id);
                if(!res)
                {
                    infoBox("Nie udało się utworzyć zamówienia", "Błąd!");
                    break;
                }
            }
         }
         zamowienieGUI obj1 = new zamowienieGUI(nrKlienta, wyb);
         klientGUI obj2 = new klientGUI(nrKlienta);
        infoBox("Wszystko przebiegło pomyślnie", "Zamówiono!");
         obj2.setVisible(true);
         obj1.setVisible(false);
            dispose();
    }//GEN-LAST:event_buttonDokonczZamowienieActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(zamowienieGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(zamowienieGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(zamowienieGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(zamowienieGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new zamowienieGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAnulujZamowienie;
    private javax.swing.JButton buttonDokonczZamowienie;
    private javax.swing.JTextField calkowityKoszt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kurierfirmaLabel;
    private javax.swing.JTable tabelaWybranych;
    private javax.swing.JLabel uwagiLabel;
    private javax.swing.JTextArea uwagiTextArea;
    private javax.swing.JComboBox<String> wyborKuriera;
    // End of variables declaration//GEN-END:variables
}
