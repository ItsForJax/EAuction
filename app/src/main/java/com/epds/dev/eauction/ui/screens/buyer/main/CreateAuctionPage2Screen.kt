package com.epds.dev.eauction.ui.screens.buyer.main

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.epds.dev.eauction.R
import com.epds.dev.eauction.ui.screens.buyer.main.shared.ActiveIndicator
import com.epds.dev.eauction.ui.screens.buyer.main.shared.Button
import com.epds.dev.eauction.ui.screens.buyer.main.shared.InputBox
import com.epds.dev.eauction.ui.screens.buyer.main.shared.InputType
import com.epds.dev.eauction.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAuctionPage2Screen(modifier: Modifier) {
    var length by remember { mutableFloatStateOf(.5f) }
    Box(modifier = modifier
        .padding(16.dp))
    {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter).background(
                AppTheme.colors.white
            ).zIndex(10f)
        ) {
            Text(
                text = "Add Auction",
                style = AppTheme.typography.headingSmall.copy(textAlign = TextAlign.Center),
                color = AppTheme.colors.base800,
                modifier = Modifier.fillMaxWidth()
            )
            Icon(
                painter = painterResource(R.drawable.arrow),
                contentDescription = "Close",
                modifier = Modifier
                    .align(AbsoluteAlignment.CenterLeft)
                    .size(20.dp)
            )
        }
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Spacer(Modifier.height(48.dp))
            ActiveIndicator(noOfActiveLines = 2, noOfLines = 2)
            Spacer(Modifier.height(14.dp))
            Text(
                text = "Warranty Length: ${length.toInt()} years",
                style = AppTheme.typography.semiBold,
                color = AppTheme.colors.base800,
                modifier = Modifier.fillMaxWidth()
            )
            Column {
                Slider(
                    value = length,
                    onValueChange = { length = it },
                    valueRange = 1f..100f,
                    colors = SliderDefaults.colors(
                        thumbColor = AppTheme.colors.base800,
                        activeTrackColor = AppTheme.colors.base800, // Unchanging track color
                        inactiveTrackColor = AppTheme.colors.base400 // Matches the active track color so it doesn’t change
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    thumb = {
                        Box(Modifier.size(24.dp).background(Color.White).border(3.dp, AppTheme.colors.base800, CircleShape))
                    },
                    track = {
                        Box(Modifier.fillMaxWidth().height(3.dp).background(AppTheme.colors.base400).border(1.dp,
                            AppTheme.colors.base400,RoundedCornerShape(14.dp)))
                    }
                )
                Row (horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "1 year",
                        style = AppTheme.typography.bodySmall,
                        color = AppTheme.colors.base800,
                    )
                    Text(
                        text = "100 years",
                        style = AppTheme.typography.bodySmall,
                        color = AppTheme.colors.base800,
                    )
                }
            }
            Spacer(Modifier.height(14.dp))
            InputBox(inputType = InputType.SINGLE_LINE ,placeHolderText = "Budget (Optional)")
            Spacer(Modifier.height(14.dp))
            InputBox(inputType = InputType.DATE_TIME ,placeHolderText = "End Date/Time")
            Spacer(Modifier.height(14.dp))
            Text(
                text = buildAnnotatedString {
                    append("Document Attachments: ")
                    withStyle(style = SpanStyle(color = AppTheme.colors.base600)) {
                        append("(Optional)") // Change color for "Optional"
                    }
                },
                style = AppTheme.typography.semiBold,
                color = AppTheme.colors.base800,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(14.dp))
            Upload()
            Spacer(Modifier.height(14.dp))
            Text(
                text = buildAnnotatedString {
                    append("Add Stakeholders: ")
                    withStyle(style = SpanStyle(color = AppTheme.colors.base600)) {
                        append("(Optional)") // Change color for "Optional"
                    }
                },
                style = AppTheme.typography.semiBold,
                color = AppTheme.colors.base800,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(14.dp))
            InputBox(inputType = InputType.EMAIL, placeHolderText = "Email")
            Spacer(Modifier.height(14.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                Card (
                    shape = RoundedCornerShape(6.dp),
                    colors = CardColors(
                        contentColor = AppTheme.colors.white,
                        containerColor = AppTheme.colors.base800,
                        disabledContainerColor = AppTheme.colors.white,
                        disabledContentColor = AppTheme.colors.white,
                    )
                ) {
                    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 10.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.white_add),
                            contentDescription = "",
                            Modifier.size(15.dp)
                        )
                        Text(text = "Add",
                            style = AppTheme.typography.semiBold,
                            modifier = Modifier.padding(5.dp))
                    }
                }
            }
            Spacer(Modifier.height(100.dp))
        }

        Button(title = "Post", filled = true, Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Upload() {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =  Modifier
            .fillMaxWidth()
            .height(165.dp)
            .drawBehind {
                drawRoundRect(color = Color(0xFFCBD2E0), style = Stroke(width = 4f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 20f), 0f)
                ))
            }
    ) {
        Image(
            painter = painterResource(R.drawable.upload),
            contentDescription = "",
            modifier = Modifier.height(95.dp)
        )
        Spacer(Modifier.height(3.dp))
        Text(
            text = "Upload an image/ file",
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.base800,
        )
    }
}