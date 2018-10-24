package view;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controler.Controler;
import model.ColorShape;
import model.Model;

public class View extends JFrame {

	private Model model = new Model(this);

	private Controler controler;

	private JPanel panel;
	private Tool currentTool;

	private List<ColorShape> shapeColorMap = new ArrayList<ColorShape>();
	private Color currentColor = Color.BLACK;
	private Vector<Shape> shapes = new Vector<Shape>();

	private Tool tools[] = fillToolsArray();

	private JToolBar toolBar = fillToolBar();

	public View() {

		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);

		add(panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, getWidth(), getHeight());

				Iterator<ColorShape> ite = shapeColorMap.iterator();
				while (ite.hasNext()) {
					ColorShape current = (ColorShape) ite.next();
					g2.setColor(current.getColor());
					g2.draw(current.getShape());
				}
			}
		});
		
		controler = new Controler(this);
		controler.addMouseListeners(this);

		add(toolBar, BorderLayout.NORTH);
		
//		List<Element> items = new ArrayList<Element>();
//		int elementSize = 50;
//		items.add(new Element("Menu1", elementSize));
//		items.add(new Element("Menu2", elementSize));
//		items.add(new Element("Menu3", elementSize));
//		items.add(new Element("Menu4", elementSize));
//		items.add(new Element("Menu5", elementSize));
//		items.add(new Element("Menu6", elementSize));
//		items.add(new Element("Menu7", elementSize));
//		items.add(new Element("Menu6", elementSize));
//		items.add(new Element("Menu7", elementSize));
//		items.add(new Element("Menu7", elementSize));
//
//		Menu menu = new Menu(300, 300, 600, 600, elementSize, 70, items);
//		add(menu, BorderLayout.CENTER);

		setLocationRelativeTo(null);
		setVisible(true);

	}

	public Model getModel() {
		return model;
	}

	public Controler getControler() {
		return controler;
	}

	public JPanel getPanel() {
		return panel;
	}

	public Tool getCurrentTool() {
		return currentTool;
	}
	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	public void setCurrentTool(Tool currentTool) {
		this.currentTool = currentTool;
	}
	
	public Tool[] getToolbar(){
		return this.tools;
	}

	private Tool[] fillToolsArray() {
		return new Tool[] { new Tool("pen", this, this.getModel()) {
			public void mouseDragged(MouseEvent e) {
				Path2D.Double path = (Path2D.Double) shape;
				if (path == null) {
					path = new Path2D.Double();
					path.moveTo(o.getX(), o.getY());
					shapeColorMap.add(new ColorShape(currentColor, path));
					shapes.add(shape = path);
				}
				path.lineTo(e.getX(), e.getY());
				panel.repaint();
			}
		}, new Tool("rect", this, this.getModel()) {
			public void mouseDragged(MouseEvent e) {
				Rectangle2D.Double rect = (Rectangle2D.Double) shape;
				if (rect == null) {
					rect = new Rectangle2D.Double(o.getX(), o.getY(), 0, 0);
					shapes.add(shape = rect);
					shapeColorMap.add(new ColorShape(currentColor, rect));
				}
				rect.setRect(min(e.getX(), o.getX()), min(e.getY(), o.getY()), abs(e.getX() - o.getX()),
						abs(e.getY() - o.getY()));
				panel.repaint();
			}
		}, new Tool("oval", this, this.getModel()) {
			public void mouseDragged(MouseEvent e) {
				Ellipse2D.Double oval = (Ellipse2D.Double) shape;
				if (oval == null) {
					oval = new Ellipse2D.Double(o.getX(), o.getY(), 0, 0);
					shapes.add(shape = oval);
					shapeColorMap.add(new ColorShape(currentColor, oval));
				}
				oval.setFrame(min(e.getX(), o.getX()), min(e.getY(), o.getY()), abs(e.getX() - o.getX()),
						abs(e.getY() - o.getY()));
				panel.repaint();
			}
		} };
	}

	private JToolBar fillToolBar() {
		return new JToolBar() {
			{
				for (AbstractAction tool : tools) {
					add(tool);
				}
				JButton BlueButton = new JButton();
				BlueButton.setBackground(Color.BLUE);
				BlueButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentColor = Color.BLUE;
					}
				});
				JButton BlackButton = new JButton();
				BlackButton.setBackground(Color.black);
				BlackButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentColor = Color.BLACK;
					}
				});
				JButton GreenButton = new JButton();
				GreenButton.setBackground(Color.GREEN);
				GreenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentColor = Color.GREEN;
					}
				});
				JButton RedButton = new JButton();
				RedButton.setBackground(Color.RED);
				RedButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentColor = Color.RED;
					}
				});
				add(BlueButton);
				add(BlackButton);
				add(GreenButton);
				add(RedButton);
			}
		};
	}

}
