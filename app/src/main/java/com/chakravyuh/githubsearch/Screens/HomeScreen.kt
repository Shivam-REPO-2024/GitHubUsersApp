package com.chakravyuh.githubsearch.Screens

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import coil.compose.rememberAsyncImagePainter
import com.chakravyuh.githubsearch.Api.ApiService
import com.chakravyuh.githubsearch.Api.RetrofitInstance
import com.chakravyuh.githubsearch.Compnents.AppBar
import com.chakravyuh.githubsearch.Model.usersItem
import com.chakravyuh.githubsearch.ui.theme.CardColor


@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               Users : List<usersItem> = emptyList(),
               ) {



    Scaffold(

        topBar = { AppBar("GitHubUsers",{}) }
    )
    { innerpadding->

        LazyColumn (
            modifier = modifier
                .padding(innerpadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(Users.size){
                user ->
                Box(modifier = Modifier.padding(20.dp)){
                    UserCard(user = Users[user])
                }
            }
        }

    }
}

@Composable
fun UserCard(user: usersItem) {

    Card (
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        ),
        elevation = CardDefaults.cardElevation(20.dp)
    ){


        Column(modifier = Modifier.padding(5.dp).fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            Image(

                painter = rememberAsyncImagePainter(user.avatar_url),
                contentDescription = null,
                contentScale = ContentScale.Crop,

                modifier = Modifier
                    .size(150.dp).clip(CircleShape)
                    .border(2.dp,Color.Black,CircleShape)

            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Login : ${user.login}",
                color = Color.White,
                fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Profile : ${user.user_view_type}",
                color = Color.White,
                fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
            )
        }
    }

}