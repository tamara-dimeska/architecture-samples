package tests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.TasksActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import helpers.generateRandomString
import io.github.kakaocup.compose.node.element.ComposeScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import screens.NewTaskScreen
import screens.TasksScreen

@RunWith(AndroidJUnit4::class)
class AddNewTaskUITests : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withComposeSupport()
) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<TasksActivity>()

    private fun openAddNewTask() {
        ComposeScreen.onComposeScreen<TasksScreen>(composeTestRule) {
            addTaskButton {
                performClick()
            }
        }
    }

    @Test
    fun test_successfully_adding_a_task() =
        before {
            openAddNewTask()
        }.after {
            ComposeScreen.onComposeScreen<TasksScreen>(composeTestRule) {
                checkboxButton {
                    performClick()
                }
                moreMenuButton {
                    performClick()
                }
                clearCompletedButton {
                    performClick()
                }
                noTasksImage {
                    assertIsDisplayed()
                }
            }
        }.run {
            val randomString = generateRandomString(length = 6)

            step("Fill in Title") {
                ComposeScreen.onComposeScreen<NewTaskScreen>(composeTestRule) {
                    titleField {
                        performTextInput("Add new task UI test $randomString")
                    }
                }
            }
            step("Fill in Description") {
                ComposeScreen.onComposeScreen<NewTaskScreen>(composeTestRule) {
                    descriptionField {
                        performTextInput("Description for the new task.")
                    }
                }
            }
            step("Tap Save button") {
                ComposeScreen.onComposeScreen<NewTaskScreen>(composeTestRule) {
                    saveTaskButton {
                        performClick()
                    }
                }
            }
            step("Check if the task is displayed in the list") {
                ComposeScreen.onComposeScreen<TasksScreen>(composeTestRule) {
                    getTaskWithText("Add new task UI test $randomString").assertIsDisplayed()
                }
            }
        }

    @Test
    fun test_error_message_is_displayed_when_title_body_are_missing() = run {
//        step("")
    }
}
