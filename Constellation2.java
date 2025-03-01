import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Constellation2 
{
	public void Constellation2()
	{
	
	}
	
    public static void main (String[] args) 
    {
        Constellation2 c = new Constellation2();
        c.runIt();
    }

    public void runIt()
    {
        JFrame frame = new JFrame("The Big Dipper");
        frame.setSize(620, 460); 
        frame.setLocation(900, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        DipperPanel mpPanel = new DipperPanel();
        frame.getContentPane().add(mpPanel);
        frame.setVisible(true);
    }
}

class DipperPanel extends JPanel 
{
    public DipperPanel() 
    {
        setBackground(Color.BLUE);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x = 0, y = -157;
        for (int count = 0; count < 16; count++) 
        {
            if (count % 4 == 0 && count != 0) 
            {
                x += 152;
                y = -157;
            }
            
            y += 157;

            drawText(g, x, y);
            drawMoon(g, x, y);
            drawDipper(g, x, y);
            drawPlanet(g, x, y);
            drawRocket(g, x, y);
        }
    }

    public void drawText(Graphics g, int x, int y) 
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.ITALIC, 10)); 
        g.drawString("The Big Dipper", x + 42, y + 20);
        g.drawRect(x + 40, y + 10, 68, 16); 
    }

    public void drawMoon(Graphics g, int x, int y) 
    {
        g.setColor(new Color(255, 255, 0));
        g.fillOval(x, y, 28, 28); 
        g.setColor(Color.BLUE);
        g.fillOval(x - 5, y - 5, 28, 28);
    }

    public void drawDipper(Graphics g, int x, int y) 
    {
        g.setColor(Color.WHITE);
        int[] X = {x + 10, x + 43, x + 55, x + 90, x + 135, x + 140, x + 100, x + 90, x + 55, x + 43, x + 10};
        int[] Y = {y + 55, y + 45, y + 50, y + 55, y + 35, y + 60, y + 75, y + 55, y + 50, y + 45, y + 55};
        g.drawPolygon(X, Y, 11);

        g.fillOval(x + 9, y + 54, 2, 2);
        g.fillOval(x + 41, y + 44, 2, 2);
        g.fillOval(x + 54, y + 49, 2, 2);
        g.fillOval(x + 89, y + 54, 2, 2);
        g.fillOval(x + 134, y + 34, 2, 2);
        g.fillOval(x + 139, y + 59, 2, 2);
        g.fillOval(x + 99, y + 74, 2, 2);
    }

    public void drawPlanet(Graphics g, int x, int y) 
    {
        g.setColor(new Color(139, 69, 19));
        g.fillArc(x - 18, y + 93, 200, 50, 0, 180);
    }

    public void drawRocket(Graphics g, int x, int y) 
    {
        g.setColor(Color.RED);
        int[] rocketX = {x + 15, x + 28, x + 35, x + 30, x + 19};
        int[] rocketY = {y + 86, y + 83, y + 86, y + 93, y + 95};
        g.drawPolygon(rocketX, rocketY, 5);

        int[] flameX1 = {x + 9, x + 15, x + 10};
        int[] flameY1 = {y + 90, y + 89, y + 93};
        g.fillPolygon(flameX1, flameY1, 3);

        int[] flameX2 = {x + 11, x + 18, x + 12};
        int[] flameY2 = {y + 95, y + 94, y + 98};
        g.fillPolygon(flameX2, flameY2, 3);

        g.drawArc(x + 5, y + 81, 170, 50, -5, 135); 
    }
}
