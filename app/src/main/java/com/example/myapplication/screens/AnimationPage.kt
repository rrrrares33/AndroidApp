package com.example.myapplication.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.layoutId
import com.example.myapplication.R

@ExperimentalMotionApi
@Composable
fun AnimationPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
       CircularPosition()
    }
}


@ExperimentalMotionApi
@Composable
fun CircularPosition() {
    var animateToEnd by remember { mutableStateOf(false) }
    val progress by animateFloatAsState(
        targetValue = if (animateToEnd) 1f else 0f,
        animationSpec = tween(4000)
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                animateToEnd = !animateToEnd
            },
            modifier = Modifier.padding(top = 5.dp)
        ) {
            Text(text = "Press for cool MotionLayout animation")
        }

        MotionLayout(
            ConstraintSet(
                content = """
                    {
                      h1: { circular: ['parent', 0, 30] },
                      h2: { circular: ['parent', 40, 30], rotationZ: 40 },
                      h3: { circular: ['parent', 80, 30], rotationZ: 80 },
                      h4: { circular: ['parent', 120, 30], rotationZ: 120 },
                      h5: { circular: ['parent', 160, 30], rotationZ: 160 },
                      h6: { circular: ['parent', 200, 30], rotationZ: 200 },
                      h7: { circular: ['parent', 240, 30], rotationZ: 240 },
                      h8: { circular: ['parent', 280, 30], rotationZ: 280 },
                      h9: { circular: ['parent', 320, 30], rotationZ: 320 }
                    }
                """
            ),
            ConstraintSet(
                """
                    {
                      h1: { circular: ['parent', 0, 70], rotationZ: 360 },
                      h2: { circular: ['parent', 40, 70], rotationZ: 400 },
                      h3: { circular: ['parent', 80, 70], rotationZ: 440 },
                      h4: { circular: ['parent', 120, 70], rotationZ: 480 },
                      h5: { circular: ['parent', 160, 70], rotationZ: 520 },
                      h6: { circular: ['parent', 200, 70], rotationZ: 560 },
                      h7: { circular: ['parent', 240, 70], rotationZ: 600 },
                      h8: { circular: ['parent', 280, 70], rotationZ: 640 },
                      h9: { circular: ['parent', 320, 70], rotationZ: 680 },
                    }
                """.trimIndent()
            ),
            progress = progress,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .layoutId("h1")
                    .width(75.dp)
                    .height(30.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .layoutId("h2")
                    .width(75.dp)
                    .height(30.dp)
                    .background(Color.Green)
            )
            Box(
                modifier = Modifier
                    .layoutId("h3")
                    .width(75.dp)
                    .height(30.dp)
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .layoutId("h4")
                    .width(75.dp)
                    .height(30.dp)
                    .background(Color.Gray)
            )
            Box(
                modifier = Modifier
                    .layoutId("h5")
                    .width(75.dp)
                    .height(30.dp)
                    .background(Color.Yellow)
            )
            Box(
                modifier = Modifier
                    .layoutId("h6")
                    .width(75.dp)
                    .height(30.dp)
                    .background(Color.Cyan)
            )
            Box(
                modifier = Modifier
                    .layoutId("h7")
                    .width(75.dp)
                    .height(30.dp)
                    .background(Color.Magenta)
            )
            Box(
                modifier = Modifier
                    .layoutId("h8")
                    .width(75.dp)
                    .height(30.dp)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .layoutId("h9")
                    .width(75.dp)
                    .height(30.dp)
                    .background(Color.DarkGray)
            )
        }
    }
}
