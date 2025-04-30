package com.firstapp.trainapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class HomeTaskActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContent { // С‡С‚Рѕ-С‚Рѕ РІСЂРѕРґРµ Р»СЏРјР±РґР°-С„СѓРЅРєС†РёРё
                        Column (
                                modifier = Modifier
                                            .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ){
                                Box(
                                        modifier = Modifier
                                                    .fillMaxWidth(1.0f)
                                                    .fillMaxHeight(0.4f)
                                                    .background(Color(0xFF11FF11)),
                                        contentAlignment = Alignment.Center
                                            ) {
                                        Text("Hello, Android")
                                    }
                            }
                    }
            }
    }