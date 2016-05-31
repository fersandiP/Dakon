/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.event.*;

/**
 *
 * @author Fersandi Pratama
 */
public class DakonPanel7Holes extends javax.swing.JPanel {
    
    //Constant declaration
    private static final int TIMER_DELAY = 500;
    
    //Before-Game declaration
    private HoleButton[] holes;
    private int numOfHoles;
    private int numOfPlayers;
    private int numOfRocks;
    
    //In-game declaration
    private Dakon game;
    private State state;
    private Timer timer;
    
    //helper declaration
    private int buttonClicked;

    /**
     * Creates new form DakonPanel
     */
    public DakonPanel7Holes(int numOfHoles, int numOfPlayers, int numOfRocks) {
        this.numOfHoles   = numOfHoles;
        this.numOfPlayers = numOfPlayers;
        this.numOfRocks   = numOfRocks;
        
        initComponents();
        initComponentUser();
        
        setAllSettings();
    }
    
    public DakonPanel7Holes(){
        this(0,0,0);
    }
    
    public void setAllSettings(){
        
       game.init(numOfHoles, numOfRocks);
       
       prepareTimer();
        
       setAllHoles();
       changeAllButtonState(0, true);
       
        endButton.setVisible(false);
        beforeTurn();
    }
    
    private void initComponentUser(){
        HoleButton[] holes = {holeButton0, holeButton1, holeButton2, holeButton3, holeButton4,
                           holeButton5, holeButton6, scoreButtonP1, holeButton7, holeButton8, 
                           holeButton9, holeButton10, holeButton11, holeButton12, holeButton13,
                            scoreButtonP2};
        
        scoreButtonP1.setScoreHole();
        scoreButtonP2.setScoreHole();
        
        game = new Dakon();
        this.holes = holes;
        
        
    }
    
    private void setAllHoles(){
        for (JButton hole : holes){
            hole.setText("" + numOfRocks);
        }
        
        holes[7].setText("0");
        holes[15].setText("0");
    }
    
    /**
     * Mengubah semua button menjadi disable/enable
     * @param which 0 semua, 1 button pemain pertama, 2 button pemain kedua
     * @param state disable/enable
     */
    private void changeAllButtonState(int which, boolean state){
        int i = 0; //Awal
        int j = numOfHoles*2+2; //Akhir
        
        switch(which){
            case 1:
                j = numOfHoles;
                break;
            case 2:
                i = numOfHoles+1;
                j--;
                break;
        }
        
        for (; i < j; i++){
            holes[i].setEnabled(state);
        }
        
        //check whether the hole is zero
        for (JButton hole : holes){
            if (hole.getText().equals("0"))
                hole.setEnabled(false);
        }
    }
    
    /**
     * Method untuk menyiapkan mekanisme game dan GUI sebelum giliran pemain
     */
    private void beforeTurn(){
        int player = game.getCurrentPlayer();
        
        //Run AI
        if (player == 2 && numOfPlayers == 1){
            holeAction(null);
            return;
        }
        
        if (player == 1){
            statusLabel.setText("Giliran pemain pertama");
            changeAllButtonState(2,false);
        } else {
            statusLabel.setText("Giliran pemain kedua");
            changeAllButtonState(1,false);
        }
    }
    
    /**
     * Method yang akan dipanggil setelah giliran selesai
     */
    private void postTurn(){
        changeAllButtonState(0, true);
        for (HoleButton hole : holes){
            hole.changeState(HoleButton.ONNORMAL);
        }
        
    }
    
    private void updateHole(){
        for (int i = 0, ii = numOfHoles*2+2; i < ii; i++){
            if (!holes[i].getText().equals("" + state.getHole(i))){
                holes[i].changeState(game.getCurrentPlayer() == 1 ? 
                        HoleButton.ONCHANGEP1 : HoleButton.ONCHANGEP2);
            } else {
                holes[i].changeState(HoleButton.ONNORMAL);
            }
            holes[i].setText("" + state.getHole(i));
            statusLabel.setText("Di tangan : " + state.getInHand());
        }
    }
    
