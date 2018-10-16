package com.example.ghozy.footbalappsbasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.ghozy.footbalappsbasic.R.array.*
import org.jetbrains.anko.ctx
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {
    var items: MutableList<ClubItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)


        loadData()

        verticalLayout {

            recyclerView {
                lparams(width = matchParent, height = matchParent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = ClubAdapter(ctx, items) {
                    ctx.startActivity<DetailActivity>(
                            "logoClub" to it.logoClub,
                            "clubName" to "${it.nameClub}",
                            "clubDesc" to "${it.descClub}"
                    )
                }
            }
        }

    }

    private fun loadData() {
//ambil dari strings array
        val image = resources.obtainTypedArray(club_image)
        val name = resources.getStringArray(club_name)
        val desc = resources.getStringArray(R.array.club_desc)

        items.clear()
        for (i in name.indices) {
            items.add(ClubItem(name[i],
                    image.getResourceId(i, 0),
                    desc[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
}
