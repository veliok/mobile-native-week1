package com.example.week1.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.week1.domain.*

@Composable
fun HomeScreen() {
    var tasks by remember { mutableStateOf(mockTasks) }
    var visibleTasks by remember { mutableStateOf(mockTasks) }
    var showOnlyDone by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(18.dp)
    ) {
        Spacer(modifier = Modifier.height(38.dp))
        Text(
            text = "Viikko 1 Tehtävälista",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(14.dp))

        /* NAPIT */
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // UUSI TASK
            Button(onClick = {
                val newTask = Task(
                    id = tasks.size + 1,
                    title = "Task ${tasks.size + 1}",
                    description = "New task",
                    priority = 1,
                    dueDate = "2026-10-31",
                    done = false
                )
                tasks = addTask(tasks, newTask)
                visibleTasks = if (showOnlyDone) {
                    filterByDone(tasks, true)
                } else {
                    tasks
                }
            }) {
                Text("Add task")
            }

            // SHOW DONE / ALL
            Button(onClick = {
                showOnlyDone = !showOnlyDone
                visibleTasks = if (showOnlyDone) {
                    filterByDone(tasks, true)
                } else {
                    tasks
                }
            }) {
                Text(if (showOnlyDone) "Show all" else "Show done")
            }

            // SORT
            Button(onClick = { visibleTasks = sortByDueDate(visibleTasks) }) {
                Text("Sort")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Tehtävät:" ,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            style = MaterialTheme.typography.headlineMedium
        )

        /* TASKIT */
        visibleTasks.forEach { task ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(task.title)
                    Text(task.description, style = MaterialTheme.typography.bodySmall)
                    Text(
                        text = "Due: ${task.dueDate}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                // Toggle nappi jokaiselle taskille
                Button(onClick = {
                    tasks = toggleDone(tasks, task.id)
                    visibleTasks = if (showOnlyDone) { filterByDone(tasks, true) }
                    else { tasks }
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (task.done) { MaterialTheme.colorScheme.secondary }
                        else { MaterialTheme.colorScheme.primary }
                    )
                ) {
                    Text(if (task.done) "Undo" else "Do")
                }
            }
            HorizontalDivider()
        }
    }
}