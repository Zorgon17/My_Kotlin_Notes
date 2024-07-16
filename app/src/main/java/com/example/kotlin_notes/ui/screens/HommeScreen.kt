package com.example.kotlin_notes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.kotlin_notes.database.Note
import com.example.kotlin_notes.ui.AppViewModelProvider
import com.example.kotlin_notes.ui.navigate.HomeScreen


@Composable
fun HomeScreenScaffold(
    innerPaddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: HomeScreenViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val homeUiState by viewModel.homeUiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(HomeScreen.Add.name) }
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }) { innerPaddingValues ->
        HomeBody(innerPaddingValues, noteList = homeUiState.noteList)
    }
}

@Composable
fun HomeBody(innerPaddingValues: PaddingValues, noteList: List<Note>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (noteList.isEmpty()) {
            Text(
                text = "Here no any notes right now((",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            HomeScreen(noteList = noteList)
        }
    }
}

@Composable
fun HomeScreen(noteList: List<Note>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items = noteList, key = {it.noteId}) { note ->
            Note(note = note)
        }
    }
}

@Composable
fun Note(note: Note) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.noteId.toString(),
                modifier = Modifier
            )
        }
        Column(
            modifier = Modifier
                .weight(9f)
        ) {
            Text(
                text = note.noteTitle,
                modifier = Modifier
            )
            Text(
                text = note.noteBody,
                modifier = Modifier
            )
        }
    }
}



