# Chat Application Android

A real-time chat application for Android built with Kotlin and Firebase.

## What It Does

- User authentication (signup/login) with email and password
- Real-time one-on-one messaging between users
- Display list of all registered users
- Send and receive messages instantly
- Auto-scroll to latest messages

## Technologies Used

**Language & Framework**
- Kotlin
- Android SDK (Min SDK 24, Target SDK 36)

**Firebase**
- Firebase Authentication
- Firebase Realtime Database
- Firebase Analytics

**Android Libraries**
- RecyclerView
- Material Design Components
- ConstraintLayout
- AndroidX Core KTX

## How to Build

### Prerequisites
- Android Studio
- Firebase account

### Setup Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Chat-Application-Android-main
   ```

2. **Configure Firebase**
   - Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
   - Add an Android app with package name: `com.example.chat_application`
   - Download `google-services.json` and place it in the `app/` directory
   - Enable **Email/Password Authentication** in Firebase Console
   - Enable **Firebase Realtime Database**

3. **Set Database Rules** (in Firebase Console)
   ```json
   {
     "rules": {
       ".read": "auth != null",
       ".write": "auth != null"
     }
   }
   ```

4. **Build**

   Using Gradle:
   ```bash
   ./gradlew build
   ```

   Or open in Android Studio and click Run
