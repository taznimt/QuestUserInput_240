package com.example.input

import android.text.Layout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = textNama,
            singleline = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width = 250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )
        Row {
            gender.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = {textJK = item}
                ), verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        })
                    Text(text = item)
                }
            }
        }

    }


}