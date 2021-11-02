package com.example.jetpacktraning.screens

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.jetpacktraning.extension.navigate
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Word(val value: String) : Parcelable

@Composable
fun ListScreen(
    navController: NavController   //для перехода из списков к деталям
) {

    val textArray = listOf(
        Word("hello"),
        Word("world"),
        Word("Earth"),
        Word("vk"),
        Word("Facebook"),
        Word("amazaon"),
        Word("hello"),
        Word("world"),
        Word("Earth"),
        Word("vk"),
        Word("Facebook"),
        Word("amazaon"),
        Word("hello"),
        Word("world"),
        Word("Earth"),
        Word("vk"),
        Word("Facebook"),
        Word("amazaon"),
        Word("hello"),
        Word("world"),
        Word("Earth"),
        Word("vk"),
        Word("Facebook"),
        Word("amazaon")
    )


                Scaffold () {
            LazyColumn {
                textArray.map {
                    item {
                        Text(it.value, modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("details", bundleOf("WORD_KEY" to it))   // передаем данные деталке
                            })
                    }
                }
            }
        }
}