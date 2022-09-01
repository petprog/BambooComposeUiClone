package com.demoapp.petprog.bamboocomposeclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.demoapp.petprog.bamboocomposeclone.common.BambooComposeCloneTheme
import com.demoapp.petprog.bamboocomposeclone.ui.BottomNavigationBar
import com.demoapp.petprog.bamboocomposeclone.ui.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun topBar() {

        TopAppBar(
            title = {
                Text(text = "")
            },
            elevation = 0.dp,

            navigationIcon = {
                // show drawer icon
                IconButton(
                    onClick = {
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_show_chart),
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                }
            }
        )

    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreen() {
        BambooComposeCloneTheme {
            val navController = rememberNavController()
            Scaffold(
                topBar = { topBar() },
                bottomBar = { BottomNavigationBar(navController) }

            ) {
                Navigation(navController)
            }
        }
    }
}