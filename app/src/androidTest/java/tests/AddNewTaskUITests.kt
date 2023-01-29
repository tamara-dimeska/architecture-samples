package tests

import helpers.generateRandomString
import org.junit.Test
import screens.newTaskScreen
import screens.tasksScreen

class AddNewTaskUITests : UITestCase() {

    @Test
    fun test_successfully_adding_a_task() {
        val randomString = generateRandomString()
        val title = "Add new task UI test $randomString"

        tasksScreen(composeTestRule) {
            openAddNewTask()
        }

        newTaskScreen(composeTestRule) {
            addTitle(title)
            addDescription("Description for the new task.")
            saveNewTask()
        }

        tasksScreen(composeTestRule) {
            assertTaskIsDisplayed(title)
        }
    }

    @Test
    fun test_error_message_is_displayed_when_title_body_are_missing() {
        val randomString = generateRandomString()
        val title = "Add new task UI test $randomString with error message"

        tasksScreen(composeTestRule) {
            openAddNewTask()
        }

        newTaskScreen(composeTestRule) {
            addTitle(title)
            saveNewTask()
            assertScreenTitleIsDisplayed()
            tapBackButton()
        }

        tasksScreen(composeTestRule) {
            assertTaskIsNotDisplayed(title)
        }
    }
}
