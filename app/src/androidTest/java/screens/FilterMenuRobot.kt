package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

fun filterMenu(
    composeTestRule: ComposeTestRule,
    func: FilterMenuRobot.() -> Unit
) = FilterMenuRobot(composeTestRule).apply { func() }

class FilterMenuRobot(semanticsProvider: SemanticsNodeInteractionsProvider) :
    BaseRobotScreen(
        semanticsProvider = semanticsProvider
    ) {

    private val activeButton = targetContext.resources.getString(R.string.nav_active)
    private val completedButton = targetContext.resources.getString(R.string.nav_completed)
    private val allButton = targetContext.resources.getString(R.string.nav_all)

    fun filterByActiveTasks() {
        composeTestRule.onNodeWithText(activeButton).performClick()
    }

    fun filterByCompletedTasks() {
        composeTestRule.onNodeWithText(completedButton).performClick()
    }

    fun filterByAllTasks() {
        composeTestRule.onNodeWithText(allButton).performClick()
    }
}
