package helpers

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import screens.BaseRobotScreen
import screens.newTaskScreen
import screens.tasksScreen

class AddNewTaskFlow(semanticsProvider: SemanticsNodeInteractionsProvider) :
    BaseRobotScreen(
        semanticsProvider = semanticsProvider
    )  {

    fun addNewTask(title: String, description: String) {
        tasksScreen(composeTestRule) {
            openAddNewTask()
        }

        newTaskScreen(composeTestRule) {
            addTitle(title)
            addDescription(description)
            saveNewTask()
        }
    }

    fun createTasksAndMarkTheFirstOneAsCompleted(taskOneTitle: String, taskTwoTitle: String) {
        addNewTask(
            title = taskOneTitle,
            description = "Filtering task 1"
        )
        addNewTask(
            title = taskTwoTitle,
            description = "Filtering task 2"
        )
        tasksScreen(composeTestRule) {
            tapOnFirstCheckbox()
        }
    }
}
