package com.example.remed.features.presentation

import android.os.Build
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.remed.features.domain.alarm.AlarmScheduler
import com.example.remed.features.domain.alarm.AlarmSchedulerImpl
import com.example.remed.features.domain.model.Alarm
import java.time.LocalDateTime

@Composable
fun AlarmTestScreen() {

    val alarmScheduler : AlarmScheduler = AlarmSchedulerImpl(LocalContext.current)
    var alarmTime: Alarm? = null

    var secondText by remember { mutableStateOf("") }
    var messageText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(value = secondText, onValueChange = {
            secondText = it
        },
            label = {
                Text(text = "Delay Second")
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = messageText, onValueChange = {
            messageText = it
        },
            label = {
                Text(text = "Message")
            },
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    alarmTime = Alarm(
                        alarmTime = LocalDateTime.now().plusSeconds(
                            secondText.toLong()
                        ),
                        message = messageText
                    )
                }
                alarmTime?.let {
                    alarmScheduler.schedule(it)
                }
                secondText = ""
                messageText = ""

            }) {
                Text(text = "Schedule")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                alarmScheduler::cancel
            }) {
                Text(text = "Cancel")
            }
            Spacer(modifier = Modifier.width(8.dp))
        }

    }
}