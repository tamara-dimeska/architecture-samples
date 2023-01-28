package helpers

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.ComposeTestRule
import io.github.kakaocup.compose.node.element.ComposeScreen
import screens.NewTaskScreen
import screens.TasksScreen

class AddNewTaskFlow(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<NewTaskScreen>(
        semanticsProvider = semanticsProvider
    )  {

    private val composeTestRule = semanticsProvider as ComposeTestRule

    private val tasksScreen = TasksScreen(composeTestRule)
    private val newTaskScreen = NewTaskScreen(composeTestRule)

    fun addNewTask(title: String, description: String) {
        tasksScreen.openAddNewTask()
        newTaskScreen.addTitle(title)
        newTaskScreen.addDescription(description)
        newTaskScreen.saveNewTask()
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
        tasksScreen.tapOnCheckbox()
    }
}
