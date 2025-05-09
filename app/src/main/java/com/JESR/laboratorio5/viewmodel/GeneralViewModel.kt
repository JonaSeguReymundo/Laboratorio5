package com.JESR.laboratorio5.viewmodel

import androidx.lifecycle.ViewModel
import com.JESR.laboratorio5.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.toMutableList

class GeneralViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
    val tasks = _tasks.asStateFlow()

    fun addTask(task: Task) {
        _tasks.value = _tasks.value.toMutableList().apply { add(task) }
    }

    fun removeTask(task: Task) {
        _tasks.value = _tasks.value.toMutableList().apply { remove(task) }
    }

}