import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Square extends ShapeFactory implements Shapes  {
	
	private double surface;
	private float color1, color2, color3;
	private int x, y, height, width;
	Random rand = new Random();
	
	/**
	 * This is the default constructor that creates a square.
	 */
	public Square(int x, int y) {
		this.x = x;
		this.y = y;
		width = rand.nextInt(91) + 10;
		height = width;
		color1 = rand.nextFloat(); color2 = rand.nextFloat(); color3 = rand.nextFloat(); 
		surface = width * height;
	}
	
	/**
	 * This is a constructor that copies an existing square.
	 */
	public Square(Square square, int x, int y) {
		this.x = x;
		this.y = y;
		width = square.width;
		height = square.height;
		color1 = square.color1; color2 = square.color2; color3 = square.color3;
	}
	
	/**
	 * Add a square on the canvas and fill with colors.
	 * 
	 * @param g graphics
	 * 
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(color1, color2, color3));
		g2d.fillRect(x, y, width, height);	
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
