package com.example.jetpacktraning

import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpacktraning.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                val navController = rememberNavController()  // хранит состояние при перевороте экрана
                val bottomItems = listOf("list","search","push")

              Scaffold(bottomBar = {          ///scofold для отрисовки Top bar BottomNavigation
                  BottomNavigation() {
                      bottomItems.forEach { screen ->
                          BottomNavigationItem(
                              selected = false,
                              onClick = {
                                        navController.navigate(screen)
                              },
                              label = {Text(screen)},
                              icon = {

                              })

                      }

                  }
              }) {
                  
                  NavHost(navController = navController , startDestination ="list" ){
                      composable("list"){ ListScreen(navController)}
                      composable("search"){ SearchScreen()}
                      composable("push"){ PushScreen()}
                      composable("details"){ navController.previousBackStackEntry?.arguments?.  // получаем данн из деталки
                      getParcelable<Word>("WORD_KEY")?.let {
                          DetailsScreen(it)
                      }}
                  }
                  
              }
            }
        }
    }
}



