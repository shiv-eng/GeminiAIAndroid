package com.shivangi.geminiaicompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shivangi.geminiaicompose.ui.screen.ChatRoute
import com.shivangi.geminiaicompose.ui.screen.MenuScreen
import com.shivangi.geminiaicompose.ui.theme.GeminiAITheme
import com.shivangi.geminiaicompose.ui.viewmodel.GroupViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val groupViewModel: GroupViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeminiAITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "menu") {
                        composable("menu") {
                            MenuScreen(groupViewModel, onItemClicked = { routeId, groupId ->
                                navController.navigate("$routeId/$groupId")
                            })
                        }
                        composable(
                            "chat/{groupId}",
                            arguments = listOf(
                                navArgument("groupId") {
                                    type = NavType.StringType
                                })
                        ) {
                            val groupId: String? = it.arguments?.getString("groupId")
                            if (groupId != null) {
                                ChatRoute(groupId) { chats ->
                                    if (chats.isNotEmpty()) {
                                        groupViewModel.addChatToGroup(groupId, chats)
                                    }
                                    navController.popBackStack()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
