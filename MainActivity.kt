package com.example.latihan1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.latihan1.ui.theme.Latihan1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Latihan1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        CoverTemplate(
                            nama = "Kaesar Adam Rafano",
                            nim = "235150207111038",
                            mataKuliah = "Pemrograman Mobile",
                            judulTugas = "Tugas 1"
                        )


                        GreetingWithButton(
                            defaultName = "Android",
                            myName = "Kaesar Adam Rafano"
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun CoverTemplate(
    nama: String,
    nim: String,
    mataKuliah: String,
    judulTugas: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = judulTugas,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(8.dp))
            Text("Nama       : $nama")
            Text("NIM        : $nim")
            Text("Mata Kuliah: $mataKuliah")
        }
    }
}


@Composable
fun GreetingWithButton(defaultName: String, myName: String) {
    var name by remember { mutableStateOf(defaultName) }

    Greeting(name = name)
    Spacer(Modifier.height(8.dp))

    Button(onClick = { name = myName }) {
        Text("Tampilkan nama saya")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Latihan1Theme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoverTemplate(
                nama = "Kaesar Adam Rafano",
                nim = "235150207111038",
                mataKuliah = "Pemrograman Mobile",
                judulTugas = "Tugas 1"
            )
            GreetingWithButton(defaultName = "Android", myName = "Kaesar Adam Rafano")
        }
    }
}
