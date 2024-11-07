package com.epds.dev.eauction.ui.screens.buyer.main

import androidx.compose.foundation.Image
import com.epds.dev.eauction.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.epds.dev.eauction.ui.theme.AppTheme
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun InboxScreen(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
        Switch()
        Spacer(Modifier.height(14.dp))
        var scrollState = rememberScrollState()
        fun formatTime(time: Time): String {
            val formatter = SimpleDateFormat("hh:mma", Locale.getDefault())
            return formatter.format(time).uppercase(Locale.getDefault())
        }
        Column (Modifier.verticalScroll(scrollState)) {
            Message(
                name = "Batman Ako",
                lastMessage = "Kupal ka ba bossing? HAHAHAHAHA",
                time = formatTime(Time(SimpleDateFormat("hh:mm a", Locale.getDefault()).parse("11:35 PM")!!.time)),
                seen = false,
                read = false,
                profilePic = painterResource(R.drawable.malupiton),
            )
            for (x in 1..25) {
                Message(
                    name = "Name $x",
                    lastMessage = "Hello Name $x",
                    time = formatTime(Time(SimpleDateFormat("hh:mm a", Locale.getDefault()).parse("12:${x} PM")!!.time)),
                    seen = x%2 == 1,
                    read = x%2 == 1,
                    profilePic = painterResource(R.drawable.sample_profile),
                )
            }
        }
    }
}


@Composable
fun Message(name: String, lastMessage: String, time: String, seen: Boolean, read: Boolean, profilePic: Painter) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = profilePic,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(58.dp)
                .padding(bottom = 12.dp),

        )
        var textStyle = if (seen) AppTheme.typography.messageSeen else AppTheme.typography.messageNotSeen
        var textColor = AppTheme.colors.base800
        Column (
            modifier = Modifier.padding(start = 8.dp)) {
            Text(text = name, style = textStyle.copy(fontSize = 16.sp), color = textColor, maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()){
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start) {
                    Text(text = lastMessage, style = textStyle, color = textColor, maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f, fill = false) )
                    Text(text = " • ", style = textStyle, color = textColor)
                    Text(text = time, style = textStyle, color = textColor, maxLines = 1)
                }
                if (seen) {
                    Image(
                        painter = profilePic,
                        contentDescription = "",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(16.dp)
                    )
                }

            }
        }
    }
}

@Composable
fun Switch(){
    Row (modifier = Modifier
        .clip(RoundedCornerShape(11.dp))
        .height(32.dp)
        .background(AppTheme.colors.base800)) {
        var active by remember { mutableStateOf(true) }
        var cardColors =
            CardColors(
                containerColor = Color(0xFFF5F5F5),
                contentColor = AppTheme.colors.base800,
                disabledContentColor = AppTheme.colors.white,
                disabledContainerColor = AppTheme.colors.base800,
            )

        Card(
            colors = cardColors,
            onClick = { active = !active },
            enabled = !active,
            shape = RoundedCornerShape(9.dp),
            modifier = Modifier.size(height = 32.dp, width = 120.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Chats",
                    style = AppTheme.typography.semiBold.copy(fontSize = 14.sp)
                )
            }

        }
        Card(
            colors = cardColors,
            onClick = { active = !active },
            enabled = active,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.size(height = 32.dp, width = 120.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Notifications",
                    style = AppTheme.typography.semiBold.copy(fontSize = 14.sp)
                )
            }

        }
    }
}
