package com.epds.dev.eauction.ui.screens.buyer.main.shared

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.epds.dev.eauction.ui.theme.AppTheme
import com.epds.dev.eauction.utilities.SignIn

@Composable
fun Button (title: String, filled: Boolean, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(64.dp),
        modifier = modifier.fillMaxWidth(),
        border = if (!filled) BorderStroke(2.dp, AppTheme.colors.base800) else null,
        colors =
        if (!filled) CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = AppTheme.colors.base800
        ) else CardDefaults.cardColors(
            containerColor = AppTheme.colors.base800,
            contentColor = AppTheme.colors.white
        ),
        onClick = { }
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = AppTheme.typography.buttonLarge,
                modifier = Modifier.padding(16.dp)
            )
        }

    }
}