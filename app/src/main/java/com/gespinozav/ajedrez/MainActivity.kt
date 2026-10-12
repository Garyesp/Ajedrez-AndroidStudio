package com.gespinozav.ajedrez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.compose.ui.tooling.preview.Preview
import com.gespinozav.ajedrez.ui.theme.AjedrezTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AjedrezTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val colorPrincipal = Color.Red
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),

                        ) {
 //Zona Superior
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.TopCenter)
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(
                                text = "Tablero de Ajedrez"
                            )
                        }
//Zona Centro
                        Column(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .padding(16.dp)
                        ) {
                            val letras = listOf("a", "b", "c", "d", "e", "f", "g", "h")

                            repeat(8) { fila ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "${fila+1}",
                                        color = colorPrincipal,
                                        modifier = Modifier.width(20.dp),
                                        textAlign = TextAlign.Center
                                    )

                                    repeat(8) { columna ->
                                        val colorCasilla =
                                            if ((fila + columna) % 2 == 0) Color.White else Color.Black


                                        Box(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .weight(1f)
                                                .background(colorCasilla)
                                        )
                                    }
                                }
                            }
                            //imprimo solo las letras
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.width(20.dp))

                                repeat(8) { columna ->
                                    Text(
                                        text = letras[columna],
                                        color = colorPrincipal,
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
//Zona Final
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .padding(horizontal = 16.dp, vertical = 16.dp),
//                            horizontalArrangement = Arrangement.Center
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Text(
                                text = ">",
                                color = colorPrincipal,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.weight(1f)
//                                modifier = Modifier.fillMaxWidth()
                            )
//                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "Creado por Gary Espinoza",
                                color = colorPrincipal,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.weight(1f)
//                                modifier = Modifier.fillMaxWidth()
                            )
//                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "v1",
                                color = colorPrincipal,
                                textAlign = TextAlign.End,
                                modifier = Modifier.weight(1f)
//                                modifier = Modifier.fillMaxWidth()
                            )

                        }

                    }

                }
            }
        }
    }
}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    AjedrezTheme {
//        Greeting("Gary")
//    }
//}