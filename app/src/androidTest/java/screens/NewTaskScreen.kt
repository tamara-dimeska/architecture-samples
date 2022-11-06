package screens

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.R
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class NewTaskScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<NewTaskScreen>(
        semanticsProvider = semanticsProvider
    ) {
    private val targetContext: Context = ApplicationProvider.getApplicationContext<Context>()

    val titleField: KNode = child {
        hasText(this@NewTaskScreen.targetContext.resources.getString(R.string.title_hint))
    }

    val descriptionField: KNode = child {
        hasText(this@NewTaskScreen.targetContext.resources.getString(R.string.description_hint))
    }

    val saveTaskButton: KNode = child {
        hasContentDescription(this@NewTaskScreen.targetContext.resources.getString(R.string.cd_save_task))
    }
}
