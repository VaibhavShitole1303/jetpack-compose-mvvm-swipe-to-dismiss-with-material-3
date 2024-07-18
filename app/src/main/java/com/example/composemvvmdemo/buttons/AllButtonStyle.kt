package com.example.composemvvmdemo.buttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AllButtonStyle() {
    Column {


        Text(text = "Buttons", style = typography.bodyMedium, modifier = Modifier.padding(8.dp))

        Row {


            Button(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Text(text = "Main Button")
            }


            TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
                Text(text = "Text Button")
            }
        }

        Row {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
                elevation = ButtonDefaults.buttonElevation()
            ) {
                Text(text = "Elevated Button")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Rounded")
            }
        }

        Row {
            OutlinedButton(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, Color.Red),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Outlined")
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, Color.Red),
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(text = "Outlined Icon")
            }
        }

        Row {
            Button(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Row {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Icon Button")
                }
            }
            Button(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Text(text = "Icon Button")
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        val mainButtonColor = ButtonDefaults.buttonColors(
            contentColor = Color.Magenta
        )

        Row {
            Button(colors = mainButtonColor, onClick = {}, modifier = Modifier.padding(8.dp)) {
                Text(text = "Custom colors")
            }
        }

        Row {
            val horizontalGradient = Brush.horizontalGradient(
                colors = listOf(Color.Cyan, Color.Magenta),
                0f,
                250f
            )
            Text(
                text = "Horizontal gradient",
                style = typography.bodyMedium.copy(color = Color.White),
                modifier = Modifier
                    .padding(12.dp)
                    .clickable(onClick = {})
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush = horizontalGradient)
                    .padding(12.dp)
            )
            val verticalGradient = Brush.verticalGradient(
                colors = listOf(Color.Blue, Color.Gray),
                startY = 0f,
                endY = 100f
            )
            Text(
                text = "Vertical gradient",
                style = typography.bodyMedium.copy(color = Color.White),
                modifier = Modifier
                    .padding(12.dp)
                    .clickable(onClick = {})
                    .clip(RoundedCornerShape(4.dp))
                    .background(brush = verticalGradient)
                    .padding(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAllButtonStyle() {
    AllButtonStyle()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllButtonStyle()
        }
    }
}
