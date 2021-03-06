package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MakeLine extends Main{
    private JPanel panel;
    private JTextField x1,y1,x2,y2;
    private JLabel xy[]=new JLabel[4];
    private JCheckBox useMouse;
    private int mx,my,ix1=-10,ix2=-10,iy1=-10,iy2=-10;
    private boolean mousePos1=false,mousePos2=false,usePos=false;
    public MakeLine()
    {
        for(int i=0;i<xy.length;i++)
        {
            xy[i]=new JLabel();
            xy[i].setVisible(false);
        }
        xy[0].setText("X1:");
        xy[0].setBounds(640/2-180,460,20,30);
        xy[1].setText("X2:");
        xy[1].setBounds(640/2-180,500,20,30);
        xy[2].setText("Y1:");
        xy[2].setBounds(640/2-9,460,20,30);
        xy[3].setText("Y2:");
        xy[3].setBounds(640/2-9,500,20,30);
        x1=new JTextField();
        x1.setBounds(640/2-160,460,150,30);
        x1.setVisible(false);
        x2=new JTextField();
        x2.setBounds(640/2-160,500,150,30);
        x2.setVisible(false);
        y1=new JTextField();
        y1.setBounds(640/2+10,460,150,30);
        y1.setVisible(false);
        y2=new JTextField();
        y2.setBounds(640/2+10,500,150,30);
        y2.setVisible(false);
        panel=new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.clearRect(0,0,panel.getWidth(),panel.getHeight());
                g.setColor(Color.GRAY);
                g.fillRect(0,0,panel.getWidth(),panel.getHeight()); 
                g.setColor(Color.WHITE);
                g.drawLine(ix1,iy1,ix2,iy2);
                g.setColor(Color.GREEN);
                g.drawString("(x:" + ix1 + ",y:" + iy1 + ")",ix1,iy1);
                g.drawString("(x:" + ix2 + ",y:" + iy2 + ")",ix2,iy2);
                repaint();
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e) && useMouse.isSelected())
                {
                    ix1=e.getX();
                    iy1=e.getY();
                }
                else if(SwingUtilities.isRightMouseButton(e) && useMouse.isSelected())
                {
                    ix2=e.getX();
                    iy2=e.getY();
                }
            }
        });
        panel.setVisible(false);
        panel.setBounds((640/2)-200,40,400,400);
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                mx=e.getX();
                my=e.getY();
            }
        });
        useMouse=new JCheckBox();
        useMouse.setVisible(false);
        useMouse.setText("Use Mouse");
        useMouse.setBounds(160,5,150,30);
        frame.add(useMouse);
        frame.add(x1);
        frame.add(panel);
        frame.add(y1);
        frame.add(x2);
        frame.add(y2);
        for (JLabel xy1 : xy) {
            frame.add(xy1);
        }
        Thread checkCoords=new Thread(new Runnable() {
            public void run() {
                while(true)
                {
                    try
                    {
                        if(useMouse.isSelected())
                        {
                            x1.setText("" + ix1);
                            x2.setText("" + ix2);
                            y1.setText("" + iy1);
                            y2.setText("" + iy2);
                        }
                        else
                        {
                            ix1=Integer.valueOf(x1.getText());
                            ix2=Integer.valueOf(x2.getText());
                            iy1=Integer.valueOf(y1.getText());
                            iy2=Integer.valueOf(y2.getText());
                        }
                        Thread.sleep(16);
                    }catch(Exception ex){}
                }
            }
        });
        checkCoords.start();
    }
    public void visible(boolean tf)
    {
        if(tf==true)
        {
            backButton.setVisible(true);
            frame.setSize(640,640);
            frame.setTitle("Lesson 2 - Make a Line");
            x1.setText("");
            x2.setText("");
            y1.setText("");
            y2.setText("");
            ix1=-10;
            ix2=-10;
            iy1=-10;
            iy2=-10;
        }
        else
        {
            backButton.setVisible(false);
        }
        for (JLabel xy1 : xy) {
            xy1.setVisible(tf);
        }
        useMouse.setVisible(tf);
        panel.setVisible(tf);
        x1.setVisible(tf);
        x2.setVisible(tf);
        y1.setVisible(tf);
        y2.setVisible(tf);
    }
}
