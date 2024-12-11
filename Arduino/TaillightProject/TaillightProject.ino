#include <Wire.h>
#include <math.h>
#include <Adafruit_GFX.h>
#include <Adafruit_IS31FL3731.h>

Adafruit_IS31FL3731_Wing matrix = Adafruit_IS31FL3731_Wing();



static const uint8_t PROGMEM
  smile_bmp[] =
  { B10111100,
    B01000010,
    B10100101,
    B10000001,
    B10100101,
    B10011001,
    B01000010,
    B00111100 },
  neutral_bmp[] =
  { B00111100,
    B01000010,
    B10100101,
    B10000001,
    B10111101,
    B10000001,
    B01000010,
    B00111100 },
  frown_bmp[] =
  { B00111100,
    B01000010,
    B10100101,
    B10000001,
    B10011001,
    B10100101,
    B01000010,
    B00111100 };

uint8_t CardinalRotation;
uint8_t Bright;
void setup() {
  // put your setup code here, to run once:
  
    Serial.begin(9600);

    if (! matrix.begin()) {
      Serial.println("IS31 not found");
      while (1);
    }
  Serial.println("IS31 Found!");

  Wire.begin();
  
  Serial.print("CHIP ID: ");
  Serial.println(getCHIPID());

  CardinalRotation = 0;
  Bright = 255;
  matrix.clear();
  matrix.setRotation(0);
  matrix.drawBitmap(3, 0, smile_bmp, 8, 8, 32);
  
  pinMode(A3,INPUT);
  GuessFrequency();
}

void loop() {
uint8_t NewRotation = 0;
int16_t XAccel = getXAccel();
int16_t YAccel = getYAccel();
int16_t ZAccel = getZAccel();

double xn = (XAccel/32767.0);
double yn = (YAccel/32767.0);
double zn = (ZAccel/32767.0);
double angle = atan2(yn,xn) * (180/M_PI);  

if(angle < -90){
  NewRotation = 3;
}
else if(angle <0){
  NewRotation = 2; 
}else if(angle <90){
  NewRotation = 1;
}else{
  NewRotation = 0;
}

double Brightness = ((double)HighTime()/(double)getPeriod() );
Brightness = (Brightness-0.15)/0.75;
Brightness = Brightness * 255;
Serial.println(Brightness);

if((NewRotation != CardinalRotation) || (abs(Brightness - Bright) > 10)){
  CardinalRotation = NewRotation;
  Bright = (uint8_t) Brightness;
  matrix.clear();
  matrix.setRotation(CardinalRotation);
  matrix.drawBitmap(0, 0, smile_bmp, 8, 8, Bright);
}


}
