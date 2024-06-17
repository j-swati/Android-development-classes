### Cohesion and Coupling

### Cohesion

- Cohesion refers to how closely related and focused the responsibilities of a single module or class are.
- High cohesion means that the class or module is focused on a single task or a group of related tasks.
- High cohesion within modules/classes makes the code more understandable, easier to maintain, and more reusable.
- When each module has a clear, well-defined responsibility, it becomes easier to make changes without affecting other parts of the system.

### Coupling

- Coupling refers to how dependent different modules or classes are on each other.
- Low coupling means that modules/classes interact with each other as little as possible.
- Low coupling makes the system more modular, which means changes in one module are less likely to affect other modules.
- This leads to easier maintenance, testing, and flexibility in the codebase.

### Transition from XML-based UI to Jetpack Compose

In traditional Android development, UI was defined using XML, and the logic was written in Java or Kotlin. This approach often led to **tightly coupled code**, where the UI and the business logic were interdependent. Here's how Jetpack Compose addresses these issues:

Jetpack Compose allows developers to write UI in Kotlin code, which increases cohesion by keeping related UI code together and reducing boilerplate. Additionally, it encourages the separation of UI and business logic using ViewModels and state management, leading to low coupling.

### How Jetpack Compose Improves Cohesion and Reduces Coupling

1. **Cohesion**:
    - **Declarative UI**: In Jetpack Compose, UI is described in a declarative way. Composable functions encapsulate the UI elements and their behavior, which keeps related code together, enhancing cohesion.
    - **Modular Components**: Compose encourages the creation of small, reusable composable functions, each responsible for a specific part of the UI. This modularity helps maintain high cohesion.
2. **Coupling**:
    - **Separation of Concerns**: Jetpack Compose promotes a clear separation of concerns by using ViewModels to handle business logic and state management. The UI components observe the state and update accordingly, leading to low coupling.
    - **State Management**: State in Compose is managed in a way that UI components react to state changes. This reactive approach decouples the state from the UI components, making the codebase more flexible and easier to maintain.

### Jetpack Compose

Jetpack Compose is a modern toolkit for building native Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.

### History of Jetpack Compose

Jetpack Compose is a modern UI toolkit introduced by Google to simplify and accelerate Android UI development. The initiative began around 2019, driven by the need to move away from the traditional XML-based layout system. The goal was to create a more declarative, efficient, and intuitive way to build Android UIs using Kotlin. Officially launched as a stable release in July 2021, Jetpack Compose is now a key part of modern Android development.

### Features of Jetpack Compose

- **Declarative UI**: Allows developers to describe the UI in a declarative way, making the code more intuitive and easier to manage.
- **Reduced Boilerplate Code**: Simplifies UI code by removing the need for XML layouts and boilerplate binding code.
- **Performance**: Optimized for better performance, with efficient UI rendering and reduced overdraw.
- **State Management**: Provides a powerful and flexible way to manage UI state with observable state and recomposition.
- **Interoperability with XML**: Can work alongside traditional XML layouts, allowing gradual migration.
- **Modular and Reusable Components**: Encourages the creation of modular and reusable UI components.
- **Kotlin-based**: Leverages Kotlin's language features for a more concise and expressive way to write UI code.

## App Lifecycle in Android

An Android application goes through a series of stages from its creation to its destruction. These stages are managed by the Android operating system and can be categorized into three key states:

1. **Active/Running**: The app is in the foreground, interacting with the user.
2. **Paused**: The app is partially obscured by another activity but is still visible.
3. **Stopped**: The app is completely obscured but still in memory.

### Lifecycle Callbacks

The Android framework provides lifecycle callbacks to manage these states:

1. **onCreate()**: Called when the activity is first created. Use this method for initializing the activity.
2. **onStart()**: Called when the activity becomes visible to the user.
3. **onResume()**: Called when the activity starts interacting with the user.
4. **onPause()**: Called when the activity is partially obscured.
5. **onStop()**: Called when the activity is no longer visible.
6. **onRestart()**: Called when the activity is restarting after being stopped.
7. **onDestroy()**: Called before the activity is destroyed.

### Example

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Lifecycle", "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy called")
    }
}

```

## View Lifecycle

The lifecycle of a view is shorter and simpler compared to an activity. Key methods include:

- **onAttachedToWindow()**: Called when the view is attached to a window.
- **onDetachedFromWindow()**: Called when the view is detached from its window.
- **onDraw()**: Called when the view should render its content.
- **onMeasure()**: Called to determine the size requirements for the view.

## Getting Started with Jetpack Compose

### Hello World Example

1. **Setup Your Environment**:
    - Ensure you have the latest version of Android Studio.
    - Create a new project and select "Empty Compose Activity".
2. **Hello World Implementation**:

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloWorldTheme {
        Greeting("Android")
    }
}

```

