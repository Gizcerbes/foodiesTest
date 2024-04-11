plugins {
	`embedded-kotlin`
}

dependencies {

	//implementation(libs.androidx.core.ktx)

	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("com.squareup.retrofit2:converter-scalars:2.9.0")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")

	testImplementation(libs.junit)

}