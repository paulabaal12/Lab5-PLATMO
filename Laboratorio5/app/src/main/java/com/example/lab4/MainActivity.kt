package com.example.lab4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4.ui.theme.Lab4Theme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting1("Campus Central")
                }
            }
        }
    }
}


@Composable
fun Greeting1(name: String) {
    Row {
        Text(
            text = "Campus Central",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
            fontSize = 40.sp
        )

        val context = LocalContext.current
        IconButton(
            onClick = {
                val intent = Intent(context, Menu::class.java)
                context.startActivity(intent)
            }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back to Menu"
            )
        }

    }
    Column(
        modifier = Modifier
            .padding(13.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    )
    {
        Image(
            painter = painterResource(R.drawable.campus_central),
            contentDescription = "Campus Central",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(350.dp)
                .aspectRatio(13f / 10f)
                .fillMaxSize()
        )
        Text(text = "DESTACADOS", fontSize = 25.sp, modifier = Modifier.fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        )
        {
            Column {

                val painter = painterResource(id = R.drawable.servicenow)
                val description = "Service Now"
                val title = "Service Now"
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(1.dp)
                ) {
                    ImageCard1(
                        painter = painter,
                        contentDescription = description,
                        title = title
                    )
                }
            }
            Column {

                val painter = painterResource(id = R.drawable.actualidadddd)
                val description = "Actualidad"
                val title = "Actualidad"
                ImageCard1(
                    painter = painter,
                    contentDescription = description,
                    title = title
                )
            }
        }
        Text(text = "SERVICIOS Y RECURSOS ", fontSize = 25.sp, modifier = Modifier.fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        )
        {
            Column {

                val painter = painterResource(id = R.drawable.estudiantesxd)
                val description = "Directorio de Servicios"
                val title = "Directorio de Servicios"
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(1.dp)
                ) {
                    ImageCard1(
                        painter = painter,
                        contentDescription = description,
                        title = title
                    )
                }
            }
            Column {

                val painter = painterResource(id = R.drawable.bibliotecauvg)
                val description = "Portal WEB Biblioteca UVG"
                val title = "Portal WEB Biblioteca UVG"
                ImageCard1(
                    painter = painter,
                    contentDescription = description,
                    title = title
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting1Preview() {
    Lab4Theme {

        Greeting1("Campus Central ")

    }
}


@Composable
fun ImageCard1(
    painter: Painter,
    contentDescription: String,
    title : String,
    modifier : Modifier = Modifier
) {
    Row {
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            Box(modifier = Modifier.height(150.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 300f

                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(1.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(title, style = TextStyle(Color.White, fontSize = 22.sp))
                }

            }

        }
    } }
