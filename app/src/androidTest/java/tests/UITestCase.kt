package tests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.android.architecture.blueprints.todoapp.TasksActivity
import org.junit.Rule

open class UITestCase {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<TasksActivity>()
}
