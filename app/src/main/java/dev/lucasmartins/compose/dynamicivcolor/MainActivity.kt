package dev.lucasmartins.compose.dynamicivcolor

import dev.lucasmartins.compose.dynamicivcolor.ui.theme.DynamicColorImageVectorTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicColorImageVectorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }


}

@Composable
fun makeIcon(
    viewportWidth: Float = 1058f,
    viewportHeight: Float = 1058f,
    defaultWidth: Dp = 1058.dp,
    defaultHeight: Dp = 1058.dp,
    backgroundColor: Color = MaterialTheme.colors.background,
    primaryColor: Color = MaterialTheme.colors.primary,
    secondaryColor: Color = MaterialTheme.colors.secondary,
): ImageVector {

    return ImageVector.Builder(
        defaultWidth = defaultWidth,
        defaultHeight = defaultHeight,
        viewportWidth = viewportWidth,
        viewportHeight = viewportHeight,
    ).run {
        addPath(
            pathData = addPathNodes("M0,0h1058v1058h-1058z"),
            fill = SolidColor(backgroundColor)
        )
        addPath(
            pathData = addPathNodes("M112,884.1l446.4,-773.1l108.5,62.6l-446.4,773.1z"),
            fill = SolidColor(secondaryColor)
        )
        addPath(
            pathData = addPathNodes("M735,523.7L918.3,841.2H551.8L735,523.7Z"),
            fill = SolidColor(primaryColor)
        )
        build()
    }
}

@Composable
fun Greeting() {
    var primaryColor by remember { mutableStateOf(Color(0xFF50FA7B)) }
    var secondaryColor by remember { mutableStateOf(Color(0xFFff79c6)) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = makeIcon(
                primaryColor = primaryColor,
                secondaryColor = secondaryColor,
                backgroundColor = Color(0xFF282a36)
            ), contentDescription = null
        )
        Text(
            text = "Choose the primary color",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            textAlign = TextAlign.Center,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { primaryColor = Color(0xFF50FA7B) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF50FA7B))
            ) {
                Text(text = "Green")
            }
            Button(
                onClick = { primaryColor = Color(0xFFBD93F9) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFBD93F9))
            ) {
                Text(text = "Purple")
            }
            Button(
                onClick = { primaryColor = Color(0xFFFF5555) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF5555))
            ) {
                Text(text = "Red")
            }
        }

        Text(
            text = "Choose the secondary color",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            textAlign = TextAlign.Center,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { secondaryColor = Color(0xFFff79c6) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFff79c6))
            ) {
                Text(text = "Pink")
            }
            Button(
                onClick = { secondaryColor = Color(0xFFffb86c) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFffb86c))
            ) {
                Text(text = "Orange")
            }
            Button(
                onClick = { secondaryColor = Color(0xFF8be9fd) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF8be9fd))
            ) {
                Text(text = "Cyan")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DynamicColorImageVectorTheme {
        Greeting()
    }
}