package com.example.kotlin_notes.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


enum class HomeScreen() {
    Start,
    Add
}

@Composable
fun HomeScreenScaffold(innerPaddingValues: PaddingValues, navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(HomeScreen.Add.name)}
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }) { innerPaddingValues ->
        HomeScreen(innerPaddingValues)
    }
}

@Composable
fun HomeScreen(innerPaddingValues: PaddingValues) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(100) { notes ->
            Note()
        }
    }
}

@Composable
fun Note() {
    Text(
        text = "Note text",
        modifier = Modifier.fillMaxSize()
    )
}

