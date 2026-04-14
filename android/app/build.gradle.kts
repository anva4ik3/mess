plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

// ✅ ВАЖНО: Отключаем BuildConfig (устаревшая фича)
android {
    // ... остальной код ...
    buildFeatures {
        buildConfig = false  // Добавляем это
        compose = true
    }
    // ...
}
