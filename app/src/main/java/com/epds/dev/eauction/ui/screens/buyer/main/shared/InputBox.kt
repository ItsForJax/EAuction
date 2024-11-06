package com.epds.dev.eauction.ui.screens.buyer.main.shared

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.epds.dev.eauction.R
import com.epds.dev.eauction.ui.screens.buyer.main.BuyersViewModel
import com.epds.dev.eauction.ui.theme.AppTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

enum class InputType {
    SINGLE_LINE,
    DROP_DOWN,
    STEPPER,
    MULTI_LINE,
    DATE_TIME,
    EMAIL
}

@Composable
fun InputBox(inputType: InputType, placeHolderText: String) {

    var value by remember { mutableStateOf("") }
    var mod = Modifier
        .border(2.dp, AppTheme.colors.base400, shape = RoundedCornerShape(6.dp))
        .fillMaxWidth()
        .padding(horizontal = 16.dp)

    Box (
        if (inputType == InputType.MULTI_LINE) {
            mod.height(120.dp)
        } else {
            mod.height(45.dp)
        }
    ) {
        var basicTFMod = if (inputType != InputType.MULTI_LINE) Modifier
            .fillMaxWidth()
            .align(AbsoluteAlignment.CenterLeft) else
            Modifier
                .fillMaxWidth()
                .align(AbsoluteAlignment.CenterLeft)
                .fillMaxHeight()
                .padding(vertical = 16.dp)

        BasicTextField(
            value = value,
            onValueChange = { value = it },
            textStyle = AppTheme.typography.bodyMedium,
            readOnly = inputType == InputType.DROP_DOWN || inputType == InputType.DATE_TIME ,
            singleLine = inputType != InputType.MULTI_LINE,
            cursorBrush = SolidColor(AppTheme.colors.base800),
            modifier = basicTFMod,
            keyboardOptions = if (inputType == InputType.STEPPER) {
                KeyboardOptions(keyboardType = KeyboardType.Number)
            }else if (inputType == InputType.EMAIL) {
                KeyboardOptions(keyboardType = KeyboardType.Email)
            }else {
                KeyboardOptions(keyboardType = KeyboardType.Text)
            }
        )

        // Add the placeholder
        if (value.isEmpty()) {
            Text(
                text = placeHolderText,
                style = AppTheme.typography.bodyMedium,
                color = AppTheme.colors.base600,
                modifier = basicTFMod
            )
        }

        when (inputType) {
            InputType.SINGLE_LINE -> {

            }
            InputType.DROP_DOWN -> {
                Icon(
                    painter = painterResource(R.drawable.drop_down),
                    contentDescription = "",
                    modifier = Modifier
                        .align(AbsoluteAlignment.CenterRight)
                        .width(18.dp)
                )
            }
            InputType.STEPPER -> {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .align(AbsoluteAlignment.CenterRight)
                        .height(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF787880).copy(alpha = .12f))
                ){
                    Spacer(Modifier.width(14.dp))
                    Icon(
                        painter = painterResource(R.drawable.decrement),
                        contentDescription = "",
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(14.dp))
                    Spacer(
                        Modifier
                            .height(22.dp)
                            .width(2.dp)
                            .padding(vertical = 4.dp)
                            .background(Color(0xFF3C3C43).copy(alpha = 0.3f)))
                    Spacer(Modifier.width(14.dp))
                    Icon(
                        painter = painterResource(R.drawable.increment),
                        contentDescription = "",
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(14.dp))
                }
            }
            InputType.MULTI_LINE -> {

            }
            InputType.EMAIL -> {

            }
            InputType.DATE_TIME -> {
                // State for showing date and time picker dialogs
                val context = LocalContext.current
                val calendar = remember { Calendar.getInstance() }

                // Function to open the TimePickerDialog
                fun openTimePicker() {
                    TimePickerDialog(
                        context,
                        { _, hour, minute ->
                            calendar.set(Calendar.HOUR_OF_DAY, hour)
                            calendar.set(Calendar.MINUTE, minute)
                            value = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(calendar.time)
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        true
                    ).show()
                }

                // Function to open the DatePickerDialog
                fun openDatePicker() {
                    DatePickerDialog(
                        context,
                        { _, year, month, dayOfMonth ->
                            calendar.set(year, month, dayOfMonth)
                            openTimePicker() // Opens time picker after selecting date
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    ).show()
                }

                Icon(
                    painter = painterResource(R.drawable.calendar),
                    contentDescription = "Open DateTime Picker",
                    modifier = Modifier
                        .align(AbsoluteAlignment.CenterRight)
                        .width(18.dp)
                        .clickable { openDatePicker() }
                )

            }
        }
    }

}