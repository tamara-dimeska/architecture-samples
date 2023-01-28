package tests

import helpers.AddNewTaskFlow
import org.junit.Test
import screens.MoreMenu
import screens.TasksScreen
import screens.TopNavigationBar

class ClearCompleteTasksUITests : UITestCase() {

    private val addNewTaskFlow = AddNewTaskFlow(composeTestRule)
    private val tasksScreen = TasksScreen(composeTestRule)
    private val topNavigationBar = TopNavigationBar(composeTestRule)
    private val moreMenu = MoreMenu(composeTestRule)

    @Test
    fun test_user_can_remove_completed_tasks() {
        val title = "Clear complete tasks UI test"

        addNewTaskFlow.addNewTask(
            title = title,
            description = "Clear task"
        )
        tasksScreen.tapOnCheckbox()
        topNavigationBar.openMoreMenu()
        moreMenu.clearCompleteTasks()

        tasksScreen.assertTaskIsNotDisplayed(title)
    }
}
