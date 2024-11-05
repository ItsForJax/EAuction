package com.epds.dev.eauction.ui.screens.buyer.main

import com.epds.dev.eauction.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.epds.dev.eauction.ui.theme.AppTheme

@Composable
fun HomeScreen(name: String,
               status: String,
               avatar: Painter,
               modifier: Modifier) {

    val viewModel: HomeScreenVM = viewModel()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
    ){
        Header(name, status, avatar)
        Spacer(Modifier.height(16.dp))
        SearchBox(viewModel)
        Spacer(Modifier.height(16.dp))
        YourActionSection(Modifier.weight(0.25f))
        Spacer(Modifier.height(16.dp))
        YourBestBidSection(modifier = Modifier.weight(.5f))
    }
}

@Composable
private fun Header(
    name: String,
    status: String,
    avatar: Painter
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){
        Image(
            painter = avatar,
            contentDescription = "Avatar",
            modifier = Modifier.size(48.dp)
        )
        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ){
            Text(
                text = "Hello, $name",
                style = AppTheme.typography.headingXS,
                color = AppTheme.colors.base800
            )
            Text(
                text = status,
                style = AppTheme.typography.bodyMedium,
                color = AppTheme.colors.base800
            )
        }
        Spacer(Modifier.width(16.dp))
        Image(
            painter = painterResource(R.drawable.global),
            contentDescription = "Avatar",
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
private fun SearchBox(viewModel: HomeScreenVM){
    Row (
        Modifier
            .border(1.5.dp, AppTheme.colors.base400, shape = RoundedCornerShape(64.dp))
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 7.dp)
    ) {
        TextField(
            value = viewModel.text,
            onValueChange = {viewModel.text = it},
            shape = RoundedCornerShape(64.dp),
            textStyle = AppTheme.typography.bodyMedium,
            placeholder = {
                Text(
                    text = "Search Auction",
                    style = AppTheme.typography.bodyMedium,
                    color = AppTheme.colors.base600
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = AppTheme.colors.base800
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.search_line),
                    contentDescription = "",
                    modifier = Modifier.size(22.dp)
                )
            },
            singleLine = true
        )
    }
}

@Composable
private fun YourActionSection(modifier: Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
           Text(
               text = "Your Auctions",
               style = AppTheme.typography.headingXS,
               color = AppTheme.colors.base800
           )
            Text(
                text = "View All",
                style = AppTheme.typography.bodySmall,
                color = AppTheme.colors.base800
            )
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ){
            Text(
                text = "You have no auctions.",
                style = AppTheme.typography.bodySmall,
                color = AppTheme.colors.base800
            )
            Text(
                text = "Click the “\uD83D\uDD28” to create one.",
                style = AppTheme.typography.bodySmall,
                color = AppTheme.colors.base800
            )
        }

    }

}

@Composable
private fun YourBestBidSection (modifier: Modifier){
    var expanded by remember { mutableStateOf(false) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Your Best Bid",
                style = AppTheme.typography.headingXS,
                color = AppTheme.colors.base800
            )
            Row (modifier = Modifier.clickable { expanded = !expanded }) {
                Text(
                    text = "Filter by",
                    style = AppTheme.typography.bodySmall,
                    color = AppTheme.colors.base800
                )
                Image(
                    painter = painterResource(R.drawable.drop_down),
                    contentDescription = "",
                    modifier = Modifier
                        .size(width = 24.dp, height = 16.dp)
                        .padding(start = 2.dp)
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    DropdownMenuItem(
                        text = { Text(
                            text = "Item 1",
                            style = AppTheme.typography.bodySmall,
                            color = AppTheme.colors.base800
                        ) },
                        onClick = { expanded = false }
                    )
                    DropdownMenuItem(
                        text = { Text(
                            text = "Item 2",
                            style = AppTheme.typography.bodySmall,
                            color = AppTheme.colors.base800
                        ) },
                        onClick = { expanded = false }
                    )
                    DropdownMenuItem(
                        text = { Text(
                            text = "Item 3",
                            style = AppTheme.typography.bodySmall,
                            color = AppTheme.colors.base800
                        ) },
                        onClick = { expanded = false }
                    )
                }
            }
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ){
            Text(
                text = "You have no auctions.",
                style = AppTheme.typography.bodySmall,
                color = AppTheme.colors.base800
            )
            Text(
                text = "Click the “\uD83D\uDD28” to create one.",
                style = AppTheme.typography.bodySmall,
                color = AppTheme.colors.base800
            )
        }
    }
}