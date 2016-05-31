/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JButton;
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author Fersandi Pratama
 */
public class HoleButton extends JButton{
    private static final int CIRCLE_RADIUS = 80;
    
    public static final int ONMOUSE   = 1;
    public static final int ONNORMAL  = 0;
    public static final int ONCHANGE  = 2;
    public static final int ONCHANGEP1 = 3;
    public static final int ONCHANGEP2 = 4;
    
    private int state;
    private boolean isScoreHole;
    
    public HoleButton(){
        this("0000");
        isScoreHole = false;
        state = 0;
        prepareEvent();
    }
    
    public void setScoreHole(){
        isScoreHole = true;
    }
    
    private void prepareEvent(){
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeState(ONMOUSE);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changeState(ONNORMAL);
            }
            
        });

    }
    
    public void changeState(int state){
        if (isScoreHole && state != ONCHANGE && state != ONNORMAL
                && state != ONCHANGEP1 && state != ONCHANGEP2) return;
        
        this.state = state;
        repaint();
    }
    
    public HoleButton(String label) {
        super(label);
        Dimension size = getPreferredSize();
        size.width = size.height = CIRCLE_RADIUS;
        setPreferredSize(size);

        setContentAreaFilled(false);
        setFont(new java.awt.Font("Felix Titling", 1, 20));
    }
    
  @Override
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
      if (!isScoreHole) g.setColor(Color.GRAY);
      else g.setColor(Color.WHITE);
    } else {
      switch(state){
          case ONMOUSE:
              g.setColor(Color.LIGHT_GRAY);
              break;
          case ONNORMAL:
              g.setColor(Color.WHITE);
              break;
          case ONCHANGE:
              g.setColor(Color.DARK_GRAY);
              break;
          case ONCHANGEP1:
              g.setColor(Color.RED);
              break;
          case ONCHANGEP2:
              g.setColor(Color.BLUE);
              break;
      }
    }
    g.fillOval(0, 0, getSize().width-1,getSize().height-1);

    super.paintComponent(g);
  }
  
//  @Override
//  protected void paintBorder(Graphics g) {
//    g.setColor(getForeground());
//    g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
//  }

  Shape shape;
  @Override
  public boolean contains(int x, int y) {
    if (shape == null || 
      !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }
}
