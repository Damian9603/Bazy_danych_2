package gui;


import db.dbActions;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fiftak
 */
public class sklepGUI extends javax.swing.JFrame {

    /**
     * Creates new form sklepGUI
     */
    private int nrKlienta=0;
    private dbActions dbA;


    public sklepGUI(int nr) {
        nrKlienta=nr;
        dbA=new dbActions();
        initComponents();

    
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage,  titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rozmiarLabel = new javax.swing.JLabel();
        filtrRozmiar = new javax.swing.JComboBox<>();
        filtrProducent = new javax.swing.JComboBox<>();
        producentLabel = new javax.swing.JLabel();
        filtrKolor = new javax.swing.JComboBox<>();
        producentLabel1 = new javax.swing.JLabel();
        cenaTextField = new javax.swing.JTextField();
        producentLabel2 = new javax.swing.JLabel();
        filtrRodzaj = new javax.swing.JComboBox<>();
        producentLabel3 = new javax.swing.JLabel();
        buttonSetZamowienie = new javax.swing.JButton();
        buttonWrocDoKonta = new javax.swing.JButton();
        szukajButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaWyszukiwania = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rozmiarLabel.setText("Wybierz rozmiar:");

        filtrRozmiar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "36", "37", "38", "39", "40", "41", "42", "43", "44" }));
        filtrRozmiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrRozmiarActionPerformed(evt);
            }
        });

        filtrProducent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Dowolny",
            "adidas",
            "Nike",
            "UnderArmour",
            "4f",
            "Reebok",
            "Asics",
            "Puma",
            "Salomon",
            "Adler",
            "Spalding",
            "Outhorn",
            "Odlo",
            "NewBalance",
            "Aqua-Speed",
            "Mizuno",
            "Mikasa",
            "Molten",
            "Reusch",
            "Wilson",
            "Speedo",
            "Allright",
            "Colo",
            "Donic",
            "TalbotTorro",
            "DragonSports",
            "GreenHill",
            "Fox",
            "Joma",
            "Masita",
            "SportMasters",
            "Realstick",
            "Select",
            "Spokey",
            "Netex",
            "Rucanor",
            "Schildkrot",
            "Meteor",
            "Reda",
            "PANTHERA",
            "KingCamp",
            "Isostar",
            "Olimp",
            "Stiga",
            "Shield",
            "Pono",
            "Point",
            "Givova",
            "Legea",
            "Uvex",
            "Gabel"}));
