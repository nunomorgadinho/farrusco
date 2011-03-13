package server.farrusco.processing;



import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;

import processing.core.PApplet;
import processing.core.PFont;
import processing.serial.*;
import processing.video.*;

public class FarruscoMain extends PApplet {
	//Capture cam;
	String cmd;
	XMPPConnection connection;
	ChatManager chatmanager;
	Chat chat;

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
	
	
	public FarruscoMain() {
	cmd="";
		
		ConnectionConfiguration connConf = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
		connection = new XMPPConnection(connConf);
		
		connect();
	
	}
	
	
	public void setup() {
	  
		size(1440,850);
	  // Inputs: x, y, size,
	  // base color, over color, press color
	  
	  //font = loadFont("Verdana-10.vlw"); 
	  //textFont(font, 10); 
	  
	  buttonFrente = new Button(175, 525, 150);
	  buttonTras = new Button(175, 675, 150);
	  buttonEsquerda = new Button(25, 675, 150);
	  buttonDireita = new Button(325, 675, 150);
	  
	  servoDireita = new Button(550, 675, 150);
	  servoEsquerda = new Button(850, 675, 150);
	  servoCima = new Button(700, 525, 150);
	  servoBaixo = new Button(700, 675, 150);
	  
	  frameRate(10);
	  
	  // If no device is specified, will just use the default.
	  //cam = new Capture(this, width, height);

	  // To use another device (i.e. if the default device causes an error),  
	  // list all available capture devices to the console to find your camera.
	  String[] devices = Capture.list();
	  println(devices);
	  
	  // Change devices[0] to the proper index for your camera.
	  //cam = new Capture(this, width, height, devices[0]);

	  // Opens the settings page for this capture device.
	  //camera.settings();
	  
	  println(Serial.list()); // List COM-ports
	  // Open the port that the board is connected to and use the same speed (9600 bps)
	  port = new Serial(this, Serial.list()[0], 19200);
	  
	  smooth();
	  
	  //port.write('F');
	}

	public void draw() {
	  background(0);
	  
	  //if (cam.available() == true) {
	    //cam.read();
	    //image(cam, 0, 0);
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
	  port.write(cmd);
	  /*
	  if (cmd.equals("F")) {
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
		  */
	  //buttonFrente.update();
	  //buttonFrente.display();
	  
	  //buttonTras.update();
	  //buttonTras.display();
	  
	  //buttonEsquerda.update();
	  //buttonEsquerda.display();
	  
	  //buttonDireita.update();
	  //buttonDireita.display();

	  //servoDireita.update();
	  //servoDireita.display();
	  
	  //servoEsquerda.update();
	  //servoEsquerda.display();
	  
	  //servoCima.update();
	  //servoCima.display();
	  
	  //servoBaixo.update();
	  //servoBaixo.display();

	  if (buttonFrente.pressed == true) {
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
	public void mousePressed() {
	  buttonFrente.press();
	  buttonTras.press();
	  buttonEsquerda.press();
	  buttonDireita.press();
	  servoDireita.press();
	  servoEsquerda.press();
	  servoCima.press();
	  servoBaixo.press();
	}

	public void mouseReleased() {
	  buttonFrente.release();
	  buttonTras.release();
	  buttonEsquerda.release();
	  buttonDireita.release();
	  servoDireita.release();
	  servoEsquerda.release();
	  servoCima.release();
	  servoBaixo.release();
	}


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "FarruscoMain" });
	}
	
	void panTilt(int x, int y, int angleP, int angleT) {
		  
		  
		  
		  rectMode(CENTER);
		  
		  pushMatrix();
		  
		  translate(x+25, y-55);
		  fill(255, 100);
		  
		  noStroke();
		  scale(1.5f);
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
		  scale(1.5f);
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
	
	public void connect(){

		boolean bError=false;

		try {

		connection.connect();

		} catch (XMPPException e) {

		e.printStackTrace();
		bError = true;

		}

		if(!bError){

		//authentication

		try{

		this.connection.login("farruscorobot@gmail.com", "farrusc0");

		} catch(XMPPException e){

		//show wContact google account form

		e.printStackTrace();

		bError = true;

		}

		}

		if(!bError){

		//set presence status

		Presence presence = new Presence(Presence.Type.available);

		this.connection.sendPacket(presence);

		//set listener

		chatmanager = connection.getChatManager();

		this.chat = chatmanager.createChat("n.d.santos1@gmail.com", new MessageListener() {
			
			
		 
			public void processMessage(Chat arg0, Message message) {
					if(message!=null){
						if(message.getBody()!=null){
						cmd=message.getBody();
						System.out.println(message.getBody());
					}
					}
			}
		});
	
		
		Chat achat = chat;
		
		}

		}




}
