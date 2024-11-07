package com.epds.dev.eauction.ui.screens.buyer.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import com.epds.dev.eauction.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
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
        Spacer(Modifier.height(14.dp))
        Switch()
        Spacer(Modifier.height(14.dp))
        var chatScrollState = rememberScrollState()
        var notificationScrollState = rememberScrollState()
//        Chats(chatScrollState)
        Notification(notificationScrollState)
    }
}


// Notification Related
@Composable
fun Notification(scrollState: ScrollState) {
    Column(Modifier.verticalScroll(scrollState)) {
        Divider("Today")
        Spacer(Modifier.height(14.dp))
        NotificationRow(
            title = "SampleSampleSampleSampleSampleSampleSampleSample",
            message = "Sample",
            viewed = true
        )
        Spacer(Modifier.height(14.dp))
        NotificationRow(
            title = "SampleSampleSampleSampleSampleSampleSampleSample",
            message = "Sample",
            viewed = false
        )
    }
}

@Composable
fun NotificationRow(title: String, message: String, viewed: Boolean) {
    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)) {

        Box(modifier = Modifier.size(52.dp).border(0.5.dp, Color(0xFF2D3648), CircleShape)) {

            Image(painterResource(R.drawable.notification), contentDescription = "",
                contentScale = ContentScale.Fit, modifier = Modifier.align(Alignment.Center).height(26.dp))

            if (!viewed) {
                Spacer(
                    modifier = Modifier
                        .size(10.dp)
                        .offset(x = 37.dp, y = 2.dp)
                        .background(Color(0xFF2D3648), CircleShape)
                )
            }

        }

        var font = if (!viewed) { AppTheme.typography.semiBold.copy(fontSize = 16.sp, fontWeight = FontWeight.Bold) } else { AppTheme.typography.semiBold.copy(fontSize = 16.sp) }
        var font2 = if (!viewed) { AppTheme.typography.medium.copy(fontSize = 16.sp) } else { AppTheme.typography.medium.copy(fontSize = 16.sp, fontWeight = FontWeight.Normal) }

        Spacer(Modifier.width(12.dp))
        Column (modifier = Modifier.weight(1f, fill = false)) {
            Text(text = title, style = font, color = AppTheme.colors.black,
                maxLines = 1, overflow = TextOverflow.Ellipsis)
            Spacer(Modifier.height(2.dp))
            Text(text = message, style = font2, color = AppTheme.colors.black,
                maxLines = 1, overflow = TextOverflow.Ellipsis )
        }
        Spacer(Modifier.width(12.dp))

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(4.dp)) {
            Spacer(
                modifier = Modifier
                    .size(4.dp)
                    .background(Color(0xFF333333), CircleShape)
            )
            Spacer(Modifier.height(2.dp))
            Spacer(
                modifier = Modifier
                    .size(4.dp)
                    .background(Color(0xFF333333), CircleShape)
            )
            Spacer(Modifier.height(2.dp))
            Spacer(
                modifier = Modifier
                    .size(4.dp)
                    .background(Color(0xFF333333), CircleShape)
            )
        }

    }
}

@Composable
fun Divider(title: String) {
    Row (
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)) {
        Text(text = title, style = AppTheme.typography.medium, color = Color(0xFFA3A3A3))
        Spacer(Modifier.width(5.dp))
        Spacer(Modifier.height(1.5.dp).background(Color(0xFFEEEEEE)).fillMaxWidth())
    }
}


// Chats related
@Composable
private fun Chats(scrollState: ScrollState) {
    fun formatTime(time: Time): String {
        val formatter = SimpleDateFormat("hh:mma", Locale.getDefault())
        return formatter.format(time).uppercase(Locale.getDefault())
    }
    Column(Modifier.verticalScroll(scrollState)) {
        Message(
            name = "Batman Ako",
            lastMessage = "Kupal ka ba bossing? HAHAHAHAHA",
            time = formatTime(
                Time(
                    SimpleDateFormat(
                        "hh:mm a",
                        Locale.getDefault()
                    ).parse("11:35 PM")!!.time
                )
            ),
            seen = false,
            read = false,
            profilePic = painterResource(R.drawable.squidward),
        )
        Message(
            name = "Qpalized You Mamba",
            lastMessage = "You: Sheeeeesh",
            time = formatTime(
                Time(
                    SimpleDateFormat(
                        "hh:mm a",
                        Locale.getDefault()
                    ).parse("11:35 PM")!!.time
                )
            ),
            seen = false,
            read = true,
            profilePic = painterResource(R.drawable.malupiton),
        )

        Message(
            name = "Jorayne Alieza Licudan",
            lastMessage = "You: Gutom Na AKooo!!!",
            time = formatTime(
                Time(
                    SimpleDateFormat(
                        "hh:mm a",
                        Locale.getDefault()
                    ).parse("11:35 PM")!!.time
                )
            ),
            seen = true,
            read = true,
            profilePic = painterResource(R.drawable.sample_profile),
        )
    }
}


@Composable
fun Message(name: String, lastMessage: String, time: String, seen: Boolean, read: Boolean, profilePic: Painter) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
        Image(
            painter = profilePic,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),

        )
        var textStyle = if (read) AppTheme.typography.messageSeen else AppTheme.typography.messageNotSeen
        var textColor = AppTheme.colors.black
        Column (
            modifier = Modifier.padding(start = 12.dp).weight(1f, fill = false)) {
            Text(text = name, style =  AppTheme.typography.messageNotSeen.copy(fontSize = 17.sp), color = textColor, maxLines = 1,
                overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(bottom = 4.dp))
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
            }
        }
        if (seen) {
            Spacer(Modifier.width(12.dp))
            Image(
                painter = profilePic,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(16.dp)
            )
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
