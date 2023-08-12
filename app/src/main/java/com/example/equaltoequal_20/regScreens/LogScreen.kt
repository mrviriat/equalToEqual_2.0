package com.example.equaltoequal_20.regScreens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.equaltoequal_20.MainActivity
import com.example.equaltoequal_20.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogScreen(currentUser: MutableState<User>) {
    val login = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = login.value,
            onValueChange = { text -> login.value = text },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clip(RoundedCornerShape(15.dp)),
            placeholder = { Text(text = "Login") },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color.Blue.copy(alpha = 0.2f)
            )
        )
        TextField(
            value = password.value,
            onValueChange = { text -> password.value = text },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clip(RoundedCornerShape(15.dp)),
            placeholder = { Text(text = "Password") },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color.Blue.copy(alpha = 0.2f)
            ),
            visualTransformation = PasswordVisualTransformation(),
        )

        Button(
            onClick = {
                currentUser.value = User(login.value, password.value)
            },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(vertical = 15.dp),
            ) {
            Text(text = "Enter")
        }
    }
}