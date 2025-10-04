package com.chakravyuh.githubsearch.Compnents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.chakravyuh.githubsearch.ui.theme.TopBarColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(

    title:String,
    onBackButtonClick:()->Unit,
    ) {


    val navigationIcon: @Composable () -> Unit = {
        if (!title.contains("GitHubUsers")){
            IconButton(onBackButtonClick){
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }
        else{null}
    }

    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = TopBarColor),
        title = {
            Text(text = title,
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        },

        navigationIcon = navigationIcon

    )

}