package com.example.kotlin_notes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kotlin_notes.ui.navigate.HomeScreen
import com.example.kotlin_notes.ui.theme.Kotlin_NotesTheme




@Composable
fun HomeScreenScaffold(innerPaddingValues: PaddingValues, navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(HomeScreen.Add.name) }
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }) { innerPaddingValues ->
        HomeScreen(innerPaddingValues)
    }
}

@Composable
fun HomeScreen(innerPaddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(100) { note ->
            Note(note)
        }
    }
}

@Composable
fun Note(numberOfNote: Int) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = numberOfNote.toString(),
                modifier = Modifier
            )
        }
        Column(
            modifier = Modifier
                .weight(9f)
        ) {
            Text(
                text = "Note heading",
                modifier = Modifier
            )
            Text(
                text = "Note text",
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    Kotlin_NotesTheme {
        Note(1)
    }
}

