package tests

import helpers.generateRandomString
import org.junit.Test
import screens.NewTaskScreen
import screens.TasksScreen

class AddNewTaskUITests : UITestCase() {
    private val tasksScreen = TasksScreen(composeTestRule)
    private val newTaskScreen = NewTaskScreen(composeTestRule)

    @Test
    fun test_successfully_adding_a_task() = run {
        val randomString = generateRandomString()
        val title = "Add new task UI test $randomString"

        tasksScreen.openAddNewTask()
        newTaskScreen.addTitle(title)
        newTaskScreen.addDescription("Description for the new task.")
        newTaskScreen.saveNewTask()

        tasksScreen.assertTaskIsDisplayed(title)
    }

    @Test
    fun test_error_message_is_displayed_when_title_body_are_missing() = run {
        val randomString = generateRandomString()
        val title = "Add new task UI test $randomString with error message"

        tasksScreen.openAddNewTask()
        newTaskScreen.addTitle(title)
        newTaskScreen.saveNewTask()

        newTaskScreen.assertScreenTitleIsDisplayed()
        newTaskScreen.tapBackButton()

        tasksScreen.assertTaskIsNotDisplayed(title)
    }
}
