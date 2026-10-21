PETUALANGAN BERHITUNG — PROYEK ANDROID

Apa isi paket ini?
- Proyek Android native sederhana dengan Kotlin + WebView.
- Game HTML sudah disertakan di app/src/main/assets/index.html.
- Workflow GitHub Actions untuk membangun APK debug secara online.
- Tidak meminta izin internet atau izin sensitif. Game dapat dimainkan offline.

PENTING:
Paket ini adalah SUMBER PROYEK Android, bukan file APK yang sudah dikompilasi.
APK belum dibuat atau diuji di perangkat karena lingkungan saat ini tidak menyediakan Android SDK/Gradle lokal.

CARA PALING MUDAH MENGHASILKAN APK:
1. Ekstrak ZIP.
2. Buat repository baru di GitHub dan unggah seluruh isi folder proyek ini (termasuk folder .github).
3. Buka tab Actions pada repository GitHub.
4. Jika diminta, aktifkan GitHub Actions.
5. Jalankan workflow "Build Android APK" melalui tombol Run workflow, atau lakukan push ke branch main.
6. Setelah workflow selesai dengan status hijau, buka hasil run → Artifacts → unduh Petualangan-Berhitung-APK.
7. Ekstrak file artifact ZIP. Di dalamnya ada app-debug.apk.
8. Pindahkan APK ke HP, buka file tersebut, lalu izinkan instalasi dari sumber itu jika Android memintanya.

CARA BUILD DI KOMPUTER:
- Pasang Android Studio versi stabil dengan Android SDK Platform 35.
- Buka folder proyek ini di Android Studio.
- Tunggu Gradle sync, lalu pilih Build > Build Bundle(s) / APK(s) > Build APK(s).
- APK debug umumnya ada di app/build/outputs/apk/debug/app-debug.apk.

CATATAN KEAMANAN:
- Ini APK debug untuk penggunaan pribadi, bukan rilis Play Store.
- Sebelum menginstal APK dari hasil build, pastikan Anda sendiri yang mengontrol repository dan workflow build.
