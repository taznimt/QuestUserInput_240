package com.example.input

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.input.ui.theme.InputTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InputTheme {  // <-- pakai tema di sini
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormDataDiri(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
