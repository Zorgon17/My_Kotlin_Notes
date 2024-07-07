package com.example.kotlin_notes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun AddScreenScaffold(innerPaddingValues: PaddingValues, navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(HomeScreen.Start.name)}
            ) {
                Icon(Icons.Filled.Done, "")
            }
        }) { innerPaddingValues ->
        AddScreen(innerPaddingValues)
    }
}

@Composable
fun AddScreen(innerPaddingValues: PaddingValues) {
    Column {
        NoteTitle()
        NoteBody()
    }
}

@Composable
fun NoteTitle() {
    TextField(modifier = Modifier.fillMaxWidth(), value = "Place for title...", onValueChange = {})
}

@Composable
fun NoteBody() {
    TextField(modifier = Modifier.fillMaxSize(), value = "Place for body...", onValueChange = {})
}
//@Preview(showBackground = true)
//@Composable
//fun AddScreenPreview() {
//    Kotlin_NotesTheme {
//        AddScreenScaffold()
//    }
//}