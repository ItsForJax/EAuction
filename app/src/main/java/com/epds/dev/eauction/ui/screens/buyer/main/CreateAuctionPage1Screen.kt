package com.epds.dev.eauction.ui.screens.buyer.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import com.epds.dev.eauction.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.epds.dev.eauction.ui.screens.buyer.main.shared.ActiveIndicator
import com.epds.dev.eauction.ui.screens.buyer.main.shared.Button
import com.epds.dev.eauction.ui.screens.buyer.main.shared.InputBox
import com.epds.dev.eauction.ui.screens.buyer.main.shared.InputType
import com.epds.dev.eauction.ui.theme.AppTheme

@Composable
fun CreateAuctionPage1Screen(modifier: Modifier) {
    val viewModel : BuyersViewModel = viewModel()
    Box(modifier = modifier
        .padding(16.dp))
    {
        Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(contentAlignment = Alignment.Center,
                modifier =  Modifier.fillMaxWidth()) {
                Text(
                    text = "Add Auction",
                    style = AppTheme.typography.headingSmall.copy(textAlign = TextAlign.Center),
                    color = AppTheme.colors.base800,
                    modifier = Modifier.fillMaxWidth()
                )
                Icon(
                    painter =  painterResource(R.drawable.close),
                    contentDescription = "Close",
                    modifier = Modifier.align(AbsoluteAlignment.CenterRight)
                        .size(24.dp)
                )
            }
            Spacer(Modifier.height(14.dp))
            ActiveIndicator(noOfLines = 2 ,noOfActiveLines = 1)
            Spacer(Modifier.height(14.dp))
            InputBox(inputType = InputType.SINGLE_LINE, placeHolderText = "Title")
            Spacer(Modifier.height(14.dp))
            InputBox(inputType = InputType.DROP_DOWN, placeHolderText = "Category")
            Spacer(Modifier.height(14.dp))
            InputBox(inputType = InputType.DROP_DOWN, placeHolderText = "Condition")
            Spacer(Modifier.height(14.dp))
            InputBox(inputType = InputType.STEPPER, placeHolderText = "Quantity")
            Spacer(Modifier.height(14.dp))
            InputBox(inputType = InputType.MULTI_LINE, placeHolderText = "Description...")
            Spacer(Modifier.height(14.dp))
            Text(
                text = "Choose an icon for this auction:",
                style = AppTheme.typography.bodyMedium,
                color = AppTheme.colors.base800,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(14.dp))
            Column (
                modifier =  Modifier.fillMaxWidth()) {
                for (row in 1..2){
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier =  Modifier.fillMaxWidth()
                    ) {
                        for (col in 1..7) {
                            Image(
                                painter = if (col%2 == 1) painterResource(R.drawable.vase) else painterResource(R.drawable.pillar),
                                contentDescription = "",
                                modifier = Modifier.clip(CircleShape).size(40.dp).border(1.5.dp, AppTheme.colors.base400, shape = CircleShape)
                            )
                        }
                    }

                    if (row == 1) {
                        Spacer(Modifier.height(14.dp))
                    }

                }
            }
        }
        Button(title = "Next", filled = true, Modifier.align(Alignment.BottomCenter))
    }

}