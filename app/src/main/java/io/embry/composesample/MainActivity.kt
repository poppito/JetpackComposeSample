package io.embry.composesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.themeTextStyle
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.ParagraphStyle
import androidx.ui.text.style.TextAlign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlexColumn(
                crossAxisSize = LayoutSize.Wrap,
                crossAxisAlignment = CrossAxisAlignment.Start,
                modifier = Spacing(16.dp)
            ) {
                flexible(flex = 1f) {
                    VerticalScroller {
                        Column(
                            crossAxisSize = LayoutSize.Wrap,
                            crossAxisAlignment = CrossAxisAlignment.Stretch,
                            modifier = Spacing(16.dp)
                        ) {
                            MaterialTheme {
                                switchScreen(Screen.TopLevel)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun switchScreen(screen: Screen) {
        if (screen == Screen.TopLevel) {
            greeting(name = "Helen")
            newsStory()
        } else {
            someText()
        }
    }

    @Composable
    fun greeting(name: String) {
        Ripple(bounded = true) {
            Clickable(onClick = {

            }) {
                MaterialTheme() {
                    Text(text = "Hey, $name", style = (+themeTextStyle { h5 }).withOpacity(0.9f))
                }
            }
        }
        HeightSpacer(height = 16.dp)
    }

    @Composable
    fun someText() {
        Text("Oh wow, did this work?", style = (+themeTextStyle { subtitle2 }).withOpacity(0.6f))
    }

    @Composable
    fun newsStory() {
        val paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center)
        val image = +imageResource(R.drawable.brighton_boxes)
        Container(expanded = true, height = 180.dp) {
            Clip(shape = RoundedCornerShape(8.dp)) {
                DrawImage(image = image)
            }
        }
        HeightSpacer(16.dp)
        Text(
            "A day at Brighton beach",
            style = (+themeTextStyle { h6 }).withOpacity(0.9f),
            paragraphStyle = paragraphStyle
        )
        Text(
            "Although, I prefer anywhere along the Surf coast",
            style = (+themeTextStyle { body1 }).withOpacity(0.87f),
            paragraphStyle = paragraphStyle
        )
        Text(
            "Sometimes, though the tropical weather of the top end is more appealing, minus the crocs.",
            style = (+themeTextStyle { body1 }).withOpacity(0.6f),
            paragraphStyle = paragraphStyle
        )
    }
}