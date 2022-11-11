package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class TasksScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<TasksScreen>(
        semanticsProvider = semanticsProvider
    ) {
    private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

    val addTaskButton: KNode = child {
        hasContentDescription(this@TasksScreen.targetContext.resources.getString(R.string.add_task))
    }

    fun getTaskWithText(title: String): KNode {
        return child { hasText(title) }
    }

    val checkboxButton: KNode = child {
        hasTestTag("checkbox_button")
    }

    val moreMenuButton: KNode = child {
        hasTestTag("more_menu")
    }

    val clearCompletedButton: KNode = child {
        hasText(this@TasksScreen.targetContext.resources.getString(R.string.menu_clear))
    }

    val noTasksImage: KNode = child {
        hasContentDescription(this@TasksScreen.targetContext.resources.getString(R.string.no_tasks_image_content_description))
    }
}
