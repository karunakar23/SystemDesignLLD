/*
 * Creating Objects without specifying the exact class or creating objects based up on some conditions is called 
 * Factory Design Pattern
 */

interface Shape {
	void draw();
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Circle");
	}
	
}

class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Square");
	}
	
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle");
	}

}
enum list {
	CIRCLE,
	SQUARE,
	RECTANGLE
}

class ShapeFactory{
	
	Shape getShape(list x) {
		switch(x) {
		case CIRCLE:
			Circle c=new Circle();
			return c;
		case SQUARE:
			Square s=new Square();
			return s;
		case RECTANGLE:
			Rectangle r =new Rectangle();
			return r;
		default :
			return null;
		}
	}
}

public class Main {

	public static void main(String[] args) {
		ShapeFactory shapeFactory=new ShapeFactory();
		Shape obj1=shapeFactory.getShape(list.CIRCLE);
		obj1.draw();
		
		Shape obj2=shapeFactory.getShape(list.RECTANGLE);
		obj2.draw();
		
		Shape obj3=shapeFactory.getShape(list.SQUARE);
		obj3.draw();
		
		//returns object we want without exact class or returns object based up on some conditions
		
	}

}
