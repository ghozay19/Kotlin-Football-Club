package com.example.ghozy.footbalappsbasic

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ghozy.footbalappsbasic.R.id.club_logo
import com.example.ghozy.footbalappsbasic.R.id.club_name
import org.jetbrains.anko.*


class ClubAdapter(val context: Context,val items: List<ClubItem>,val listener: (ClubItem) -> Unit)
    : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(ClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindItem(items[position], listener)

    }

    class ClubUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                verticalLayout() {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.club_logo
                    }.lparams {
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = R.id.club_name
                        textSize = 14f
                    }.lparams {
                        margin = dip(16)
                    }


                }
            }
        }
    }


    override fun getItemCount(): Int = items.size

    class ClubViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val clubLogo: ImageView = view.find(club_logo)
        private val clubName: TextView = view.find(club_name)

        fun bindItem(items: ClubItem, listener: (ClubItem) -> Unit) {
            Glide.with(itemView.context)
                    .load(items.logoClub)
                    .into(clubLogo)

            clubName.text = items.nameClub

            itemView.setOnClickListener {
                listener(items)
            }

        }


    }

}