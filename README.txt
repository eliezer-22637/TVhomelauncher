Build your APK without Android Studio

1. Create a new repository on GitHub (private is fine).
2. Upload everything in this ZIP, including the hidden .github folder. If your file manager hides it, use git: git init, git add -A, git commit, git push.
3. Open the Actions tab, pick "Build APK", then Run workflow. The build takes about 3-5 minutes.
4. When it finishes, open the run and download the "launcher-apk" artifact. It contains app-debug.apk.
5. Install it on your TV with adb install, or copy it to a USB drive or the Downloader app.

What runs: JavaScript from the Java Script editor runs inside the launcher (user.js, with the Launcher object). Kotlin from the Kotlin Script editor is compiled as UserScript.kt, so it must be valid top-level Kotlin declarations. C++ is saved in native/user.cpp but is not compiled yet. The *.js files in gui/ are saved for reference and are not executed.
The APK is signed with the debug key. Sign a release build yourself before publishing it.
