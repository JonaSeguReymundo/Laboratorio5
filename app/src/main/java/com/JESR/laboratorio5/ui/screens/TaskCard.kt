package com.JESR.laboratorio5.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TaskCard(
    title: String,
    description: String,
    endDate: Date,
    checked: Boolean,
    onCheckedChange: () -> Unit
) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, style = MaterialTheme.typography.titleLarge)
                Text(text = description, style = MaterialTheme.typography.bodyMedium)
                Text(text = "Fecha límite: ${dateFormat.format(endDate)}")
            }
            Checkbox(
                checked = checked,
                onCheckedChange = { onCheckedChange() }
            )
        }
    }
}