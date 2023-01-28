package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

class FilterMenu(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<FilterMenu>(
        semanticsProvider = semanticsProvider
    ) {

    private val composeTestRule = semanticsProvider as ComposeTestRule

    private val activeButton: KNode = child {
        hasText(targetContext.resources.getString(R.string.nav_active))
    }

    private val completedButton: KNode = child {
        hasText(targetContext.resources.getString(R.string.nav_completed))
    }

    private val allButton: KNode = child {
        hasText(targetContext.resources.getString(R.string.nav_all))
    }

    fun filterByActiveTasks() {
        onComposeScreen<FilterMenu>(composeTestRule) {
            activeButton {
                performClick()
            }
        }
    }

    fun filterByCompletedTasks() {
        onComposeScreen<FilterMenu>(composeTestRule) {
            completedButton {
                performClick()
            }
        }
    }

    fun filterByAllTasks() {
        onComposeScreen<FilterMenu>(composeTestRule) {
            allButton {
                performClick()
            }
        }
    }
}
