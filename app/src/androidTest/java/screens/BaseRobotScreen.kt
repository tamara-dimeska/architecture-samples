package screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule

open class BaseRobotScreen(semanticsProvider: SemanticsNodeInteractionsProvider) {
    val composeTestRule = semanticsProvider as ComposeTestRule
}
