package com.JESR.laboratorio5.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.JESR.laboratorio5.ui.screens.TaskCard
import com.JESR.laboratorio5.viewmodel.GeneralViewModel
import java.util.*

@Composable
fun TODOScreen(viewModel: GeneralViewModel) {
    val tasks = viewModel.tasks.collectAsState()

    LazyColumn {
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