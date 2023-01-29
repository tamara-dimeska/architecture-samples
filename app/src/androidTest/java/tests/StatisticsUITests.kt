package tests

import helpers.AddNewTaskFlow
import org.junit.Test
import screens.sideMenu
import screens.statisticsScreen
import screens.topNavigatorBar

class StatisticsUITests : UITestCase() {
    private val addNewTaskFlow = AddNewTaskFlow(composeTestRule)

    private val taskOneTitle = "Statistics task 1 UI test"
    private val taskTwoTitle = "Statistics task 2 UI test"

    @Test
    fun test_correct_statistics_are_displayed() {
        addNewTaskFlow.createTasksAndMarkTheFirstOneAsCompleted(taskOneTitle, taskTwoTitle)

        topNavigatorBar(composeTestRule) {
            openSideMenu()
        }
        sideMenu(composeTestRule) {
            openStatistics()
        }
        statisticsScreen(composeTestRule) {
            assertActiveTasks(50.0)
            assertCompletedTasks(50.0)
        }
    }
}
