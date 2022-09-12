package fr.sadok.fizzbuzz.result
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.sadok.fizzbuzz.R
class ResultAdapter() :
    RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    private var dataSet = arrayListOf<String>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.item_text)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.result_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size

    fun submitList(data: ArrayList<String>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }
}
