package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

fun sideMenu(
    composeTestRule: ComposeTestRule,
    func: SideMenuRobot.() -> Unit
) = SideMenuRobot(composeTestRule).apply { func() }

class SideMenuRobot(semanticsProvider: SemanticsNodeInteractionsProvider) :
    BaseRobotScreen(
        semanticsProvider = semanticsProvider
    ) {

    private val statisticsButton = targetContext.resources.getString(R.string.statistics_title)

    fun openStatistics() {
        composeTestRule.onNodeWithText(statisticsButton).performClick()
    }
}
