package tests

import helpers.AddNewTaskFlow
import org.junit.Test
import screens.SideMenu
import screens.StatisticsScreen
import screens.TopNavigationBar

class StatisticsUITests : UITestCase() {
    private val addNewTaskFlow = AddNewTaskFlow(composeTestRule)
    private val topNavigationBar = TopNavigationBar(composeTestRule)
    private val sideMenu = SideMenu(composeTestRule)
    private val statisticsScreen = StatisticsScreen(composeTestRule)

    private val taskOneTitle = "Statistics task 1 UI test"
    private val taskTwoTitle = "Statistics task 2 UI test"

    @Test
    fun test_correct_statistics_are_displayed() {
        addNewTaskFlow.createTasksAndMarkTheFirstOneAsCompleted(taskOneTitle, taskTwoTitle)
        topNavigationBar.openSideMenu()
        sideMenu.openStatistics()

        statisticsScreen.assertActiveTasks(50.0)
        statisticsScreen.assertCompletedTasks(50.0)
    }
}
