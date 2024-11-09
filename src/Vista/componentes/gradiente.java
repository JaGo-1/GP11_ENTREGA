
package Vista.componentes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class gradiente extends JPanel{
    public gradiente(){
         setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#2FC102"), getWidth(), 0, Color.decode("#46D8E2"));
        g2.setPaint(gp);
        g2.fillRoundRect(0,0,getWidth(),getHeight(),20,20);
        super.paintComponent(g); 
    }
}
