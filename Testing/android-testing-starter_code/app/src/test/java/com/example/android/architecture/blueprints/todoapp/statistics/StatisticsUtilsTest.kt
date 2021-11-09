package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test
import org.hamcrest.Matchers.`is`

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnHundredForActiveAndZeroForCompeted() {
        val tasks = listOf(
            Task(title = "title1", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompleteStats_oneComplete_returnHundredForCompleteAndZeroForActive() {
        val tasks = listOf(
            Task(isCompleted = true)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.activeTasksPercent)
        assertEquals(100f, result.completedTasksPercent)
    }

    @Test
    fun getActiveAndCompleteStats_nullTasks_returnTwoZero() {
        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.activeTasksPercent)
        assertEquals(0f, result.completedTasksPercent)
    }

    @Test
    fun getActiveAndCompleteStats_emptyTasks_returnTwoZero() {
        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.activeTasksPercent)
        assertEquals(0f, result.completedTasksPercent)
    }

    @Test
    fun getActiveAndCompleteTasks_both_returnFortyForActiveAndSixtyForCompete() {
        val tasks = listOf(
            Task(isCompleted = false),
            Task(isCompleted = false),
            Task(isCompleted = true),
            Task(isCompleted = true),
            Task(isCompleted = true),
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(40f, result.activeTasksPercent)
        assertEquals(60f, result.completedTasksPercent)
    }
}