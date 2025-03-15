# JK.apk

## Description
JK.apk is a custom Android application designed for educational purposes. This project explores Android vulnerabilities and security mechanisms by building and testing a proof-of-concept APK.

## Features
- Sends device information to a Flask server upon launch
- Designed for penetration testing and security analysis
- Developed using Android Studio

## Requirements
- Python 3
- Flask
- Java Development Kit (JDK)
- Android Studio
- Kali Linux (preferred for testing)

## Installation
### 1. Setting up the Flask Server
```bash
pip install -r requirements.txt
python server.py
```

### 2. Building the APK
- Open the project in Android Studio
- Sync Gradle and resolve dependencies
- Build the APK using `Build > Build Bundle(s) / APK(s) > Build APK(s)`
- Install the APK on an Android device

## Usage
1. Run the Flask server on your machine
2. Install and launch `JK.apk` on your Android device
3. The application will send device information to the Flask server

## Notes
- This project is for educational and ethical security research only.

**By Jasvanth**


