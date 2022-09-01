package com.demoapp.petprog.bamboocomposeclone.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun LearnScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Learn Screen",
            modifier = Modifier.padding(16.dp)
        )
    }
}