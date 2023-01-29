package tests

import helpers.AddNewTaskFlow
import org.junit.Test
import screens.moreMenu
import screens.tasksScreen
import screens.topNavigatorBar

class ClearCompleteTasksUITests : UITestCase() {
    private val addNewTaskFlow = AddNewTaskFlow(composeTestRule)

    @Test
    fun test_user_can_remove_completed_tasks() {
        val title = "Clear complete tasks UI test"

        addNewTaskFlow.addNewTask(
            title = title,
            description = "Clear task"
        )
        tasksScreen(composeTestRule) {
            tapOnFirstCheckbox()
        }
        topNavigatorBar(composeTestRule) {
            openMoreMenu()
        }
        moreMenu(composeTestRule) {
            clearCompleteTasks()
        }
        tasksScreen(composeTestRule) {
            assertTaskIsNotDisplayed(title)
        }
    }
}
