package com.example.ecastromusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ecastromusicapp.navigation.DetailRoute
import com.example.ecastromusicapp.navigation.HomeRoute
import com.example.ecastromusicapp.screens.DetailScreen
import com.example.ecastromusicapp.screens.HomeScreen
import com.example.ecastromusicapp.ui.theme.ECastroMusicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECastroMusicAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicApp()
                }
            }
        }
    }
}

@Composable
fun MusicApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeScreen(
                onAlbumClick = { albumId ->
                    navController.navigate(DetailRoute(albumId))
                }
            )
        }

        composable<DetailRoute> { backStackEntry ->
            val detailRoute = backStackEntry.toRoute<DetailRoute>()
            DetailScreen(
                albumId = detailRoute.albumId,
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}