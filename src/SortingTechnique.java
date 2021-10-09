import java.util.ArrayList;
import java.util.List;

public class SortingTechnique extends ShapeFactory {
	
	ShapeFactory temp;

	/**
	 * This is an empty constructor.
	 */
	public SortingTechnique() {
		
	}
	
	/**
	 * Bubble-sort the six existing shapes based on their surface values. 
	 * 
	 * @param list the list of six shapes drawn on the canvas
	 * 
	 */
	public <E extends Comparable <? super E>> void sort(List<Shape> list) {
		for (int i = 0; i < 6; i++) {
			for (int j = 1; j < 6 - i; j++) {
				if (list.get(j - 1).compareTo(list.get(j)) >= 1) {
					temp = (ShapeFactory) list.get(j - 1);
					list.set(j - 1, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
}
