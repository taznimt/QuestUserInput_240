package com.example.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.collections.forEach

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val status1 = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Judul Form
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB39DDB))
                .padding(vertical = 24.dp)
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Nama
                Text("NAMA LENGKAP", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = textNama,
                    onValueChange = { textNama = it },
                    label = { Text("Isian Nama Lengkap") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.DarkGray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Jenis Kelamin
                Text("JENIS KELAMIN", fontWeight = FontWeight.Bold)
                Column {
                    gender.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = textJK == item,
                                    onClick = { textJK = item }
                                )
                                .padding(vertical = 4.dp)
                        ) {
                            RadioButton(selected = textJK == item, onClick = { textJK = item })
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(item)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Status Perkawinan
                Text("STATUS PERKAWINAN", fontWeight = FontWeight.Bold)
                Column {
                    status1.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = textStatus == item,
                                    onClick = { textStatus = item }
                                )
                                .padding(vertical = 4.dp)
                        ) {
                            RadioButton(selected = textStatus == item, onClick = { textStatus = item })
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(item)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Alamat
                Text("ALAMAT", fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = textAlamat,
                    onValueChange = { textAlamat = it },
                    label = { Text("Alamat") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.DarkGray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Tombol Submit
                Button(
                    onClick = {
                        // Simpan data ke variabel hasil submit
                        nama = textNama
                        jenis = textJK
                        status = textStatus
                        alamat = textAlamat

                        // Reset field input agar kosong
                        textNama = ""
                        textAlamat = ""
                        textJK = ""
                        textStatus = ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7))
                ) {
                    Text("Submit", color = Color.White)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Card Hasil Submit
                if (nama.isNotEmpty()) {
                    ElevatedCard(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF512DA8)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text("Nama   : $nama", color = Color.White)
                            Text("Gender : $jenis", color = Color.White)
                            Text("Status : $status", color = Color.White)
                            Text("Alamat : $alamat", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}