filtrProducent.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        filtrProducentActionPerformed(evt);
    }
    });

    producentLabel.setText("Wyberz producenta:");

    filtrKolor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dowolny", "bialy", "niebieski", "czerwony", "czarny", "zielony" }));

    producentLabel1.setText("Wyberz kolor:");

    producentLabel2.setText("Cena maksymalna:");

    filtrRodzaj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sportowe", "zimowe", "japonki", "wizytowe", "glany" }));

    producentLabel3.setText("Wybierz rodzaj:");

    buttonSetZamowienie.setText("Złóż zamówienie");
    buttonSetZamowienie.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonSetZamowienieActionPerformed(evt);
        }
    });

    buttonWrocDoKonta.setText("Wróć do konta");
    buttonWrocDoKonta.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonWrocDoKontaActionPerformed(evt);
        }
    });

    szukajButton.setText("Szukaj");
    szukajButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            szukajButtonActionPerformed(evt);
        }
    });

    tabelaWyszukiwania.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane2.setViewportView(tabelaWyszukiwania);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonSetZamowienie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(producentLabel1)
                                .addComponent(producentLabel2)
                                .addComponent(producentLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cenaTextField)
                                .addComponent(filtrKolor, 0, 112, Short.MAX_VALUE)
                                .addComponent(filtrRodzaj, 0, 112, Short.MAX_VALUE)))
                        .addComponent(szukajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rozmiarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtrRozmiar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(producentLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtrProducent, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(buttonWrocDoKonta))))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(rozmiarLabel)
                .addComponent(filtrRozmiar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(filtrProducent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(producentLabel))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(filtrKolor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(producentLabel1))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(filtrRodzaj, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(producentLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cenaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(producentLabel2))
            .addGap(18, 18, 18)
            .addComponent(szukajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(buttonSetZamowienie, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(buttonWrocDoKonta, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtrRozmiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrRozmiarActionPerformed

    }//GEN-LAST:event_filtrRozmiarActionPerformed

    private void filtrProducentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrProducentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrProducentActionPerformed

    private void buttonSetZamowienieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSetZamowienieActionPerformed
        // TODO add your handling code here:
        if(tabelaWyszukiwania.getSelectedRowCount()>0)
        {
            DefaultTableModel model = (DefaultTableModel) tabelaWyszukiwania.getModel();

            int [] wybraneWiersze = tabelaWyszukiwania.getSelectedRows();
            String [][] wybrane = new String [tabelaWyszukiwania.getSelectedRowCount()][5];
            for(int i=0; i<wybraneWiersze.length;i++)
            {
               for(int j=0;j<5;j++)
               {
                   wybrane[i][j]=(String) model.getValueAt(wybraneWiersze[i], j);
               }
            
            }
            sklepGUI obj1 = new sklepGUI(nrKlienta);
            zamowienieGUI obj2 = new zamowienieGUI(nrKlienta, wybrane);
            obj2.setVisible(true);
            obj1.setVisible(false);
            dispose();
        }
        else
        {
            infoBox("Proszę wybrać co najmniej jedną parę butów", "Nic nie wybrano!");
        }
        
    }//GEN-LAST:event_buttonSetZamowienieActionPerformed

    private void buttonWrocDoKontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWrocDoKontaActionPerformed
        // TODO add your handling code here:
        sklepGUI obj1 = new sklepGUI(nrKlienta);
        klientGUI obj2 = new klientGUI(nrKlienta);
        
        obj2.setVisible(true);
        obj1.setVisible(false);
            dispose();
    }//GEN-LAST:event_buttonWrocDoKontaActionPerformed

    private void szukajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szukajButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabelaWyszukiwania.getModel();
        int rows = model.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        int rozmiar=filtrRozmiar.getSelectedIndex();
        rozmiar+=36;
        String producent = " " + filtrProducent.getItemAt(filtrProducent.getSelectedIndex());
        String kolor = filtrKolor.getItemAt(filtrKolor.getSelectedIndex());
        String rodzaj = filtrRodzaj.getItemAt(filtrRodzaj.getSelectedIndex());
        String c = cenaTextField.getText();
        int cena;
        try
        {
            cena=Integer.parseInt(c);
        }
        catch(NumberFormatException e)
        {
            infoBox("Podano nieprawidłową wartość jako liczbę!","Błąd!");
            return;
        }
        String [][] wyszukano = dbA.search(rozmiar, producent, kolor, rodzaj, cena);
        
        for (String[] zamowienia1 : wyszukano) {
            model.addRow(zamowienia1);
        }
    }//GEN-LAST:event_szukajButtonActionPerformed

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
            java.util.logging.Logger.getLogger(sklepGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sklepGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sklepGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sklepGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new sklepGUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSetZamowienie;
    private javax.swing.JButton buttonWrocDoKonta;
    private javax.swing.JTextField cenaTextField;
    private javax.swing.JComboBox<String> filtrKolor;
    private javax.swing.JComboBox<String> filtrProducent;
    private javax.swing.JComboBox<String> filtrRodzaj;
    private javax.swing.JComboBox<String> filtrRozmiar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel producentLabel;
    private javax.swing.JLabel producentLabel1;
    private javax.swing.JLabel producentLabel2;
    private javax.swing.JLabel producentLabel3;
    private javax.swing.JLabel rozmiarLabel;
    private javax.swing.JButton szukajButton;
    private javax.swing.JTable tabelaWyszukiwania;
    // End of variables declaration//GEN-END:variables
}
