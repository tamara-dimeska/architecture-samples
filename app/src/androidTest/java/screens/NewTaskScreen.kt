package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

class NewTaskScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<NewTaskScreen>(
        semanticsProvider = semanticsProvider
    ) {

    private val composeTestRule = semanticsProvider as ComposeTestRule

    private val titleField: KNode = child {
        hasText(targetContext.resources.getString(R.string.title_hint))
    }

    private val descriptionField: KNode = child {
        hasText(targetContext.resources.getString(R.string.description_hint))
    }

    private val saveTaskButton: KNode = child {
        hasContentDescription(targetContext.resources.getString(R.string.cd_save_task))
    }

    private val newTaskScreenTitle: KNode = child {
        hasText(targetContext.resources.getString(R.string.add_task))
    }

    private val backButton: KNode = child {
        hasContentDescription(targetContext.resources.getString(R.string.menu_back))
    }

    fun addTitle(title: String) {
        onComposeScreen<NewTaskScreen>(composeTestRule) {
            titleField {
                performTextInput(title)
            }
        }
    }

    fun addDescription(description: String) {
        onComposeScreen<NewTaskScreen>(composeTestRule) {
            descriptionField {
                performTextInput(description)
            }
        }
    }

    fun saveNewTask() {
        onComposeScreen<NewTaskScreen>(composeTestRule) {
            saveTaskButton {
                performClick()
            }
        }
    }

    fun tapBackButton() {
        onComposeScreen<NewTaskScreen>(composeTestRule) {
            backButton {
                performClick()
            }
        }
    }

    fun assertScreenTitleIsDisplayed() {
        onComposeScreen<NewTaskScreen>(composeTestRule) {
            newTaskScreenTitle {
                assertIsDisplayed()
            }
        }
    }
}
