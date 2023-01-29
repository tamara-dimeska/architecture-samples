package tests

import helpers.AddNewTaskFlow
import org.junit.Before
import org.junit.Test
import screens.filterMenu
import screens.tasksScreen
import screens.topNavigatorBar

class FilteringTasksUITests: UITestCase() {
    private val addNewTaskFlow = AddNewTaskFlow(composeTestRule)

    private val taskOneTitle = "Filtering task 1 UI test"
    private val taskTwoTitle = "Filtering task 2 UI test"

    @Before
    fun prepareApp() {
        addNewTaskFlow.createTasksAndMarkTheFirstOneAsCompleted(taskOneTitle, taskTwoTitle)
    }

    @Test
    fun test_user_can_filter_by_active_tasks_and_then_by_all() {
        topNavigatorBar(composeTestRule) {
            openFilterMenu()
        }
        filterMenu(composeTestRule) {
            filterByActiveTasks()
        }
        tasksScreen(composeTestRule) {
            assertTaskIsNotDisplayed(taskOneTitle)
            assertTaskIsDisplayed(taskTwoTitle)
        }

        topNavigatorBar(composeTestRule) {
            openFilterMenu()
        }
        filterMenu(composeTestRule) {
            filterByAllTasks()
        }
        tasksScreen(composeTestRule) {
            assertTaskIsDisplayed(taskOneTitle)
            assertTaskIsDisplayed(taskTwoTitle)
        }
    }

    @Test
    fun test_user_can_sort_by_completed_tasks_and_then_by_all() {
        topNavigatorBar(composeTestRule) {
            openFilterMenu()
        }
        filterMenu(composeTestRule) {
            filterByCompletedTasks()
        }
        tasksScreen(composeTestRule) {
            assertTaskIsNotDisplayed(taskTwoTitle)
            assertTaskIsDisplayed(taskOneTitle)
        }

        topNavigatorBar(composeTestRule) {
            openFilterMenu()
        }
        filterMenu(composeTestRule) {
            filterByAllTasks()
        }
        tasksScreen(composeTestRule) {
            assertTaskIsDisplayed(taskOneTitle)
            assertTaskIsDisplayed(taskTwoTitle)
        }
    }
}
