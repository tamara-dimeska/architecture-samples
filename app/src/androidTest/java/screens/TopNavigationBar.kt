package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

class TopNavigationBar(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<TopNavigationBar>(
        semanticsProvider = semanticsProvider
    )  {

    private val composeTestRule = semanticsProvider as ComposeTestRule

    private val moreMenuButton: KNode = child {
        hasContentDescription(targetContext.resources.getString(R.string.menu_more))
    }

    private val filterButton: KNode = child {
        hasContentDescription(targetContext.resources.getString(R.string.menu_filter))
    }

    private val sideMenuButton: KNode = child {
        hasContentDescription(targetContext.resources.getString(R.string.open_drawer))
    }

    fun openMoreMenu() {
        onComposeScreen<TopNavigationBar>(composeTestRule) {
            moreMenuButton {
                performClick()
            }
        }
    }

    fun openFilterMenu() {
        onComposeScreen<TopNavigationBar>(composeTestRule) {
            filterButton {
                performClick()
            }
        }
    }

    fun openSideMenu() {
        onComposeScreen<TopNavigationBar>(composeTestRule) {
            sideMenuButton {
                performClick()
            }
        }
    }
}
