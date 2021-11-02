package com.example.jetpacktraning

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

/*@Preview(showBackground = true, device = Devices.PIXEL, showSystemUi = true)*/
@Composable
fun KittenView(count: Int, onNewKitten: () -> Unit){

    Column() {

        Text("you've got $count kittens")

        Button(onClick = onNewKitten) {
            Text("Release new kitten")
        }
    }
}

   /* @Composable
    fun KittenView(){
        var count = remember {
            mutableStateOf(3)
        }
        Column() {
            Text("you've got ${count.value} kittens")
            Button(onClick = {
                count.value +=1
            }) {
                Text("Release new kitten")
            }

        }


    }*/