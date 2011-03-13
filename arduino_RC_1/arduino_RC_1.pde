#include <Servo.h>

// Read data from the serial and turn ON or OFF a light depending on the value
char val; // Data received from the serial port

int motorA1 = 3;
int motorA2 = 5;

int motorB1 = 6;
int motorB2 = 11;

int anglePan, angleTilt;

Servo servoPan;
Servo servoTilt;

void setup() {
  
  Serial.begin(19200); // Start serial communication
  
  pinMode(motorA1, OUTPUT);
  pinMode(motorA2, OUTPUT);
  pinMode(motorB1, OUTPUT);
  pinMode(motorB2, OUTPUT);
  
  servoPan.attach(10);
  servoTilt.attach(4);
  
  servoPan.write(90);
  servoTilt.write(90);
  
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
    if (angleTilt < 180) {
      angleTilt += 1;
    }
  } else if (val == 'W') {
    if (angleTilt > 0) {
      angleTilt -= 1;
    } 
  } else if (val == 'A') {
    if (anglePan < 180) {
      anglePan += 1;
    } 
  } else if (val == 'D') {
    if (anglePan > 0) {
      anglePan -= 1;
    } 
  } else {
    digitalWrite(13, HIGH);
  }
  
  servoPan.write(anglePan);
  servoTilt.write(angleTilt);
  
  delay(50); // Wait 100 milliseconds for next reading
}

