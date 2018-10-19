import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

/* paint *******************************************************************/

class Paint extends JFrame {
	Vector<Shape> shapes = new Vector<Shape>();
	List<ColorShape> shapeColorMap = new ArrayList<ColorShape>();
	Color currentColor = Color.BLACK;

	class Tool extends AbstractAction implements MouseInputListener {
		Point o;
		Shape shape;

		public Tool(String name) {
			super(name);
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("using tool " + this);
			panel.removeMouseListener(tool);
			panel.removeMouseMotionListener(tool);
			tool = this;
			panel.addMouseListener(tool);
			panel.addMouseMotionListener(tool);
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			o = e.getPoint();
		}

		public void mouseReleased(MouseEvent e) {
			shape = null;
		}

		public void mouseDragged(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
		}
	}

	Tool tools[] = { new Tool("pen") {
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
	}, new Tool("rect") {
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
	}, new Tool("oval") {
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
	Tool tool;

	JPanel panel;

	public Paint(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		add(new JToolBar() {
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
		}, BorderLayout.NORTH);
		add(panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, getWidth(), getHeight());

				Iterator<ColorShape> ite = shapeColorMap.iterator();
				while(ite.hasNext()){
					ColorShape current = (ColorShape) ite.next();
				    g2.setColor(current.getColor());
				    g2.draw(current.getShape());
				}
			}
		});

		pack();
		setVisible(true);
	}

	/* main *********************************************************************/

	public static void main(String argv[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Paint paint = new Paint("paint");
			}
		});
	}
}