    /**
     * Menyiapkan Timer event untuk hadling animasi per turn
     */
    private void prepareTimer(){
        class TimerListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                if (state.move() >= 0){
                    updateHole();
                } else {
                    timer.stop();
                    afterTimer();
                }
            }
        }
        
        timer = new Timer(TIMER_DELAY, new TimerListener());
    }
    
    private void endGame(){
        endButton.setVisible(true);
        changeAllButtonState(0,false);
        
        if (state.getHole(numOfHoles) > state.getHole(numOfHoles*2+1)){
            statusLabel.setText("Pemain 1 Menang!");
        } else if (state.getHole(numOfHoles) < state.getHole(numOfHoles*2+1)){
            if (numOfPlayers == 1){
                statusLabel.setText("Komputer Menang!");
            }  else  {
                statusLabel.setText("Pemain 2 menang!");
            }
        } else {
            statusLabel.setText("Seri !");
        }
    }
    
    private void afterTimer(){
        postTurn();
        if (state.isEndGame()){
            endGame();
            return;
        }
        beforeTurn();
    }
    
    public JButton getEndButton(){
        return endButton;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        holeButton0 = new HoleButton();
        holeButton2 = new HoleButton();
        holeButton3 = new HoleButton();
        holeButton4 = new HoleButton();
        holeButton5 = new HoleButton();
        holeButton1 = new HoleButton();
        scoreButtonP1 = new HoleButton();
        holeButton6 = new HoleButton();
        scoreButtonP2 = new HoleButton();
        holeButton10 = new HoleButton();
        holeButton11 = new HoleButton();
        holeButton12 = new HoleButton();
        holeButton13 = new HoleButton();
        holeButton9 = new HoleButton();
        holeButton8 = new HoleButton();
        holeButton7 = new HoleButton();
        statusLabel = new javax.swing.JLabel();
        endButton = new javax.swing.JButton();

        setDoubleBuffered(false);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(null);

        holeButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 0;
                holeAction(evt);
            }
        });
        add(holeButton0);
        holeButton0.setBounds(160, 360, 80, 80);

        holeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 2;
                holeAction(evt);
            }
        });
        add(holeButton2);
        holeButton2.setBounds(357, 360, 80, 80);

        holeButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 3;
                holeAction(evt);
            }
        });
        add(holeButton3);
        holeButton3.setBounds(455, 360, 80, 80);

        holeButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 4;
                holeAction(evt);
            }
        });
        add(holeButton4);
        holeButton4.setBounds(553, 360, 80, 80);

        holeButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 5;
                holeAction(evt);
            }
        });
        add(holeButton5);
        holeButton5.setBounds(651, 360, 80, 80);

        holeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 1;
                holeAction(evt);
            }
        });
        add(holeButton1);
        holeButton1.setBounds(259, 360, 80, 80);
        add(scoreButtonP1);
        scoreButtonP1.setBounds(823, 255, 110, 110);

        holeButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 6;
                holeAction(evt);
            }
        });
        add(holeButton6);
        holeButton6.setBounds(737, 360, 80, 80);
        add(scoreButtonP2);
        scoreButtonP2.setBounds(45, 255, 110, 110);

        holeButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 11;
                holeAction(evt);
            }
        });
        add(holeButton10);
        holeButton10.setBounds(455, 168, 80, 80);

        holeButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 12;
                holeAction(evt);
            }
        });
        add(holeButton11);
        holeButton11.setBounds(357, 168, 80, 80);

        holeButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 13;
                holeAction(evt);
            }
        });
        add(holeButton12);
        holeButton12.setBounds(259, 168, 80, 80);

        holeButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 14;
                holeAction(evt);
            }
        });
        add(holeButton13);
        holeButton13.setBounds(161, 168, 80, 80);

        holeButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 10;
                holeAction(evt);
            }
        });
        add(holeButton9);
        holeButton9.setBounds(553, 168, 80, 80);

        holeButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 9;
                holeAction(evt);
            }
        });
        add(holeButton8);
        holeButton8.setBounds(651, 168, 80, 80);

        holeButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked = 8;
                holeAction(evt);
            }
        });
        add(holeButton7);
        holeButton7.setBounds(737, 168, 80, 80);

        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText("AMPAS");
        statusLabel.setFocusable(false);
        statusLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(statusLabel);
        statusLabel.setBounds(270, 260, 460, 80);

        endButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        endButton.setText("Mulai Baru");
        endButton.setToolTipText("");
        endButton.setFocusable(false);
        add(endButton);
        endButton.setBounds(410, 470, 170, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void holeAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holeAction
        state = (evt != null) ? game.move(buttonClicked) : game.move();
        System.out.println(buttonClicked);
        updateHole();
        
        changeAllButtonState(0, false);
        timer.start();
    }//GEN-LAST:event_holeAction


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endButton;
    private HoleButton holeButton0;
    private HoleButton holeButton1;
    private HoleButton holeButton10;
    private HoleButton holeButton11;
    private HoleButton holeButton12;
    private HoleButton holeButton13;
    private HoleButton holeButton2;
    private HoleButton holeButton3;
    private HoleButton holeButton4;
    private HoleButton holeButton5;
    private HoleButton holeButton6;
    private HoleButton holeButton7;
    private HoleButton holeButton8;
    private HoleButton holeButton9;
    private HoleButton scoreButtonP1;
    private HoleButton scoreButtonP2;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
