package com.epds.dev.eauction.test

import com.epds.dev.eauction.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Text() {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.size(3.dp, 19.dp)) {
        Spacer(
            modifier = Modifier
                .size(2.dp)
                .background(Color(0xFF333333), CircleShape)
        )
        Spacer(Modifier.height(2.dp))
        Spacer(
            modifier = Modifier

                .size(2.dp)
                .background(Color(0xFF333333), CircleShape)
        )
        Spacer(Modifier.height(2.dp))
        Spacer(
            modifier = Modifier
                .size(2.dp)
                .background(Color(0xFF333333), CircleShape)
        )
    }
}

@Preview()
@Composable
fun TextPre() {
    Text()
}
