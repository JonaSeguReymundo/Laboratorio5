package com.JESR.laboratorio5.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.JESR.laboratorio5.ui.screens.TaskCard
import com.JESR.laboratorio5.viewmodel.GeneralViewModel
import com.JESR.laboratorio5.model.Task
import java.util.*

@Composable
fun TODOScreen(viewModel: GeneralViewModel) {
    val tasks = viewModel.tasks.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val newTask = Task(
                        id = viewModel.tasks.value.size + 1,
                        title = "Nueva tarea",
                        description = "Descripción",
                        endDate = Date(),
                        isCompleted = false

                    )
                    viewModel.addTask(newTask)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar tarea"
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(tasks.value) { task ->
                TaskCard(
                    title = task.title,
                    description = task.description,
                    endDate = task.endDate,
                    checked = task.isCompleted
                )
            }
        }
    }
}
