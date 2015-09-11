package src;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Pizza extends Main{
    private JLabel tL;
    private JCheckBox[] toppings=new JCheckBox[4];
    private JTextField totalPrice,diameter;
    public Pizza()
    {
        tL=new JLabel();
        tL.setText("Toppings");
        tL.setBounds(5,35,150,30);
        tL.setVisible(false);
        diameter=new JTextField();
        diameter.setBounds(160,5,150,30);
        diameter.setVisible(false);
        diameter.setText("Enter the diameter(inches)");
        totalPrice=new JTextField();
        totalPrice.setBounds(315,5,150,30);
        totalPrice.setEditable(false);
        totalPrice.setVisible(false);
        for(int i=0;i<toppings.length;i++)
            toppings[i]=new JCheckBox();
        toppings[0].setText("Pepperoni");
        toppings[0].setBounds(5,60,150,30);
        toppings[1].setText("Mushrooms");
        toppings[1].setBounds(5,90,150,30);
        toppings[2].setText("Bacon");
        toppings[2].setBounds(155,60,150,30);
        toppings[3].setText("Peppers");
        toppings[3].setBounds(155,90,150,30);
        for(int i=0;i<toppings.length;i++)
        {
            toppings[i].setVisible(false);
            frame.add(toppings[i]);
        }
        frame.add(totalPrice);
        frame.add(tL);
        frame.add(diameter);
        Thread priceCalc=new Thread(new Runnable() {
            public void run() {
                int topping=0;
                while(true)
                {
                    for(int i=0;i<toppings.length;i++)
                    {
                        if(toppings[i].isSelected())
                            topping++;
                    }
                    try
                    {
                        totalPrice.setText("The price is $" + (1.5+0.75+(0.75*topping)+(Double.valueOf(diameter.getText())*0.5)));
                    }
                    catch(Exception ex){}
                    topping=0;
                }
            }
        });
        priceCalc.start();
    }
    public void visible(boolean tf)
    {
        if(tf==true)
        {
            backButton.setVisible(true);
            frame.setTitle("Lesson 2 - Pizza");
            diameter.setText("Enter the diameter(inches)");
            for(int i=0;i<toppings.length;i++)
            {
                toppings[i].setSelected(false);
            }
        }
        else
        {
            backButton.setVisible(false);
        }
        for(int i=0;i<toppings.length;i++)
            toppings[i].setVisible(tf);
        tL.setVisible(tf);
        totalPrice.setVisible(tf);
        diameter.setVisible(tf);
    }
}
