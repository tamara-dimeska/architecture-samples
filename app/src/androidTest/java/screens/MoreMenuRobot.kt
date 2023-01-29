package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

fun moreMenu(
    composeTestRule: ComposeTestRule,
    func: MoreMenuRobot.() -> Unit
) = MoreMenuRobot(composeTestRule).apply { func() }

class MoreMenuRobot(semanticsProvider: SemanticsNodeInteractionsProvider) :
    BaseRobotScreen(
        semanticsProvider = semanticsProvider
    ) {

    private val clearCompletedButton = targetContext.resources.getString(R.string.menu_clear)

    fun clearCompleteTasks() {
        composeTestRule.onNodeWithText(clearCompletedButton).performClick()
    }
}
