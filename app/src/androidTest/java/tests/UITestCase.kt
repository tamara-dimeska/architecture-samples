package tests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.TasksActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class UITestCase : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withComposeSupport()
) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<TasksActivity>()
}
