package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

fun topNavigatorBar(
    composeTestRule: ComposeTestRule,
    func: TopNavigatorBarRobot.() -> Unit
) = TopNavigatorBarRobot(composeTestRule).apply { func() }

class TopNavigatorBarRobot(semanticsProvider: SemanticsNodeInteractionsProvider) :
    BaseRobotScreen(
        semanticsProvider = semanticsProvider
    ) {

    private val moreMenuButton = targetContext.resources.getString(R.string.menu_more)
    private val filterButton = targetContext.resources.getString(R.string.menu_filter)
    private val sideMenuButton = targetContext.resources.getString(R.string.open_drawer)

    fun openMoreMenu() {
        composeTestRule.onNodeWithContentDescription(moreMenuButton).performClick()
    }

    fun openFilterMenu() {
        composeTestRule.onNodeWithContentDescription(filterButton).performClick()
    }

    fun openSideMenu() {
        composeTestRule.onNodeWithContentDescription(sideMenuButton).performClick()
    }
}
