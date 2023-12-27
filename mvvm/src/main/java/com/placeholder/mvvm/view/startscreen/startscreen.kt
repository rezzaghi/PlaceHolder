package com.placeholder.mvvm.view.startscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun StartScreen(
    navHostController: NavHostController,
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to Place Holder",
                fontSize = 30.sp
            )
            Button(
                modifier = Modifier.size(width = 130.dp, height = 50.dp),
                shape = RoundedCornerShape(size = 15.dp),
                content = { Text(text = "Start request") },
                onClick = { navHostController.navigate("requestscreen") }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun StartScreenPreview(){
    StartScreen(rememberNavController())
}

