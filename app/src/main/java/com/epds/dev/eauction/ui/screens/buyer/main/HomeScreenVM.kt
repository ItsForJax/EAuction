package com.epds.dev.eauction.ui.screens.buyer.main


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeScreenVM : ViewModel() {
    var text : String by mutableStateOf("")

}