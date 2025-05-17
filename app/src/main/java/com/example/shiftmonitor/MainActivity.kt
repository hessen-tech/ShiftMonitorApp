package com.example.shiftmonitor

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShiftMonitorAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ShiftMonitorScreen()
                }
            }
        }
    }
}

@Composable
fun ShiftMonitorScreen(viewModel: ShiftMonitorViewModel = viewModel()) {
    var websiteUrl by remember { mutableStateOf("") }
    var isMonitoring by remember { mutableStateOf(false) }
    
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = websiteUrl,
            onValueChange = { websiteUrl = it },
            label = { Text("Website URL") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = {
                isMonitoring = !isMonitoring
                viewModel.toggleMonitoring(isMonitoring, websiteUrl)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isMonitoring) "Stop Monitoring" else "Start Monitoring")
        }
    }
}