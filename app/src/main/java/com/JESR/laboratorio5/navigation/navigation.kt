package com.JESR.laboratorio5.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.JESR.laboratorio5.ui.components.TODOScreen
import com.JESR.laboratorio5.viewmodel.GeneralViewModel

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier) {
    val viewModel: GeneralViewModel = viewModel()

    NavHost(navController = navController, startDestination = "todo") {
        composable("todo") {
            TODOScreen(viewModel = viewModel)
        }
    }
}