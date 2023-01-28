package tests

import helpers.AddNewTaskFlow
import org.junit.Test
import screens.TasksScreen

class CompletingTasksUITests : UITestCase() {

    private val addNewTaskFlow = AddNewTaskFlow(composeTestRule)
    private val tasksScreen = TasksScreen(composeTestRule)

    @Test
    fun test_user_can_mark_a_task_as_completed_and_then_back_to_active() {
        val title = "Mark task as completed/active UI test"

        addNewTaskFlow.addNewTask(
            title = title,
            description = "Completed/active task"
        )
        tasksScreen.tapOnCheckbox()

        tasksScreen.assertTaskIsDisplayed(title)
        tasksScreen.assertTaskIsMarkedAsComplete()

        tasksScreen.tapOnCheckbox()

        tasksScreen.assertTaskIsDisplayed(title)
        tasksScreen.assertTaskIsMarkedAsActive()
    }
}
