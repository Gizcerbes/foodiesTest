plugins {
	alias(libs.plugins.androidApplication)
	alias(libs.plugins.jetbrainsKotlinAndroid)
	alias(libs.plugins.googleDaggerHiltAndroid)
	id("kotlin-kapt")
}

android {
	namespace = "com.uogames.foodiestest"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.uogames.foodiestest"
		minSdk = 26
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
		debug {
			this.isDebuggable = false
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.11"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

tasks.register("version") {
	println(android.defaultConfig.versionName)
}

dependencies {

	implementation(project(":features:database"))
	implementation(project(":features:retrofitNetwork"))

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)

	implementation(libs.androidx.lifecycle.runtime.compose)

	implementation(libs.androidx.navigation.compose)

	implementation(libs.androidx.constraintlayout.compose)

	implementation(libs.glide)
	implementation(libs.compose)

	implementation(libs.lottie)
	implementation(libs.lottie.compose)
	implementation(libs.androidx.core.splashscreen)

	implementation(libs.hilt.android)
	kapt(libs.hilt.compiler)
	kapt(libs.androidx.hilt.compiler)
	implementation(libs.androidx.hilt.navigation.compose)

	implementation(libs.androidx.material3)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
}