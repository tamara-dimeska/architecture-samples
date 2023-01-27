package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import utils.TestTags

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

class TasksScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<TasksScreen>(
        semanticsProvider = semanticsProvider
    ) {

    private val composeTestRule = semanticsProvider as ComposeTestRule

    private val addTaskButton: KNode = child {
        hasContentDescription(targetContext.resources.getString(R.string.add_task))
    }

    private fun getTaskWithText(title: String): KNode {
        return child { hasText(title) }
    }

    private val checkboxButton: KNode = child {
        hasTestTag(TestTags.CheckBoxButton)
    }

    private val moreMenuButton: KNode = child {
        hasTestTag(TestTags.MoreMenuButton)
    }

    private val clearCompletedButton: KNode = child {
        hasText(targetContext.resources.getString(R.string.menu_clear))
    }

    private val noTasksImage: KNode = child {
        hasContentDescription(targetContext.resources.getString(R.string.no_tasks_image_content_description))
    }

    fun openAddNewTask() {
        onComposeScreen<TasksScreen>(composeTestRule) {
            addTaskButton {
                performClick()
            }
        }
    }

    fun assertTaskIsDisplayed(title: String) {
        onComposeScreen<TasksScreen>(composeTestRule) {
            getTaskWithText(title).assertIsDisplayed()
        }
    }

    fun assertTaskIsNotDisplayed(title: String) {
        onComposeScreen<TasksScreen>(composeTestRule) {
            getTaskWithText(title).assertDoesNotExist()
        }
    }
}
