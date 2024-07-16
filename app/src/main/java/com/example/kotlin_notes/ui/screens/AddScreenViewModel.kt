package com.example.kotlin_notes.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlin_notes.database.Note
import com.example.kotlin_notes.database.repository.OfflineNoteRepository

class AddScreenViewModel(private val repository: OfflineNoteRepository) : ViewModel() {
    var noteUiState by mutableStateOf(NoteUiState())
        private set

    fun updateUiState(noteDetails: NoteDetails) {
        noteUiState = NoteUiState(noteDetails, validateInput(noteDetails))
    }

    suspend fun saveNote() {
        if (validateInput()) {
            repository.insertNote(noteUiState.noteDetails.toNote())
        }
    }

    private fun validateInput(uiState: NoteDetails = noteUiState.noteDetails): Boolean {
        return with(uiState) {
            title.isNotBlank() && body.isNotBlank()
        }
    }
}

data class NoteUiState(
    val noteDetails: NoteDetails = NoteDetails(),
    val isEntryValid: Boolean = false
)

data class NoteDetails(
    val id: Int = 0,
    val title: String = "",
    val body: String = "",
)

fun NoteDetails.toNote(): Note = Note(
    noteId = id,
    noteTitle = title,
    noteBody = body
)

fun Note.toUiState(isEntryValid: Boolean = false): NoteUiState = NoteUiState(
    noteDetails = this.toNoteDetails(),
    isEntryValid = isEntryValid
)

fun Note.toNoteDetails(): NoteDetails = NoteDetails(
    id = noteId,
    title = noteTitle,
    body = noteBody
)