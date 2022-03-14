package com.wrondon.fromsamples

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.KeyEventDispatcher
import com.wrondon.fromsamples.ui.theme.FromSAMPLESTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FromSAMPLESTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    Column{
        Text(text = "Hello $name! (project: From SAMPLES)")
        Button(onClick = {
            goToActivity(context, "com.google.samples.apps.sunflower", "com.google.samples.apps.sunflower.GardenActivity")
        }) {
            Text("Sunflower")
        }
        Button(onClick = {
            goToActivity(context, "com.example.jetnews", "com.example.jetnews.ui.MainActivity")
        }) {
            Text(text = "Jetnews")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FromSAMPLESTheme {
        Greeting("Android")
    }
}

private fun goToActivity(context: Context, packageName: String, className : String) {
    /////val intent = context.packageManager.getLaunchIntentForPackage(packageName)
    val intent = Intent().setClassName(packageName, className )
    try {
        context.startActivity(intent)
    }
    catch (e: Exception){
        Log.d("Samples"," ERROR STARTING ACTIVITY $e")
    }

}