package com.epds.dev.eauction.ui.screens.buyer.main

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.epds.dev.eauction.ui.theme.AppTheme

@Composable
fun InboxScreen(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier.fillMaxWidth()) {
        Spacer(Modifier.height(14.dp))
        Switch()
        var scrollState = rememberScrollState()
        Column (Modifier.verticalScroll(scrollState)) {
            for (x in 1..25) {
                Row {
                    Icon(
                        painterResource(R.drawable.avatar),
                        contentDescription = ""
                    )
                    Column {
                        Text(text = "Name")
                        Text(text = "Message")
                    }
                }
            }

        }
    }
}




@Composable
fun Switch(){
    Row (modifier = Modifier.clip(RoundedCornerShape(10.dp))
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
            shape = RoundedCornerShape(10.dp),
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
