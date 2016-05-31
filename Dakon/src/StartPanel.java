/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
   
import javax.swing.JButton;
import javax.swing.text.*;

/**
 *
 * @author Fersandi Pratama
 */
public class StartPanel extends javax.swing.JPanel {
    
    //User defined Field Declaration
    private int numOfPlayers;
    private int numOfHoles;
    
    private AboutPanel aboutPanel;

    /**
     * Creates new form StartPanel
     * 
     */
    public StartPanel() {
        initComponents();
        initComponentUser();
    }
    
    private void initComponentUser(){
        sevenHolesRadioButton.setSelected(true);
        numOfHoles = 7;
        
        onePlayerRadioButton.setSelected(true);
        numOfPlayers = 1;
        
        numOfRockTextField.setDocument(new LengthRestrictedDocument(2));
        numOfRockTextField.setText("7");
        
        aboutPanel = new AboutPanel();
    }
    
    public JButton getStartButton(){
        return this.startButton;
    }
    
    public int getNumOfPlayers(){
        return numOfPlayers;
    }
    
    public int getNumOfHoles(){
        return numOfHoles;
    }
    
    public int getNumOfRocks() throws NumberFormatException{
        int rocks;
        rocks = Integer.parseInt(numOfRockTextField.getText());
        return rocks;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        startButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        onePlayerRadioButton = new javax.swing.JRadioButton();
        twoPlayersRadioButton = new javax.swing.JRadioButton();
        fiveHolesRadioButton = new javax.swing.JRadioButton();
        sevenHolesRadioButton = new javax.swing.JRadioButton();
        ninesHolesRadioButton = new javax.swing.JRadioButton();
        numOfRockTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(330, 300));

        startButton.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        startButton.setText("Mulai");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Jumlah Lubang");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Jumlah Batu");

        buttonGroup1.add(onePlayerRadioButton);
        onePlayerRadioButton.setText("1 P");
        onePlayerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onePlayerRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(twoPlayersRadioButton);
        twoPlayersRadioButton.setText("2 P");
        twoPlayersRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoPlayersRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(fiveHolesRadioButton);
        fiveHolesRadioButton.setText("5");
        fiveHolesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveHolesRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(sevenHolesRadioButton);
        sevenHolesRadioButton.setText("7");
        sevenHolesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenHolesRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(ninesHolesRadioButton);
        ninesHolesRadioButton.setText("9");
        ninesHolesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ninesHolesRadioButtonActionPerformed(evt);
            }
        });

        numOfRockTextField.setText("7");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Jumlah Pemain");

        jButton1.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jButton1.setText("Tentang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numOfRockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fiveHolesRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sevenHolesRadioButton))
                                    .addComponent(twoPlayersRadioButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(onePlayerRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ninesHolesRadioButton)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(twoPlayersRadioButton)
                    .addComponent(onePlayerRadioButton))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fiveHolesRadioButton)
                    .addComponent(sevenHolesRadioButton)
                    .addComponent(ninesHolesRadioButton))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(numOfRockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void onePlayerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onePlayerRadioButtonActionPerformed
        numOfPlayers = 1;
    }//GEN-LAST:event_onePlayerRadioButtonActionPerformed

    private void sevenHolesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenHolesRadioButtonActionPerformed
        numOfHoles = 7;
        numOfRockTextField.setText("7");
    }//GEN-LAST:event_sevenHolesRadioButtonActionPerformed

    private void twoPlayersRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoPlayersRadioButtonActionPerformed
        numOfPlayers = 2;
    }//GEN-LAST:event_twoPlayersRadioButtonActionPerformed

    private void ninesHolesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ninesHolesRadioButtonActionPerformed
        numOfHoles = 9;
        numOfRockTextField.setText("9");
    }//GEN-LAST:event_ninesHolesRadioButtonActionPerformed

    private void fiveHolesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveHolesRadioButtonActionPerformed
        numOfHoles = 5;
        numOfRockTextField.setText("5");
    }//GEN-LAST:event_fiveHolesRadioButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        aboutPanel.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * Inner Kelas untuk membatasi jumlah inputan dalam TextField
     * Copas dari StackOverflow :3
     */
    private final class LengthRestrictedDocument extends PlainDocument {

        private final int limit;

         public LengthRestrictedDocument(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
          if (str == null)
            return;

          if ((getLength() + str.length()) <= limit) {
            super.insertString(offs, str, a);
          }
        }
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton fiveHolesRadioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton ninesHolesRadioButton;
    private javax.swing.JTextField numOfRockTextField;
    private javax.swing.JRadioButton onePlayerRadioButton;
    private javax.swing.JRadioButton sevenHolesRadioButton;
    private javax.swing.JButton startButton;
    private javax.swing.JRadioButton twoPlayersRadioButton;
    // End of variables declaration//GEN-END:variables
}