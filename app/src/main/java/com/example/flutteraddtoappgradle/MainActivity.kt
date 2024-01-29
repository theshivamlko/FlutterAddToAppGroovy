package com.example.flutteraddtoappgradle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flutteraddtoappgradle.ui.theme.FlutterAddToAppGradleTheme
import com.example.unitconvertorcompose.utils.CreateInstance
import io.flutter.embedding.android.FlutterActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FlutterAddToAppGradleTheme {
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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current;

    var counter by remember {
        mutableStateOf(0)
    }

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)

    ) {
        Button(onClick = {
            try {

                CreateInstance.openFlutterPage(counter)
                context.startActivity(
                    FlutterActivity.withCachedEngine(ConvertorApp.FLUTTER_ENGINE_NAME)
                        .build(context)
                )
            }catch (e:Exception){
                println("openFlutterPage Error $e")
            }

        }) {
            Text(text = "Open Flutter Page")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlutterAddToAppGradleTheme {
        Greeting("Android")
    }
}