package nsu.ritersport.focususerrs.presentation.user_list.rv

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

val Int.dp: Int get() = (this * Resources.getSystem().displayMetrics.density).roundToInt()

class MarginItemDecoration(private val spaceSize: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = spaceSize.dp
            }
            bottom = spaceSize.dp
            left = spaceSize.dp
            right = spaceSize.dp
        }
    }
}