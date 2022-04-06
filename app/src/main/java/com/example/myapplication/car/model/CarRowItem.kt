package com.example.myapplication.car.model

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity

@Composable
fun CarRowItem(car: Car) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = androidx.compose.foundation.shape.CornerSize(16.dp))

    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .width(200.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = car.manufacture, style = typography.h6)
                Text(text = "Model: " + car.model, style = typography.caption)
                Text(text = "Km: " + car.km.toString(), style = typography.caption)
                Text(
                    text = "Price " + car.price.toString() + "$",
                    style = typography.caption,
                    textAlign = TextAlign.End
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                IconButton(
                    onClick = {
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(
                                Intent.EXTRA_TEXT,
                                car.manufacture + ' ' + car.model + ' ' + car.price.toString() + '$'
                            )
                            type = "text/plain"
                        }

                        val shareIntent = Intent.createChooser(sendIntent, "Share to:")

                        context.startActivity(shareIntent)
                    })
                { Icon(Icons.Filled.Share, contentDescription = "Share", tint = Color.Black) }
            }
        }
    }
}