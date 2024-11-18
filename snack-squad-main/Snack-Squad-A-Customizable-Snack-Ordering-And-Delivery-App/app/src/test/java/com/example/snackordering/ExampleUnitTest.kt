Package com.example.snacksquad•
import android.os.Bundle•
import androidx.activity.viewModels•
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.snacksquad.database.Snack
import com.example.snacksquad.database.SnackViewModel
class MainActivity : AppCompatActivity()
private lateinit var snackViewModel: SnackViewModel
private lateinit var snackRecyclerView:
        private lateinit var snackAdapter: SnackAdapter•
// Assume you have created a SnackAdapter for RecyclerView• override fun
onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
// Initialize RecyclerView• snackRecyclerView = findViewById(R.id.snackRecyclerView) •
    snackRecyclerView.layoutManager = LinearLayoutManager(this)
    snackAdapter = SnackAdapter() // Initialize your adapter
    snackRecyclerView.adapter = snackAdapter
    snackViewModel = SnackViewModel(application)
        .allSnacks.observe(this, { snacks ->
// Update the cached copy of the snacks in the adapter• snacks?.let { snackAdapter.setSnacks(it)
        }
})
// Handle Place Order button click
findViewById<Button>(R.id.placeOrderButton).setOnClickListener {• // Logic to place an order
    (e.g., open an Order Activity)
}
}
}
Snack Adapter
class SnackAdapter :
    RecyclerView.Adapter<SnackAdapter.SnackViewHolder>() {
    private var snacks = emptyList<Snack>()
    SnackViewHolder(itemView: View)RecyclerView.ViewHolder(itemView) • { • val snack Name:
        TextView = itemView.findViewById(R.id.snack_name)
        val snackPrice: TextView = itemView.findView•
    }
}
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}
android {
    namespace 'com.example.snackordering'
    compileSdk 33
    defaultConfig {
        applicationId "com.example.snackordering"
        minSdk 24
        targetSdk 33
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }
    buildTypes {
        release {
            rules.pro'
        }
        minifyEnabled false
        proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
                targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
    buildFeatures {
        compose true
    }
    composeOptions {
        kotlinCompilerExtensionVersion '1.2.0'
    }
    packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }
}
dependencies {
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
    implementation 'androidx.activity:activity-compose:1.3.1'
    implementation "androidx.compose.ui:ui:$compose_ui_version"
    implementation "androidx.compose.ui:ui-tooling-preview:$compose_ui_version"
    implementation 'androidx.compose.material:material:1.2.0'
    implementation 'androidx.room:room-common:2.5.0'
    implementation 'androidx.room:room-ktx:2.5.0'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_ui_version"
    debugImplementation "androidx.compose.ui:ui-tooling:$compose_ui_version"
    debugImplementation "androidx.compose.ui:ui-test-manifest:$compose_ui_version"
}
Output