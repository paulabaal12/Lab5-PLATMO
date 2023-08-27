package com.example.lab4
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4.ui.theme.Lab4Theme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.lab4.R

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("My Profile")
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .padding(0.5.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Text(
                text = "My Profile",
                fontFamily = FontFamily.Serif, textAlign = TextAlign.Center,
                fontSize = 22.sp, modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold
            )

            Icon(
                painter = painterResource(id = R.drawable.baseline_settings_24),
                contentDescription = "Icono de perfil",
                modifier = Modifier
                    .size(45.dp),
                tint = Color.Unspecified
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

        Box(
            modifier = Modifier
                .height(140.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.bibliotecafondito),
                contentDescription = "Fondo de biblioteca",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Image(
                painter = painterResource(id = R.drawable.taylor_suift),
                contentDescription = "Foto de perfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.Center)
                    .offset(y = 30.dp) // Mover hacia abajo
                    .clip(CircleShape)
            )
        }
        Text(
            text = "TAYLOR ALISON SWIFT",
            fontFamily = FontFamily.Serif,
            fontSize = 22.sp, modifier = Modifier
                .padding(top = 23.dp), fontWeight = FontWeight.Bold
        )
        val itemList = listOf(
            "My Campus" to R.drawable.campus,
            "My Friends" to R.drawable.friends,
            "My Calendar" to R.drawable.calendario,
            "My Courses" to R.drawable.clases,
            "My Grades" to R.drawable.grades,
            "My Groups" to R.drawable.grupito,
            "My Upcoming Events" to R.drawable.event
        )

        LazyColumn {
            itemsIndexed(
                items = itemList
            ) { index, (text, iconResId) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.Gray),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Icon(
                        painter = painterResource(id = iconResId),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(48.dp),
                        tint = Color.Unspecified
                    )
                    Text(
                        text = text,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            }
        }

    }

    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab4Theme {

        Greeting("Campus Central ")

    }
}

