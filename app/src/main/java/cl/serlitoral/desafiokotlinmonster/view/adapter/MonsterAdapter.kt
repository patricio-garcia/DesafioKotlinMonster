package cl.serlitoral.desafiokotlinmonster.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.serlitoral.desafiokotlinmonster.databinding.ListItemMonsterBinding
import cl.serlitoral.desafiokotlinmonster.databinding.MonsterItemBinding
import cl.serlitoral.desafiokotlinmonster.model.Monster
import com.bumptech.glide.Glide

class MonsterAdapter: RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder>() {

    private val monsterList: List<Monster>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonsterViewHolder {
        val binding = MonsterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonsterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonsterViewHolder, position: Int) {
        val list = monsterList!![position]
        Glide.with(holder.imgMonster.context)
            .load(list.drawable)
            .into(holder.imgMonster)

        holder.monsterPoint.setText(list.monsterPoints)
        holder.name.text = list.name
    }

    override fun getItemCount(): Int {
        return monsterList?.size ?:0
    }

    class MonsterViewHolder(itemview: MonsterItemBinding):  RecyclerView.ViewHolder(itemview.root) {
        val name: TextView = itemview.tvName
        val monsterPoint: TextView = itemview.tvMonsterPoints
        val imgMonster: ImageView = itemview.imgMonster
    }
}