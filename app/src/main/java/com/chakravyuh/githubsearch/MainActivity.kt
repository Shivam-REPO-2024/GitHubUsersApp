package com.chakravyuh.githubsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chakravyuh.githubsearch.Api.ApiService
import com.chakravyuh.githubsearch.Api.RetrofitInstance
import com.chakravyuh.githubsearch.Model.usersItem
import com.chakravyuh.githubsearch.Screens.HomeScreen
import com.chakravyuh.githubsearch.ui.theme.GitHubSearchTheme

class MainActivity : ComponentActivity() {
    private val apiService : ApiService by lazy{ RetrofitInstance.getApiService() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubSearchTheme {
                var users  by remember{ mutableStateOf<List<usersItem>>(emptyList()) }
                LaunchedEffect(Unit) {
                     users =apiService.getUsers()
                }
                HomeScreen(Users = users)
            }
        }
    }
}

