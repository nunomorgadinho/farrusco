package server.farrusco.processing;

import processing.core.PApplet;

public class Button {

	FarruscoMain parent;
	public Button(FarruscoMain aParent) {

		parent = aParent;

	}
	
	  int x, y; // The x- and y-coordinates
	  int size; // Dimension (width and height)
	  boolean over = false; // True when the mouse is over
	  boolean pressed = false; // True when the mouse is over and pressed
	  Button(int xp, int yp, int s) {
	    x = xp;
	    y = yp;
	    size = s;
	  }
	  // Updates the over field every frame
	  void update() {
	    if ((parent.mouseX >= x) && (parent.mouseX <= x+size) &&
	      (parent.mouseY >= y) && (parent.mouseY <= y+size)) {
	      over = true;
	    } 
	    else {
	      over = false;
	    }
	  }
	  boolean press() {
	    if (over == true) {
	      pressed = true;
	      return true;
	    } 
	    else {
	      return false;
	    }
	  }
	  void release() {
	    pressed = false; // Set to false when the mouse is released
	  }
	  void display() {
	    if (pressed == true) {
	    	parent.fill(150, 100);
	    } 
	    else if (over == true) {
	    	parent.fill(100, 100);
	    } 
	    else {
	    	parent.fill(50, 100);
	    }
	    parent.strokeWeight(1);
	    parent.stroke(255, 100);
	    parent.rectMode(parent.CORNER);
	    parent.rect(x, y, size, size);
	  }
}
