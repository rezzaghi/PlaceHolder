package com.placeholder.mvvm.view.requestscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RequestScreen(viewModel: RequestViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState().value
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = state.todos?.title.toString())
            Text(text = state.todos?.id.toString())
            Text(text = state.todos?.userId.toString())
            Text(text = state.todos?.completed.toString())
            Button(
                modifier = Modifier.size(width = 130.dp, height = 50.dp),
                shape = RoundedCornerShape(size = 15.dp),
                onClick = { viewModel.getTodos() },
                content = { Text(text = "Get")},
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable()
fun RequestScreenPreview(){
    RequestScreen()
}

