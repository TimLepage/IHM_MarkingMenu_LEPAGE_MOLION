import java.awt.Color;
import java.awt.Shape;

public class ColorShape {
	Color color;
	Shape shape;
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public ColorShape(Color c, Shape s){
		color = c;
		shape = s;
	}
	
}
