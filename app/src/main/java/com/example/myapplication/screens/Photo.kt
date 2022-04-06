package com.example.myapplication.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.sharp.Camera
import androidx.compose.material.icons.sharp.CameraEnhance
import androidx.compose.material.icons.sharp.CameraFront
import androidx.compose.material.icons.sharp.CameraRear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.camera.CameraActivity


@Composable
fun Photo() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 30.dp),
            onClick = {
                val takePictureIntent = Intent(context, CameraActivity::class.java)
                context.startActivity(takePictureIntent)
            }) {
            Icon(
                Icons.Sharp.CameraEnhance,
                contentDescription = "Take a photo",
                tint = Color.Black,
                modifier = Modifier.size(70.dp)
            )
        }
        Text("Press on the icon to take a photo!")
    }
}

@Preview(showBackground = true)
@Composable
fun PhotoPreview() {
    Photo()
}