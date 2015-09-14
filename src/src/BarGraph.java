package src;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarGraph extends Main{
    private JTextField numbers[]=new JTextField[4];
    private JLabel labels[]=new JLabel[4];
    private JPanel panel;
    private int g1=0,g2=0,g3=0,g4=0;
    public BarGraph()
    {
        for(int i=0;i<4;i++)
        {
            numbers[i]=new JTextField();
            labels[i]=new JLabel();
            numbers[i].setVisible(false);
            labels[i].setVisible(false);
        }
        numbers[0].setBounds(50,300,150,30);
        numbers[1].setBounds(250,300,150,30);
        numbers[2].setBounds(450,300,150,30);
        numbers[3].setBounds(250,350,150,30);
        panel=new JPanel(){
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.clearRect(0,0,panel.getWidth(),panel.getHeight());
                g.setColor(Color.WHITE);
                g.fillRect(0,0,panel.getWidth(),panel.getHeight());
                g.setColor(Color.GREEN);
                g.fillRect(0,0,78,g1);
                g.setColor(Color.BLUE);
                g.fillRect(78*2,0,78,g2);
                g.setColor(Color.RED);
                g.fillRect(78*4,0,78,g3);
                g.setColor(Color.YELLOW);
                g.fillRect(78*6,0,78,g4);
                g.setColor(Color.BLACK);
                g.drawString(g1+"",10,100);
                g.drawString(g2+"",78+78+10,100);
                g.drawString(g3+"",78*4+10,100);
                g.drawString(g4+"",78*6+10,100);
                try
                {
                    g1=Integer.valueOf(numbers[0].getText());
                }
                catch(NumberFormatException ex){numbers[0].setText("0");}
                try
                {
                    g2=Integer.valueOf(numbers[1].getText());
                }
                catch(NumberFormatException ex){numbers[1].setText("0");}
                try
                {
                    g3=Integer.valueOf(numbers[2].getText());
                }
                catch(NumberFormatException ex){numbers[2].setText("0");}
                try
                {
                    g4=Integer.valueOf(numbers[3].getText());
                }
                catch(NumberFormatException ex){numbers[3].setText("0");};
                repaint();
            }
        };
        panel.setVisible(false);
        panel.setBounds(5,50,625,200);
        for(int i=0;i<4;i++)
        {
            frame.add(numbers[i]);
            frame.add(labels[i]);
        }
        frame.add(panel);
    }
    public void visible(boolean tf)
    {
        if(tf)
        {
            backButton.setVisible(true);
            frame.setTitle("Lesson 2 - Bar Graph");
            frame.setSize(640,640);
        }
        else
        {
            backButton.setVisible(false);
        }
        for(int i=0;i<4;i++)
        {
            numbers[i].setVisible(tf);
            labels[i].setVisible(tf);
        }
        panel.setVisible(tf);
    }
}
