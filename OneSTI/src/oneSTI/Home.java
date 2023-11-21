
package oneSTI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        
        
        button1.addMouseListener(new MouseAdapter(){
            
            public void mouseEntered(MouseEvent e) {
                button1.setBackground(new Color(194, 98, 31));
                button1.setForeground(Color.WHITE);
            }
            
            public void mouseExited(MouseEvent e) {
                button1.setBackground(Color.WHITE);
                button1.setForeground(Color.BLACK);
            }
            
        });
     
    }
                    
    private void initComponents() {

        button1 = new oneSTI.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        button1.setText("button1");
        button1.setBorderPainted(false);
        button1.setFocusable(false);
        button1.setRadius(30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(345, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        pack();
    }                       

   
    public static void main(String args[]) {
        
        Home obj = new Home();
        obj.setLocationRelativeTo(null);
        obj.setBackground(Color.WHITE);
        obj.setVisible(true);
        
    }

    // Variables declaration - do not modify                     
    private oneSTI.Button button1;
    // End of variables declaration                   
}
