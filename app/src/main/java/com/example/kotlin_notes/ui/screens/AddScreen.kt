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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_notes.ui.AppViewModelProvider
import kotlinx.coroutines.launch


@Composable
fun AddScreenScaffold(
    innerPaddingValues: PaddingValues,
    navigateBack: () -> Unit,
    viewModel: AddScreenViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        viewModel.saveNote()
                        navigateBack()
                    }
                },
            ) {
                Icon(Icons.Filled.Done, "")
            }
        }) { innerPaddingValues ->
        AddScreen(
            innerPaddingValues = innerPaddingValues,
            noteUiState = viewModel.noteUiState,
            onNoteValueChange = viewModel::updateUiState
        )
    }
}

@Composable
fun AddScreen(
    innerPaddingValues: PaddingValues,
    noteUiState: NoteUiState,
    onNoteValueChange: (NoteDetails) -> Unit
) {
    Column {
        NoteTitle(noteDetails = noteUiState.noteDetails, onValueChange = onNoteValueChange)
        NoteBody(noteDetails = noteUiState.noteDetails, onValueChange = onNoteValueChange)
    }
}

@Composable
fun NoteTitle(
    noteDetails: NoteDetails,
    onValueChange: (NoteDetails) -> Unit = {},
    enabled: Boolean = true
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = noteDetails.title,
        onValueChange = { onValueChange(noteDetails.copy(title = it)) },
        placeholder = { Text("Place for title...") },
        enabled = enabled
    )
}

@Composable
fun NoteBody(
    noteDetails: NoteDetails,
    onValueChange: (NoteDetails) -> Unit = {},
    enabled: Boolean = true
) {
    TextField(
        modifier = Modifier.fillMaxSize(),
        value = noteDetails.body,
        onValueChange = { onValueChange(noteDetails.copy(body = it)) },
        placeholder = { Text("Place for body...") },
        enabled = enabled
    )
}
