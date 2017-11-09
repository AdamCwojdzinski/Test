package GUImodule;

import processing.core.PApplet;

public class MyFirstClass extends PApplet{
	
	public void setup() 
	{
		size(400, 400);
		background(200, 200, 200); 
		
		
	}
	
	public void draw()
	{
		fill(255, 255, 0);
		ellipse(200, 200, 390, 390);
		fill(0, 0, 0);
		ellipse(130, 130, 50, 50);
		fill(0, 0, 0);
		ellipse(260, 130, 50, 50);
		noFill();
		arc(200, 280, 105, 105, 0, PI); // zrobic usmiechajacja sie buzke.
	}
}
