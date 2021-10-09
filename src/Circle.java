import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Circle extends ShapeFactory implements Shapes {
	
	private double surface;
	private float color1, color2, color3;
	private int x, y, width, height;
	Random rand = new Random();
	
	/**
	 * This is the default constructor that creates a circle.
	 */
	public Circle(int x, int y) {
		this.x = x;
		this.y = y;
		width = rand.nextInt(91) + 10;
		height = width;
		color1 = rand.nextFloat(); color2 = rand.nextFloat(); color3 = rand.nextFloat(); 
		surface = Math.pow(width * 0.5, 2) * Math.PI;;
	}
	
	/**
	 * This is a constructor that copies an existing circle.
	 */
	public Circle(Circle circle, int x, int y) {
		this.x = x;
		this.y = y;
		width = circle.width;
		height = circle.height;
		color1 = circle.color1; color2 = circle.color2; color3 = circle.color3;
	}
	
	/**
	 * Add a circle on the canvas and fill with colors.
	 * 
	 * @param g graphics
	 * 
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(color1, color2, color3));
		g2d.fillOval(x, y, width, height);
	}
	
	/**
	 * Get the surface value.
	 * 
	 * @return the value of surface
	 * 
	 */
	@Override
	public double getSurface() {
		return this.surface;
	}
}
