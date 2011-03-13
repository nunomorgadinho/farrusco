#include <MegaServo.h>

// Read data from the serial and turn ON or OFF a light depending on the value
#include "WProgram.h"
void setup();
void loop();
char val; // Data received from the serial port

int motorA1 = 3;
int motorA2 = 4;

int motorB1 = 6;
int motorB2 = 7;

int anglePan, angleTilt;

MegaServo servoPan;
MegaServo servoTilt;

void setup() {
  
  Serial.begin(57600); // Start serial communication
  
  pinMode(motorA1, OUTPUT);
  pinMode(motorA2, OUTPUT);
  pinMode(motorB1, OUTPUT);
  pinMode(motorB2, OUTPUT);
  
  servoPan.attach(9);
  //servoPan.write(90);
  
  servoTilt.attach(2);
  //servoTilt.write(90);
  
  delay(500);
  
}
void loop() {
  if (Serial.available()) { // If data is available to read,
    val = Serial.read(); // read it and store it in val
  }
  if (val == 'F') { // If H was received
    digitalWrite(motorA1, HIGH);
    digitalWrite(motorA2, LOW);
    
    digitalWrite(motorB1, HIGH);
    digitalWrite(motorB2, LOW);
  } 
  else if (val == 'B') {
    digitalWrite(motorA1, LOW);
    digitalWrite(motorA2, HIGH);
    
    digitalWrite(motorB1, LOW);
    digitalWrite(motorB2, HIGH);
  }
  else if (val == 'L') {
    digitalWrite(motorA1, HIGH);
    digitalWrite(motorA2, LOW);
    
    digitalWrite(motorB1, LOW);
    digitalWrite(motorB2, HIGH);
  } 
  else if (val == 'R') {
    digitalWrite(motorA1, LOW);
    digitalWrite(motorA2, HIGH);
    
    digitalWrite(motorB1, HIGH);
    digitalWrite(motorB2, LOW);
  } 
  else if (val == 'S') {
    digitalWrite(motorA1, LOW);
    digitalWrite(motorA2, LOW);
    
    digitalWrite(motorB1, LOW);
    digitalWrite(motorB2, LOW);
  } 
  else if (val == 'Q') {
    if (anglePan < 180) {
      anglePan += 3;
    }
  } else if (val == 'W') {
    if (anglePan > 0) {
      anglePan-=3;
    } 
  } else if (val == 'A') {
    if (angleTilt < 180) {
      angleTilt+=5;
    } 
  } else if (val == 'D') {
    if (angleTilt > 0) {
      angleTilt-=5;
    } 
  } else {
    digitalWrite(13, HIGH);
  }
  
  servoPan.write(anglePan);
  servoTilt.write(angleTilt);
  
  delay(50); // Wait 100 milliseconds for next reading
}


int main(void)
{
	init();

	setup();
    
	for (;;)
		loop();
        
	return 0;
}

