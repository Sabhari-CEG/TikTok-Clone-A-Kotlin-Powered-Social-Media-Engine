import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_training.R
import com.example.kotlin_training.R.layout.item_image

class ImagePagerAdapter : RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {

    private val images = listOf(
        R.drawable.newyork,
        R.drawable.chicago,
        R.drawable.california,
        R.drawable.boston,
        R.drawable.nc

        // Add all your images here
    )

    private val captions = listOf(
        "New York City",
        "Chicago City",
        "San Diego City",
        "Boston",
        "North Carolina"


        // Add all your captions here
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val actualPosition = position % images.size
        holder.imageView.setImageResource(images[actualPosition])
        holder.captionText.text = captions[actualPosition]
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val captionText: TextView = itemView.findViewById(R.id.captionText)
    }
}