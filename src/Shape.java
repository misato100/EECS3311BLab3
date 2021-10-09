import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Shape <E extends Comparable<E>> extends JPanel implements ActionListener {
	
	private boolean loaded = false;
	private boolean sorted = false;
	
	private JFrame frame;
	private JPanel panel;
	private JButton loadBtn, sortBtn;
	static int xValue = -1;
	List<E> shapes = new ArrayList<E>(3);
	protected static List<Shape> list = new ArrayList<Shape>();
	
	/**
	 * This is the default constructor that sets up the canvas.
	 */
	public Shape() {
		frame = new JFrame("Display shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// The size of window
		frame.setSize(600, 600); 
		// Create a panel
		panel = new JPanel();
//		panel.setBackground(Color.green);
		// Create a load-shapes-button
		loadBtn = new JButton("Load shapes");
		loadBtn.setBounds(50, 100, 80, 30);
		// Create a sort-shapes-button
		sortBtn = new JButton("Sort shapes");
		sortBtn.setBounds(100, 100, 80, 30);
	}
	
	/**
	 * Add a shape to list.
	 * Clear all the elements of the list when it reaches 6.
	 * 
	 * @param shape the shape to add
	 * 
	 */
	public void addElem(ShapeFactory shape) {
		if (list.size() == 6) list.clear();
		list.add(shape);
	}
	
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.setBtn();
	}
	
	/**
	 * Set two buttons on the canvas.
	 * 
	 */
	public void setBtn() {
		panel.add(loadBtn);
		panel.add(sortBtn);
		frame.add(panel, BorderLayout.PAGE_START);
		frame.setVisible(true);
		
		if (loaded == false) {
			loadBtn.addActionListener(this);
			sortBtn.addActionListener(this);
		}
	}
	
	/**
	 * Make actions when a button is clicked.
	 * 
	 * @param e action
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		loaded = true;
		if (e.getSource() == loadBtn) { // Load button is clicked
			if (loaded == true) {
				frame.getContentPane().removeAll();
				frame.repaint();
				setBtn();
			}
			ShapeFactory sf = new ShapeFactory();
			for (int i = 1; i <= 6; i++) {
				frame.add(sf.randomShape());
				frame.setVisible(true);
			}
			sorted = false;
		} else if (e.getSource() == sortBtn) { // Sort button is clicked
			if (sorted == false) {
				int val = 0;
				SortingTechnique st = new SortingTechnique();
				st.sort(list);
				frame.getContentPane().removeAll();
				frame.repaint();
				setBtn();
				for (int j = 0; j <= 5; j++) {
					if (list.get(j) instanceof Circle) {
						frame.add(new Circle(((Circle) list.get(j)), val, 200));
					} else if (list.get(j) instanceof Rectangle) {
						frame.add(new Rectangle(((Rectangle) list.get(j)), val, 200));
					} else {
						frame.add(new Square(((Square) list.get(j)), val, 200));
					}
					frame.setVisible(true);
					val = val + 100;
				}
				sorted = true;
			}
		}
	}
	
	/**
	 * Get the surface value.
	 * 
	 * @return 0
	 * 
	 */
	public double getSurface() {
		return 0;
	}
	
	/**
	 * Compare the surface value of shapes.
	 * 
	 * @param shape a shape
	 * @return 1 if the current surface value is bigger and -1 if it's less.
	 * 
	 */
	public int compareTo(Shape shape) {
		return this.getSurface() >= shape.getSurface() ? 1 : -1;
	}
}
