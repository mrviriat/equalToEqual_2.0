package com.example.equaltoequal_20

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.equaltoequal_20.regScreens.LogScreen
import com.example.equaltoequal_20.regScreens.RegScreen
import com.example.equaltoequal_20.ui.theme.EqualToEqual_20Theme

data class User(
    val login: String,
    val password: String
)

class RegActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val currentUser = remember {
                mutableStateOf(User("", ""))
            }

            if (currentUser.value.login.isNotEmpty() && currentUser.value.password.isNotEmpty()){
                val navigate = Intent(this@RegActivity, MainActivity::class.java)
                startActivity(navigate)
                finish()
            }

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
                NavigationContainer(currentUser)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun NavigationContainer(
    currentUser: MutableState<User>,
    navController: NavHostController = rememberNavController()
) {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Log In", "Sign In")
    //val pagerState = rememberPagerState()
    //val coroutineScope = rememberCoroutineScope()

    Image(
        painter = painterResource(id = R.drawable.loginback),
        contentDescription = "logback",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(15.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Blue.copy(alpha = 0.2f))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .align(Alignment.End)
            ){
                TabRow(
                    selectedTabIndex = tabIndex,
                    modifier = Modifier
                        .fillMaxWidth(),
                    containerColor = Color.Transparent
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = tabIndex == index,
                            onClick = {
                                tabIndex = index
                            }
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Blue.copy(alpha = 0.2f))
            ){
                when (tabIndex) {
                    0 -> LogScreen(currentUser)
                    1 -> RegScreen()
                }
            }
        }
    }


    /*NavHost(
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
    }*/
}
