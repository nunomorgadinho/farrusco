void panTilt(int x, int y, int angleP, int angleT) {
  
  
  
  rectMode(CENTER);
  
  pushMatrix();
  
  translate(x+25, y-55);
  fill(255, 100);
  
  noStroke();
  scale(1.5);
  arc (0, 0, 55, 55, PI, TWO_PI);
  
  stroke(255);
  
  //text("PAN", -9, 25);
  //text(angleP, -9, 40);
  
  rotate(angleP * (PI / 180));
  fill(100,100);
  rect(0,0,7,7);
  line (0, 0, 0, -25);  
  popMatrix();  
  scale(1);
  
  pushMatrix();
  translate(x+120, y-55);
  fill(255, 100);
  scale(1.5);
  noStroke();
  arc(0, 0, 55, 55, 0, PI/2);
  arc(0, 0, 55, 55, TWO_PI-PI/2, TWO_PI);
  
  stroke(255);
  
  //text("TILT", -11, 25); 
  //text(angleT, -9, 40);
  
  rotate(angleT* (PI / 180));
  fill(100,100);
  rect(0,0,7,7);
  line (0, 0, 0, -25);
  popMatrix();
  scale(1);

}
