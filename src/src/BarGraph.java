package src;
public class BarGraph extends Main{
    public BarGraph()
    {
        
    }
    public void visible(boolean tf)
    {
        if(tf)
        {
            backButton.setVisible(true);
            frame.setTitle("Lesson 2 - Bar Graph");
        }
        else
        {
            backButton.setVisible(false);
        }
    }
}
