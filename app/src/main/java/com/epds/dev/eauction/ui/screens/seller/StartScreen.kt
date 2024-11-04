package com.epds.dev.eauction.ui.screens.seller

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.epds.dev.eauction.ui.theme.AppTheme


@Composable
fun StartScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .border(1.dp, Color.Red)
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight(0.66f)
                .fillMaxWidth()
                .border(1.dp, Color.Blue)
        ){
            Text(
                text = "Welcome to",
                style = AppTheme.typography.headingSmall,
                color = AppTheme.colors.base900
            )
            Text(
                text = "eAuction",
                style = AppTheme.typography.headingXXL,
                color = AppTheme.colors.base900
            )
        }
        Spacer(Modifier.fillMaxWidth().height(16.dp))
        Column(
            modifier = Modifier.fillMaxHeight()
                .fillMaxWidth()
                .border(1.dp, Color.Green)
        ){

        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    AppTheme {
        StartScreen()
    }
}
