package com.epds.dev.eauction.ui.screens.buyer.main.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.epds.dev.eauction.ui.theme.AppTheme

@Composable
fun ActiveIndicator(noOfLines: Int, noOfActiveLines: Int) {
    Row (Modifier.fillMaxWidth()) {
        for (noOfLine in 1..noOfLines ) {
            Box(
                Modifier.padding(4.dp).weight(1f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        color = if (noOfLine <= noOfActiveLines)
                            AppTheme.colors.base600 else AppTheme.colors.secondaryContainer
                    )
                    .height(4.dp)
            )
        }
    }
}