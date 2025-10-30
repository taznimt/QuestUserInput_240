package com.example.input

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import java.lang.reflect.Modifier

@Composable
fun FormDataDiri(modifier: Modifier){
    var textNama by remember { mutableSetOf(value = "") }
}