package src;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Momentum extends Main{
    private JTextField mass,velocity,answer;
    private JLabel massL,VL;
    public Momentum()
    {
        mass=new JTextField();
        mass.setVisible(false);
        mass.setBounds(5,60,150,30);
        mass.setText("");
        velocity=new JTextField();
        velocity.setVisible(false);
        velocity.setBounds(160,60,150,30);
        velocity.setText("");
        answer=new JTextField();
        answer.setVisible(false);
        answer.setBounds(5,100,150,30);
        answer.setEditable(false);
        massL=new JLabel();
        massL.setText("Mass");
        massL.setBounds(5,35,150,30); 
        massL.setVisible(false);
        VL=new JLabel();
        VL.setText("Velocity");
        VL.setBounds(160,35,150,30);
        VL.setVisible(false);
        frame.add(massL);
        frame.add(VL);
        frame.add(mass);
        frame.add(velocity);
        frame.add(answer);
        Thread updateThread=new Thread(new Runnable() {
            public void run() {
                while(true)
                {
                    try
                    {
                        if(!mass.getText().equals("") && !velocity.getText().equals(""))
                        {
                            answer.setText(""+((Double.valueOf(mass.getText()))*(Double.valueOf(velocity.getText()))));
                        }
                    }
                    catch(Exception ex){}
                }
            }
        });
        updateThread.start();
    }
    public void visible(boolean tf)
    {
        if(tf==true)
        {
            backButton.setVisible(true);
            frame.setTitle("Lesson 2 - Momentum");
        }
        else
        {
            backButton.setVisible(false);
            clearB();
        }
        massL.setVisible(tf);
        mass.setVisible(tf);
        velocity.setVisible(tf);
        VL.setVisible(tf);
        answer.setVisible(tf);
    }
    public void clearB()
    {
        velocity.setText("");
        mass.setText("");
        answer.setText("");
    }
}
