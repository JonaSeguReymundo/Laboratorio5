package com.JESR.laboratorio5.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.JESR.laboratorio5.ui.screens.TaskCard
import com.JESR.laboratorio5.viewmodel.GeneralViewModel
import com.JESR.laboratorio5.model.Task
import java.util.*

@Composable
fun TODOScreen(viewModel: GeneralViewModel) {
    val tasks = viewModel.tasks.collectAsState()
    var openDialog by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { openDialog = true }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar tarea")
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(tasks.value) { task ->
                TaskCard(
                    title = task.title,
                    description = task.description,
                    endDate = task.endDate,
                    checked = task.isCompleted,
                    onCheckedChange = {
                        viewModel.removeTask(task)
                    }
                )
            }
        }

        if (openDialog) {
            AlertDialog(
                onDismissRequest = { openDialog = false },
                confirmButton = {
                    TextButton(onClick = {
                        if (title.isNotBlank() && description.isNotBlank()) {
                            val newTask = Task(
                                id = viewModel.tasks.value.size + 1,
                                title = title,
                                description = description,
                                endDate = Date(),
                                isCompleted = false
                            )
                            viewModel.addTask(newTask)
                            title = ""
                            description = ""
                            openDialog = false
                        }
                    }) {
                        Text("Agregar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("Cancelar")
                    }
                },
                title = { Text("Nueva Tarea") },
                text = {
                    Column {
                        OutlinedTextField(
                            value = title,
                            onValueChange = { title = it },
                            label = { Text("Título") }
                        )
                        OutlinedTextField(
                            value = description,
                            onValueChange = { description = it },
                            label = { Text("Descripción") }
                        )
                    }
                }
            )
        }
    }
}
