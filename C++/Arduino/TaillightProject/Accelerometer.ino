#include <Wire.h>
#define AccelerometerID 0x18

static const uint8_t PROGMEM CHIPIDREG = 0;

//Power Mode Register
static const uint8_t PROGMEM PMU_LPW_REG = 0;


static const uint8_t PROGMEM REG_X_MSB = 0x03;
static const uint8_t PROGMEM REG_X_LSB = 0x02;

static const uint8_t PROGMEM REG_Y_MSB = 0x05;
static const uint8_t PROGMEM REG_Y_LSB = 0x04;

static const uint8_t PROGMEM REG_Z_MSB = 0x07;
static const uint8_t PROGMEM REG_Z_LSB = 0x06;


int getCHIPID(){
Wire.beginTransmission(AccelerometerID);
Wire.write(CHIPIDREG);
Wire.endTransmission();
Wire.requestFrom(AccelerometerID,1);
if(Wire.available()){
  return Wire.read();
} else{
  return 0;
}
Wire.endTransmission(true);
}

int EnterNormalMode(){
  Wire.beginTransmission(AccelerometerID);
  Wire.write(PMU_LPW_REG);
}

int16_t getXAccel(){
  int16_t XACCEL = 0;
  Wire.beginTransmission(AccelerometerID);
  Wire.write(REG_X_LSB);
  Wire.endTransmission();
  Wire.requestFrom(AccelerometerID,2);

  if(Wire.available()){
    XACCEL =(Wire.read() & 0xFC);
    XACCEL =(XACCEL | (Wire.read() << 8));
  } else{
    return 0;
  }

  return XACCEL;

  Wire.endTransmission(true);
}

int16_t getYAccel(){
  int16_t YACCEL = 0;
  Wire.beginTransmission(AccelerometerID);
  Wire.write(REG_Y_LSB);
  Wire.endTransmission();
  Wire.requestFrom(AccelerometerID,2);

  if(Wire.available()){
    YACCEL = (Wire.read() & 0xFC);
    YACCEL = YACCEL | (Wire.read() << 8);
  } else{
    return 0;
  }

  return YACCEL;

  Wire.endTransmission(true);
}

int16_t getZAccel(){
  int16_t ZACCEL = 0;
  Wire.beginTransmission(AccelerometerID);
  Wire.write(REG_Z_LSB);
  Wire.endTransmission();
  Wire.requestFrom(AccelerometerID,2);

  if(Wire.available()){
    ZACCEL = (Wire.read() & 0xFC);
    ZACCEL = ZACCEL | (Wire.read() << 8);
  } else{
    return 0;
  }

  return ZACCEL;

  Wire.endTransmission(true);
}
