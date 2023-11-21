package oneSTI;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
	
	public boolean isOver() {
        return over;
    }
  
    public void setOver(boolean over) {
        this.over = over;
    }
   
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }
    
    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClicked() {
        return colorClicked;
    }

    public void setColorClicked(Color colorClicked) {
        this.colorClicked = colorClicked;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public Button() {
        
        setColor(Color.WHITE);
        colorOver = new Color(149, 61, 0);
        colorClicked = new Color(255, 185, 137);
        borderColor = new Color(255, 103, 0 );
        this.setContentAreaFilled(false);
    }
    
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClicked;
    private Color borderColor;
    private int radius = 0;
    
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        // Border set 2 pixel
        g2.fillRoundRect(2, 2, getWidth()-4, getHeight()-4, radius, radius);
        super.paintComponent(grphcs);
    }
}
