package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

fun statisticsScreen(
    composeTestRule: ComposeTestRule,
    func: StatisticsScreenRobot.() -> Unit
) = StatisticsScreenRobot(composeTestRule).apply { func() }

class StatisticsScreenRobot(semanticsProvider: SemanticsNodeInteractionsProvider) :
    BaseRobotScreen(
        semanticsProvider = semanticsProvider
    ) {

    fun assertActiveTasks(tasksPercentage: Double) {
        composeTestRule.onNodeWithText(
            targetContext.resources.getString(R.string.statistics_active_tasks, tasksPercentage)
        )
    }

    fun assertCompletedTasks(tasksPercentage: Double) {
        composeTestRule.onNodeWithText(
            targetContext.resources.getString(R.string.statistics_completed_tasks, tasksPercentage)
        )
    }
}
