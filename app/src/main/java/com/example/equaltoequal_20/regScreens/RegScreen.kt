package com.example.equaltoequal_20.regScreens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.equaltoequal_20.User
import org.json.JSONObject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegScreen(
    context: Context,
    currentUser: MutableState<User>
) {
    val login = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First Time?",
            color = Color(0xFF3a4e7a).copy(alpha = 0.9f),
            fontSize = 40.sp,
            fontWeight = FontWeight.W600
        )
        Column {
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
                    //containerColor = Color.Blue.copy(alpha = 0.2f)
                    containerColor = Color(0xFFf1f1f0),
                    focusedIndicatorColor = Color(0xFF3a4e7a).copy(alpha = 0.9f),
                    unfocusedIndicatorColor = Color.Transparent
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
                    //containerColor = Color.Blue.copy(alpha = 0.2f)
                    containerColor = Color(0xFFf1f1f0),
                    focusedIndicatorColor = Color(0xFF3a4e7a).copy(alpha = 0.9f),
                    unfocusedIndicatorColor = Color.Transparent
                ),
                visualTransformation = PasswordVisualTransformation(),
            )
        }

        Button(
            onClick = {
                getAPIData(login.value, password.value, context, currentUser)
            },
            modifier = Modifier
                .fillMaxWidth(0.5f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3a4e7a).copy(alpha = 0.9f),
            ),
            elevation = ButtonDefaults.buttonElevation(3.dp)
        ) {
            Text(text = "Registration")
        }
    }
}

fun getAPIData(
    login: String,
    password: String,
    context: Context,
    currentUser: MutableState<User>
) {
    val url = "https://api.grsu.by/1.x/app1/getStudent" +
            "?login=$login" +
            "&lang=ru_RU"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val obj = JSONObject(response)
            if (obj.getString("fullname").isNotEmpty()) {
                currentUser.value = User(
                    login,
                    password,
                    obj.getInt("id"),
                    obj.getString("fullname").split(" ")[0],
                    obj.getString("fullname").split(" ")[1],
                    obj.getString("grouptitle")
                )
            }
        },
        {
            Log.d("API", "API error: $it")
        }
    )
    queue.add(stringRequest)
}