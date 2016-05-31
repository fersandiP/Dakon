/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JButton;

/**
 * Frame utama game Dakon
 * @author Fersandi Pratama
 */
public class DakonFrame extends javax.swing.JFrame {
    
//    private static final FRAME_WI
    private static final int START_PANEL_WIDTH  = 330;
    private static final int START_PANEL_HEIGHT = 330;
    private static final int DAKON_PANEL_WIDTH  = 1000;
    private static final int DAKON_PANEL_HEIGHT = 600;
    
    
    /**
     * Creates new form DakonFrame
     */
    public DakonFrame() {
        initComponents();
        initComponentUser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startPanel = new StartPanel();
        dakonPanel = new DakonPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(startPanel);
        startPanel.setBounds(0, 0, 533, 466);
        getContentPane().add(dakonPanel);
        dakonPanel.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * User defined initialize Dakon Frame
     */
    private void initComponentUser(){
        setTitle("Dakon");
        setResizable(false);
        setSize(START_PANEL_WIDTH, START_PANEL_HEIGHT);
        
        dakonPanel.setVisible(false);
               
        startButton = startPanel.getStartButton();
        
        
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed();
            }
        });
        
    }
    
    private void startButtonActionPerformed(){
        int numOfRocks = startPanel.getNumOfRocks();
        int numOfPlayers = startPanel.getNumOfPlayers();
        int numOfHoles = startPanel.getNumOfHoles();
        
        dakonPanel.startGame(numOfHoles, numOfPlayers, numOfRocks);
        
        endButton   = dakonPanel.getEndButton();
        
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed();
            }
        });
        
        setSize(DAKON_PANEL_WIDTH, DAKON_PANEL_HEIGHT);
        startPanel.setVisible(false);
        dakonPanel.setVisible(true);
    }
    
    private void endButtonActionPerformed(){
        setSize(START_PANEL_WIDTH, START_PANEL_HEIGHT);
        dakonPanel.resetPanel();
        startPanel.setVisible(true);
        dakonPanel.setVisible(false);
    }
    
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
            java.util.logging.Logger.getLogger(DakonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DakonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DakonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DakonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DakonFrame().setVisible(true);
            }
        });
    }
    
    //User Variables declaration
    private JButton startButton;
    private JButton endButton;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DakonPanel dakonPanel;
    private StartPanel startPanel;
    // End of variables declaration//GEN-END:variables
}
