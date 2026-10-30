# AJPanel Mobile v1.0-alpha1

مشروع Android Studio أصلي كبداية لإعادة تنفيذ AJPanel على الهاتف، وليس تحويلًا مباشرًا لإضافة Enigma2.

## المتاح في هذه النسخة
- تطبيق Android أصلي، الحد الأدنى Android 7 (API 24).
- استيراد قوائم M3U/M3U8 من رابط أو ملف محلي.
- قراءة أسماء القنوات ومجموعاتها.
- تشغيل روابط HTTP/HTTPS باستخدام AndroidX Media3.
- إدخال عنوان OpenWebif واختبار المسار `/web/about`.

## البناء
- Android Studio حديث.
- JDK 17.
- Android SDK Platform 35.
- افتح مجلد المشروع ثم Sync Gradle ثم Build > Build APK(s).

## ما لم ينفذ بعد
Bouquet Editor، EPG، Picons، مدير الملفات، FTP/SFTP، SSH Terminal، Plugins، SoftCam، Backup/Restore، التسجيلات والمؤقتات، مراقبة الإشارة، الشبكة، وأدوات التاريخ والوقت. لا تعتبر هذه الوظائف منجزة في هذه النسخة.

## تنبيه
هذه نسخة Alpha مصدرية ولم يتم تسليم APK مبني أو مختبر. بعض وظائف إدارة Enigma2 تحتاج OpenWebif أو SSH وصلاحيات مناسبة على الرسيفر. قبل التوزيع يجب تشفير بيانات الدخول وتقييد الاتصال بالشبكات الموثوقة.
