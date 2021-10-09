import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 30 between each shape
public class ShapeFactory extends Shape {
	
	int yValue = 200;
	
	/**
	 * Create random shapes with random x value and set y value.
	 * 
	 * @return a random shape
	 * 
	 */
	public Shape randomShape() {
		shapes.clear();
		if (xValue < 0) {
			xValue = 0;
		} else if (xValue < 500) {
			xValue = xValue + 100;
		} else {
			xValue = 0;
		}
		
		shapes.add(new Circle(xValue, yValue));
		shapes.add(new Rectangle(xValue, yValue));
		shapes.add(new Square(xValue, yValue));
		
		Shape elem = new Shape();
		elem = (Shape) shapes.get(new Random().nextInt(shapes.size()));
		this.addElem((ShapeFactory) elem);
		return elem;
	}
}
