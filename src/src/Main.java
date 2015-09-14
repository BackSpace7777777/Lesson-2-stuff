package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
    public static JFrame frame=new JFrame("Lesson 2 - Menu");
    public static JButton momentum,pizza,makeLine,barGraph,circle,backButton;
    public static Momentum mo;
    public static Pizza pi;
    public static MakeLine ml;
    public static BarGraph bg;
    public static void main(String[] args) 
    {
        frame.setSize(475,200);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.setResizable(false);
        momentum=new JButton();
        momentum.setText("Momentum");
        momentum.setBounds(5,5,150,30);
        momentum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mo.visible(true);
                mainVisible(false);
            }
        });
        pizza=new JButton();
        pizza.setText("Pizza");
        pizza.setBounds(160,5,150,30);
        pizza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pi.visible(true);
                mainVisible(false);
            }
        });
        makeLine=new JButton();
        makeLine.setText("Make a Line");
        makeLine.setBounds(315,5,150,30);
        makeLine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ml.visible(true);
                mainVisible(false);
            }
        });
        barGraph=new JButton();
        barGraph.setText("Bar Graph");
        barGraph.setBounds(5,40,150,30);
        barGraph.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainVisible(false);
                bg.visible(true);
            }
        });
        circle=new JButton();
        circle.setText("Bonus Circle");
        circle.setBounds(315,40,150,30);
        backButton=new JButton();
        backButton.setText("Main Menu");
        backButton.setBounds(5,5,150,30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainVisible(true);
                mo.visible(false);
                pi.visible(false);
                ml.visible(false);
                bg.visible(false);
                frame.setSize(475,200);
                frame.setTitle("Lesson 2 - Menu");
            }
        });
        backButton.setVisible(false);
        pi=new Pizza();
        mo=new Momentum();
        ml=new MakeLine();
        bg=new BarGraph();
        frame.add(backButton);
        //frame.add(circle);
        frame.add(barGraph);
        frame.add(makeLine);
        frame.add(pizza);
        frame.add(momentum);
        frame.setVisible(true);
    }
    public static void mainVisible(boolean tf)
    {
        circle.setVisible(tf);
        barGraph.setVisible(tf);
        makeLine.setVisible(tf);
        pizza.setVisible(tf);
        momentum.setVisible(tf);
    }
}
