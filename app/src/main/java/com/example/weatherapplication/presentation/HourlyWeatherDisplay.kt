package com.example.weatherapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    val formattedTime = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Text(
            text = formattedTime,
            color = Color.Gray
        )
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier
                .height(35.dp)
                .absolutePadding(right = 12.dp)
        )
        Text(
            text = "${weatherData.temperatureCelsius}°C",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}