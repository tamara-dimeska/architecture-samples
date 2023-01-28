package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

class StatisticsScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<StatisticsScreen>(
        semanticsProvider = semanticsProvider
    ) {

    private val composeTestRule = semanticsProvider as ComposeTestRule

    private fun getActiveTasksText(tasksPercentage: Double): KNode {
        return child { hasText("Active tasks: $tasksPercentage%") }
    }

    private fun getCompletedTasksText(tasksPercentage: Double): KNode {
        return child { hasText("Completed tasks: $tasksPercentage%") }
    }

    fun assertActiveTasks(tasksPercentage: Double) {
        onComposeScreen<StatisticsScreen>(composeTestRule) {
            getActiveTasksText(tasksPercentage).assertIsDisplayed()
        }
    }

    fun assertCompletedTasks(tasksPercentage: Double) {
        onComposeScreen<StatisticsScreen>(composeTestRule) {
            getCompletedTasksText(tasksPercentage).assertIsDisplayed()
        }
    }
}
