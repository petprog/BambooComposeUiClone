package com.demoapp.petprog.bamboocomposeclone.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun ProfileScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile Screen",
            modifier = Modifier.padding(16.dp)
        )
    }
}