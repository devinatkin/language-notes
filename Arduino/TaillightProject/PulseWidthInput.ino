
#define FrequencyIn A3

unsigned long Period;

unsigned long GuessFrequency(){
  Period = 0;
  pulseIn(FrequencyIn,HIGH);
  for (int i = 0; i<10;i++){
    Period += pulseIn(FrequencyIn,HIGH);
    Period += pulseIn(FrequencyIn,LOW);
    
  }
  Period = Period/10;

  return Period;
}

inline unsigned long getPeriod(){
  return Period;
}

unsigned long HighTime(){
  return pulseIn(FrequencyIn,HIGH);
  
}
