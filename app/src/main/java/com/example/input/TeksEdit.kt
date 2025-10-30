package com.example.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import java.lang.reflect.Modifier

@Composable
fun FormDataDiri(modifier: Modifier){
    var textNama by remember { mutableSetOf(value = "") }
    var textAlamat by remember { mutableSetOf(value = "") }
    var textJK by remember { mutableSetOf(value = "") }

    var nama by remember { mutableSetOf(value = "") }
    var alamat by remember { mutableSetOf(value = "") }
    var jenis by remember { mutableSetOf(value = "") }

    val gender: List<String>= listof("Laki-laki","Perempuan")

    Column(modifier= Modifier.padding(top= 50.dp),
        verticalArrangement = Arrangement.Top,
        )


}