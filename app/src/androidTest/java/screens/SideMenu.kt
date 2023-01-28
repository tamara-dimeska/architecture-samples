package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

class SideMenu(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<SideMenu>(
        semanticsProvider = semanticsProvider
    ) {

    private val composeTestRule = semanticsProvider as ComposeTestRule

    private val statisticsButton: KNode = child {
        hasText(targetContext.resources.getString(R.string.statistics_title))
    }

    fun openStatistics() {
        onComposeScreen<SideMenu>(composeTestRule) {
            statisticsButton {
                performClick()
            }
        }
    }
}
