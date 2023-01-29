package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

fun newTaskScreen(
    composeTestRule: ComposeTestRule,
    func: NewTaskScreenRobot.() -> Unit
) = NewTaskScreenRobot(composeTestRule).apply { func() }

class NewTaskScreenRobot(semanticsProvider: SemanticsNodeInteractionsProvider) :
    BaseRobotScreen(
        semanticsProvider = semanticsProvider
    ) {

    private val titleField = targetContext.resources.getString(R.string.title_hint)
    private val descriptionField = targetContext.resources.getString(R.string.description_hint)
    private val saveTaskButton = targetContext.resources.getString(R.string.cd_save_task)
    private val newTaskScreenTitle = targetContext.resources.getString(R.string.add_task)
    private val backButton = targetContext.resources.getString(R.string.menu_back)

    fun addTitle(title: String) {
        composeTestRule.onNodeWithText(titleField).performTextInput(title)
    }

    fun addDescription(description: String) {
        composeTestRule.onNodeWithText(descriptionField).performTextInput(description)
    }

    fun saveNewTask() {
        composeTestRule.onNodeWithContentDescription(saveTaskButton).performClick()
    }

    fun tapBackButton() {
        composeTestRule.onNodeWithContentDescription(backButton).performClick()
    }

    fun assertScreenTitleIsDisplayed() {
        composeTestRule.onNodeWithText(newTaskScreenTitle).assertIsDisplayed()
    }
}
