package com.example.equaltoequal_20

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.equaltoequal_20.drawerNav.AllDestinations
import com.example.equaltoequal_20.drawerNav.screens.HomeScreen
import com.example.equaltoequal_20.drawerNav.screens.SettingsScreen
import com.example.equaltoequal_20.ui.theme.EqualToEqual_20Theme

class RegActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (correctUser) {
//            val navigate = Intent(this@RegActivity, MainActivity::class.java)
//            startActivity(navigate)
//        }
        setContent {
            EqualToEqual_20Theme {
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Button(onClick = {
//                        val navigate = Intent(this@RegActivity, MainActivity::class.java)
//                        startActivity(navigate)
//                        finish()
//                    }) {
//                        Text(text = "На основную активити")
//                    }
//                }
                NavigationContainer()
            }
        }

    }
}

@Composable
fun NavigationContainer(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AllDestinations.НазваниеЭкрана,
        ) {

        composable(AllDestinations.НазваниеЭкрана) {
            Экран()
        }

        composable(AllDestinations.НазваниеЭкрана2) {
            Экран2()
        }
    }
}