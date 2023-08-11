package com.example.equaltoequal_20

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.equaltoequal_20.drawerNav.AllDestinations
import com.example.equaltoequal_20.drawerNav.screens.HomeScreen
import com.example.equaltoequal_20.drawerNav.screens.SettingsScreen
import com.example.equaltoequal_20.regScreens.LogScreen
import com.example.equaltoequal_20.regScreens.RegScreen
import com.example.equaltoequal_20.ui.theme.EqualToEqual_20Theme


class RegActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EqualToEqual_20Theme {

                /*Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        val navigate = Intent(this@RegActivity, MainActivity::class.java)
                        startActivity(navigate)
                        finish()
                    }) {
                        Text(text = "На основную активити")
                    }
                }*/
                NavigationContainer()
            }
        }
    }
}

@Preview
@Composable
fun NavigationContainer(
    navController: NavHostController = rememberNavController()
) {
    Image(painter = painterResource(id = R.drawable.loginback),
        contentDescription = "logback",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    NavHost(
        navController = navController,
        startDestination = "LogScreen",
    ) {

        composable("LogScreen") {
            LogScreen {
                navController.navigate("RegScreen") {
                    popUpTo("RegScreen") {
                        inclusive = true
                    }
                }
            }
        }

        composable("RegScreen") {
            RegScreen {
                navController.navigate("LogScreen") {
                    popUpTo("LogScreen") {
                        inclusive = true
                    }
                }
            }
        }
    }
}
