package com.raywenderlich.timefighter.recycler_view_project

import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProjectAdapter(private val persons: ArrayList<Persons>):RecyclerView.Adapter<ProjectAdapter.ViewHolder>(){
    /**
     * PopupMenu.OnMenuItemClickListener implemented from pop up menu code below
     */
    class ViewHolder(v:View):RecyclerView.ViewHolder(v), PopupMenu.OnMenuItemClickListener {
        /**
         * Create an instance of the image view and text view
         */
        var imageInstance :ImageView
        var textViewInstance : TextView
        var menuInstance : TextView
        init {
            imageInstance = v.findViewById(R.id.imageId)
            textViewInstance = v.findViewById(R.id.textViewId)
            // menuId from list layout
            menuInstance = v.findViewById(R.id.menuId)

            // popUpMenu() will return error, click and create function
            menuInstance.setOnClickListener { popUpMenu(it) }
        }

        private fun popUpMenu(vPopUpMenu:View) {
            // item view is constant, from RecyclerView.ViewHolder . so its either u use the itemView.contex that is constant or you use
            //vPopUpMenu both will still work
            val popUpMenus = PopupMenu(vPopUpMenu.context,vPopUpMenu)
            popUpMenus.inflate(R.menu.item_list_menu)

            // this is to make the pop up menu items clickable
            popUpMenus.setOnMenuItemClickListener(this)
//                when(it.itemId){
//                    //from item list menu where we have edit and delete
//                    R.id.action_edit_id->{
//                        Toast.makeText(vPopUpMenu.context, "Clicked Button Clicked", Toast.LENGTH_LONG).show()
//                        true
//                    }
//                    R.id.action_delete_id->{
//                        Toast.makeText(vPopUpMenu.context, "Delete Button Clicked", Toast.LENGTH_LONG).show()
//                        true
//                    }
//                    else->true
//                }
//            }
            popUpMenus.show()
//            val variablePopUp = PopupMenu::class.java.getDeclaredField("mVariablePopUp")
//            variablePopUp.isAccessible = true
//            var variableMenu = variablePopUp.get(popUpMenus)
//            variableMenu.javaClass.getDeclaredMethod("setForceShowIcon",Boolean::class.java).invoke(variableMenu,true)
        }

        /**
         * This was also created from the POP up menu
         * start with a when statement, it will ask you to wrap in an if not null
         */


        override fun onMenuItemClick(item: MenuItem?): Boolean {
            if (item != null) {
                when(item.itemId){
                    R.id.action_edit_id->{
                        Toast.makeText(itemView.context, "Edit Button Clicked @ position:" + adapterPosition, Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.action_delete_id->{
                        Toast.makeText(itemView.context, "Delete Button Clicked @ position:" + adapterPosition , Toast.LENGTH_LONG).show()
                        true
                    }
                }
            }
            return false
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_layout))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPerson = persons[position]
        /**
         * Image from data class and firstname text
         */
        holder.imageInstance.setImageResource(currentPerson.image)
        holder.textViewInstance.text = currentPerson.firstName

    }

    override fun getItemCount() = persons.size

}