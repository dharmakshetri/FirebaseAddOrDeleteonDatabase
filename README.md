#FirebaseAddOrDeleteonDatabase
Add and Delete item on Firebase Database

#Create firebase project :
[https://console.firebase.google.com](https://console.firebase.google.com)

#Introduction

  [Read more about Firebase Database](https://firebase.google.com/docs/database)

#Add the Realtime Database to your app

Add the dependency for Firebase Realtime Database to your app-level build.gradle file:

```java 
compile 'com.google.firebase:firebase-database:10.0.1' 
```
#Authnetication
Update the rules for your database to allow reads and writes from all users, as this demo will not cover Firebase Authentication.
```java
{
  "rules": {
    ".read": "true",
    ".write": "true"
  }
}
```
#Getting Started

* [Add Firebase to your Android Project.](https://firebase.google.com/docs/android/setup)
* Log in to the [Firebase Console](https://console.firebase.google.com/).
* Clone the github ```java $git clone https://github.com/dharmakshetri/FirebaseAddOrDeleteonDatabase.git ```
* Run the sample on Android device or emulator.