### Running the App

1. **Using Emulator**: [Run apps on the Android Emulator  |  Android Studio  |  Android Developers](https://developer.android.com/studio/run/emulator)
    - Open Android Studio.
    - Click on the "AVD Manager" icon and create a new virtual device.
    - Select a device definition and a system image.
    - Click "Finish" and start the emulator.
2. **Using Physical Device**: [Run apps on a hardware device  |  Android Studio  |  Android Developers](https://developer.android.com/studio/run/device)
    - Enable "Developer Options" and "USB Debugging" on your device.
    - Connect the device via USB.
    - Run the project from Android Studio and select your device.

## Safe Area in App Development

- In app development, the "safe area" refers to the portion of the screen where content is guaranteed to be visible and not obscured by device hardware elements such as notches, status bars, navigation bars, or rounded screen corners.
- This concept is crucial for ensuring that the user interface (UI) is both visually appealing and functional across different devices with varying screen shapes and sizes.

### Importance of Safe Area

1. **Device Compatibility**: Modern devices come with various screen designs, such as notches (e.g., iPhone X and later), rounded corners, and different aspect ratios. Safe areas ensure that the content is displayed properly on all these devices.
2. **User Experience**: By respecting safe areas, developers can ensure that important UI elements like buttons, text, and images are not obscured or difficult to interact with, providing a consistent and user-friendly experience.
3. **Aesthetics**: Ensuring that content stays within the safe area prevents it from looking cramped or improperly aligned, maintaining the visual integrity of the app.

### Safe Area in Android with Jetpack Compose

Jetpack Compose makes it relatively straightforward to handle safe areas, thanks to its layout system and modifiers.

### Handling Safe Area with Insets in Jetpack Compose

To handle safe areas, you can use the `Modifier.safeContentPadding()` provided by the `accompanist-insets` library. This modifier adds padding to your composable based on the system window insets, ensuring your content stays within the safe area.

### Example: Using Safe Area with Jetpack Compose

Here's an example demonstrating how to use `Modifier.safeContentPadding()` to ensure your content respects the safe area:

1. **Add Dependencies**: First, add the `accompanist-insets` dependency to your `build.gradle` file.
    
    ```groovy
    dependencies {
        implementation "com.google.accompanist:accompanist-insets:0.25.1"
    }
    
    ```
    
2. **Apply Safe Area Padding**:
    
    ```kotlin
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.tooling.preview.Preview
    import com.google.accompanist.insets.ProvideWindowInsets
    import com.google.accompanist.insets.safeContentPadding
    
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                MyApp()
            }
        }
    }
    
    @Composable
    fun MyApp() {
        ProvideWindowInsets {
            Surface(color = MaterialTheme.colorScheme.background) {
                Box(modifier = Modifier.safeContentPadding()) {
                    Greeting("Android")
                }
            }
        }
    }
    
    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!", modifier = Modifier.padding(16.dp))
    }
    
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyApp()
    }
    ```
    

## Basic UI Elements in Jetpack Compose

### Text Element

### Properties and Implementation

1. **Color**:
    
    ```kotlin
    Text(text = "Hello", color = Color.Red)
    
    ```
    
2. **Font Size**:
    
    ```kotlin
    Text(text = "Hello", fontSize = 24.sp)
    
    ```
    
3. **Font Style**:
    
    ```kotlin
    Text(text = "Hello", fontStyle = FontStyle.Italic)
    
    ```
    
4. **Font Weight**:
    
    ```kotlin
    Text(text = "Hello", fontWeight = FontWeight.Bold)
    
    ```
    
5. **Padding**:
    
    ```kotlin
    Text(text = "Hello", modifier = Modifier.padding(16.dp))
    
    ```
    
6. **Text Modifiers**:
    
    ```kotlin
    Text(
        text = "Hello",
        modifier = Modifier
            .background(Color.Gray)
            .padding(8.dp)
    )
    
    ```
    
7. **Gradient**:
    
    ```kotlin
    Text(
        text = "Hello",
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(Color.Red, Color.Blue)
            )
        )
    )
    
    ```
    

### **Marquee Effect**:

- The marquee effect, also known as text scrolling or text animation, is a visual effect used to display text that moves horizontally across the screen.
- This effect is often employed to showcase text content that exceeds the available space on the screen, allowing users to read the entire text without truncation.