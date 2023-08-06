package com.example.equaltoequal_20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.equaltoequal_20.ui.theme.EqualToEqual_20Theme
import com.example.equaltoequal_20.drawerNav.DrawerNavigation

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EqualToEqual_20Theme {
                DrawerNavigation()
            }
        }
    }
}