import processing.serial.*;
import processing.video.*;

Capture cam;

Serial port; // Create object from Serial class

int anglePan = 90;
int angleTilt = -180;

boolean GRID = false;

PFont font;
int squareSize = 50;

// Requires the Button class
Button buttonFrente;
Button buttonTras;
Button buttonEsquerda;
Button buttonDireita;
Button servoDireita;
Button servoEsquerda;
Button servoCima;
Button servoBaixo;

void setup() {
  size(1440,850);
  // Inputs: x, y, size,
  // base color, over color, press color
  
  font = loadFont("Verdana-10.vlw"); 
  textFont(font, 10); 
  
  buttonFrente = new Button(175, 525, 150, color(50), color(100), color(150));
  buttonTras = new Button(175, 675, 150, color(50), color(100), color(150));
  buttonEsquerda = new Button(25, 675, 150, color(50), color(100), color(150));
  buttonDireita = new Button(325, 675, 150, color(50), color(100), color(150));
  
  servoDireita = new Button(550, 675, 150, color(50), color(100), color(150));
  servoEsquerda = new Button(850, 675, 150, color(50), color(100), color(150));
  servoCima = new Button(700, 525, 150, color(50), color(100), color(150));
  servoBaixo = new Button(700, 675, 150, color(50), color(100), color(150));
  
  frameRate(10);
  
  // If no device is specified, will just use the default.
  //cam = new Capture(this, width, height);

  // To use another device (i.e. if the default device causes an error),  
  // list all available capture devices to the console to find your camera.
  String[] devices = Capture.list();
  println(devices);
  
  // Change devices[0] to the proper index for your camera.
  cam = new Capture(this, width, height, devices[0]);

  // Opens the settings page for this capture device.
  //camera.settings();
  
  println(Serial.list()); // List COM-ports
  // Open the port that the board is connected to and use the same speed (9600 bps)
  port = new Serial(this, Serial.list()[0], 19200);
  
  smooth();
}

void draw() {
  background(0);
  
  //if (cam.available() == true) {
    cam.read();
    image(cam, 0, 0);
    /*pushMatrix();
    translate(cam.width, 0);
    scale(-1, 1);
    
    popMatrix();*/
  //}
  
  panTilt(1100, 700, anglePan, angleTilt);
  
    // GRID
  if (GRID) {
    for (int i=0; i<width; i+=squareSize) {
      for (int j=0; j<height; j+=squareSize) {
        fill(255, 100);
        text(i+"  "+j, i, j);
        stroke(255, 25);
        noFill();
        rect(i, j, squareSize, squareSize);
      }
    }
  }
  
  stroke(255);
  
  buttonFrente.update();
  buttonFrente.display();
  
  buttonTras.update();
  buttonTras.display();
  
  buttonEsquerda.update();
  buttonEsquerda.display();
  
  buttonDireita.update();
  buttonDireita.display();

  servoDireita.update();
  servoDireita.display();
  
  servoEsquerda.update();
  servoEsquerda.display();
  
  servoCima.update();
  servoCima.display();
  
  servoBaixo.update();
  servoBaixo.display();

  if (buttonFrente.pressed == true) {
    println("Frente!");
    port.write('F');
  } 
  
  else if (buttonTras.pressed == true) {
    port.write('B');
  } 
  
  else if (buttonEsquerda.pressed == true) {
    port.write('R');
  } 
  
  else if (buttonDireita.pressed == true) {
    port.write('L');
  } 
  
  else if (servoDireita.pressed == true) {
    port.write('Q');
    if (anglePan > -90) anglePan -= 2;
  } 
  
  else if (servoEsquerda.pressed == true) {
    port.write('W');
    if (anglePan < 90) anglePan += 2;
  } 
  
  else if (servoCima.pressed == true) {
    port.write('A');
    if (angleTilt > -360) angleTilt -= 2;
  } 
  
  else if (servoBaixo.pressed == true) {
    port.write('D');
    if (angleTilt < -180) angleTilt += 2;
  } 
  
  else {
    port.write('S');
  }
  
}
void mousePressed() {
  buttonFrente.press();
  buttonTras.press();
  buttonEsquerda.press();
  buttonDireita.press();
  servoDireita.press();
  servoEsquerda.press();
  servoCima.press();
  servoBaixo.press();
}

void mouseReleased() {
  buttonFrente.release();
  buttonTras.release();
  buttonEsquerda.release();
  buttonDireita.release();
  servoDireita.release();
  servoEsquerda.release();
  servoCima.release();
  servoBaixo.release();
}

