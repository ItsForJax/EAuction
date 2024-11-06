package com.epds.dev.eauction.ui.screens.buyer.main


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BuyersViewModel : ViewModel() {
//    Home
    var searchText : String by mutableStateOf("")

//    Create Auction Page 1
    var titleText : String by mutableStateOf("")
    var categoryText : String by mutableStateOf("")
    var conditionText : String by mutableStateOf("")
    var quantityText : String by mutableStateOf("")
    var descriptionText : String by mutableStateOf("")
    var emailText : String by mutableStateOf("")

}