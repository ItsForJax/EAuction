package com.epds.dev.eauction.ui.screens.seller

import com.epds.dev.eauction.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.epds.dev.eauction.ui.theme.AppTheme


@Composable
fun StartScreen() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(32.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight(0.66f)
                .fillMaxWidth()
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
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
                .fillMaxWidth()
        ){
            Card(
                shape = RoundedCornerShape(64.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = AppTheme.colors.base800,
                    contentColor = AppTheme.colors.white
                )
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Register",
                        style = AppTheme.typography.buttonLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }
            Spacer(Modifier.fillMaxWidth().height(14.dp))
            Card(
                shape = RoundedCornerShape(64.dp),
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(2.dp, AppTheme.colors.base800),
                colors = CardDefaults.cardColors(
                    containerColor = AppTheme.colors.white,
                    contentColor = AppTheme.colors.base800
                )
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Sign In",
                        style = AppTheme.typography.buttonLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }
            Spacer(Modifier.fillMaxWidth().height(16.dp))
            Text(
                text = "or",
                style = AppTheme.typography.buttonLarge,
                color = AppTheme.colors.base900
            )
            Spacer(Modifier.fillMaxWidth().height(16.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.facebook),
                    contentDescription = "",
                    Modifier.size(38.dp))
                Spacer(Modifier.width(30.dp))
                Image(
                    painter = painterResource(R.drawable.google),
                    contentDescription = "",
                    Modifier.size(30.dp))
                Spacer(Modifier.width(30.dp))
                Image(
                    painter = painterResource(R.drawable.apple),
                    contentDescription = "",
                    Modifier.size(42.dp))
            }
            Spacer(Modifier.fillMaxWidth().height(24.dp))
        }
    }
}