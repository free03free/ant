# AJPanel Mobile v1.1 — Android source

Includes an IPTV URL entry screen, Xtream Codes fields, local M3U import, multiple saved playlist sources, channel parsing/search/group filtering and Media3 playback. Includes a basic OpenWebif `/web/about` connectivity test.

This is a source project, not a finished AJPanel port and not an APK. Receiver-side bouquet editing, SFTP/FTP, SSH terminal, EPG, timers/recordings, plugin and SoftCam management, signal monitor and backup/restore are not implemented yet. Those require receiver API integration and testing against the actual Enigma2 image.

Build using Android Studio, JDK 17, Android SDK 35 and Gradle 8.11.1. Run `gradle :app:assembleDebug` or import the folder. minSdk 24 (Android 7.0). No root or Termux required. HTTP is enabled for local OpenWebif compatibility; do not expose receiver management interfaces directly to the public internet.
