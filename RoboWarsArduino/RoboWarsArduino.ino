#include <FirebaseESP8266.h>
#include <ESP8266WiFi.h>

#define FIREBASE_HOST "fir-project-78bf0-default-rtdb.europe-west1.firebasedatabase.app"    
#define FIREBASE_AUTH "JBZKuGHBfdOBOxBSMgj87nTrAagR2i6lsKv31PSO"
#define WIFI_SSID     " "
#define WIFI_PASSWORD " "

FirebaseData fbdo;
FirebaseJson json;

// Pinler Örnektir
const int IN1=5;
const int IN2=6;
const int IN3=7;
const int IN4=8;

void printResult(FirebaseData &data);

void setup()
{

  Serial.begin(9600);

  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to Wi-Fi");
  while (WiFi.status() != WL_CONNECTED)
  {
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Connected with IP: ");
  Serial.println(WiFi.localIP());
  Serial.println();
  
  pinMode(IN1,OUTPUT);
  pinMode(IN2,OUTPUT);
  pinMode(IN3,OUTPUT);
  pinMode(IN4,OUTPUT);
  digitalWrite(IN1,LOW);
  digitalWrite(IN2,LOW);
  digitalWrite(IN3,LOW);
  digitalWrite(IN4,LOW);
  
  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.reconnectWiFi(true);


  fbdo.setBSSLBufferSize(1024, 1024);

  //Set the size of HTTP response buffers in the case where we want to work with large data.
  fbdo.setResponseSize(1024);

  //Set database read timeout to 1 minute (max 15 minutes)
  Firebase.setReadTimeout(fbdo, 1000 * 60);
  //tiny, small, medium, large and unlimited.
  //Size and its write timeout e.g. tiny (1s), small (10s), medium (30s) and large (60s).
  Firebase.setwriteSizeLimit(fbdo, "tiny");

  //optional, set the decimal places for float and double data to be stored in database
  Firebase.setFloatDigits(2);
  Firebase.setDoubleDigits(6);

  Serial.println("------------------------------------");
}

void loop()
{
    
    Firebase.getString(fbdo, "/state"); 
    String stateData = fbdo.stringData();
    Serial.println(stateData);
    
    switch (stateData): {
      case "left": {
        
        digitalWrite(IN1,LOW)
        digitalWrite(IN2,LOW)
        
        // motor sol yönde döner
        digitalWrite(IN3,HIGH)
        digitalWrite(IN4,LOW)
      }
      case "right": {
        // motor sağ yönde döner
        digitalWrite(IN1,LOW)
        digitalWrite(IN2,HIGH)
        
        digitalWrite(IN3,LOW)
        digitalWrite(IN4,LOW)
      }
      case "forward": {
        digitalWrite(IN1,LOW)
        digitalWrite(IN2,HIGH)
        
        digitalWrite(IN3,HIGH)
        digitalWrite(IN4,LOW)
      }
      case "backward": {
        digitalWrite(IN1,HIGH)
        digitalWrite(IN2,LOW)
        
        digitalWrite(IN3,LOW)
        digitalWrite(IN4,HIGH)
      }
    }
  
}
