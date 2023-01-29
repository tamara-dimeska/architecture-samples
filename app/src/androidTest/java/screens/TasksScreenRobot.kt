package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.android.architecture.blueprints.todoapp.R
import androidx.test.core.app.ApplicationProvider

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

fun tasksScreen(
    composeTestRule: ComposeTestRule,
    func: TasksScreenRobot.() -> Unit
) = TasksScreenRobot(composeTestRule).apply { func() }

class TasksScreenRobot(semanticsProvider: SemanticsNodeInteractionsProvider) :
    BaseRobotScreen(
        semanticsProvider = semanticsProvider
    ) {

    private val addTaskButton = targetContext.resources.getString(R.string.add_task)
    private val checkboxButton = "checkbox_button"

    fun openAddNewTask() {
        composeTestRule.onNodeWithContentDescription(addTaskButton).performClick()
    }

    fun tapOnFirstCheckbox() {
        composeTestRule.onAllNodesWithTag(checkboxButton).onFirst().performClick()
    }

    fun assertTaskIsDisplayed(title: String) {
        composeTestRule.onNodeWithText(title).assertIsDisplayed()
    }

    fun assertTaskIsNotDisplayed(title: String) {
        composeTestRule.onNodeWithText(title).assertDoesNotExist()
    }

    fun assertTaskIsMarkedAsComplete() {
        composeTestRule.onNodeWithTag(checkboxButton).assertIsOn()
    }

    fun assertTaskIsMarkedAsActive() {
        composeTestRule.onNodeWithTag(checkboxButton).assertIsOff()
    }
}
