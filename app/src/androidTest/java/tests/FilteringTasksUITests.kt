package tests

import helpers.AddNewTaskFlow
import org.junit.Test
import screens.FilterMenu
import screens.TasksScreen
import screens.TopNavigationBar

class FilteringTasksUITests: UITestCase() {
    private val addNewTaskFlow = AddNewTaskFlow(composeTestRule)
    private val tasksScreen = TasksScreen(composeTestRule)
    private val topNavigationBar = TopNavigationBar(composeTestRule)
    private val filterMenu = FilterMenu(composeTestRule)

    private val taskOneTitle = "Filtering task 1 UI test"
    private val taskTwoTitle = "Filtering task 2 UI test"

    @Test
    fun test_user_can_filter_by_active_tasks_and_then_by_all() {
        addNewTaskFlow.createTasksAndMarkTheFirstOneAsCompleted(taskOneTitle, taskTwoTitle)
        topNavigationBar.openFilterMenu()
        filterMenu.filterByActiveTasks()

        tasksScreen.assertTaskIsNotDisplayed(taskOneTitle)
        tasksScreen.assertTaskIsDisplayed(taskTwoTitle)

        topNavigationBar.openFilterMenu()
        filterMenu.filterByAllTasks()

        tasksScreen.assertTaskIsDisplayed(taskOneTitle)
        tasksScreen.assertTaskIsDisplayed(taskTwoTitle)
    }

    @Test
    fun test_user_can_sort_by_completed_tasks_and_then_by_all() {
        addNewTaskFlow.createTasksAndMarkTheFirstOneAsCompleted(taskOneTitle, taskTwoTitle)
        topNavigationBar.openFilterMenu()
        filterMenu.filterByCompletedTasks()

        tasksScreen.assertTaskIsNotDisplayed(taskTwoTitle)
        tasksScreen.assertTaskIsDisplayed(taskOneTitle)

        topNavigationBar.openFilterMenu()
        filterMenu.filterByAllTasks()

        tasksScreen.assertTaskIsDisplayed(taskOneTitle)
        tasksScreen.assertTaskIsDisplayed(taskTwoTitle)
    }
}
