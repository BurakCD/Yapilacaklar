package com.ethadien.yaplacaklar.ui.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ethadien.yaplacaklar.R
import com.ethadien.yaplacaklar.data.entity.Work
import com.ethadien.yaplacaklar.databinding.WorkItemBinding
import com.ethadien.yaplacaklar.ui.fragment.HomeFragmentDirections
import com.ethadien.yaplacaklar.ui.viewmodel.HomeViewModel
import com.ethadien.yaplacaklar.utils.gate
import com.ethadien.yaplacaklar.utils.subText

class WorkAdapter(var mcontext : Context,
                  var workList : List<Work>,
                  var viewModel: HomeViewModel) : RecyclerView.Adapter<WorkAdapter.workViewHolder>() {

    inner class workViewHolder(binding: WorkItemBinding) : RecyclerView.ViewHolder(binding.root){
        var binding:WorkItemBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): workViewHolder {
        val binding : WorkItemBinding = DataBindingUtil.inflate(LayoutInflater.from(mcontext), R.layout.work_item, parent, false)
        return workViewHolder(binding)
    }

    override fun onBindViewHolder(holder: workViewHolder, position: Int) {
        val work = workList.get(position)
        val holder = holder.binding

        holder.workInstance = work

        holder.cardView.setOnClickListener {
            val direction = HomeFragmentDirections.homeToDetails(work = work)
            Navigation.gate(it, direction)
        }

        holder.deleteImage.setOnClickListener {
            val dialog = AlertDialog.Builder(mcontext)
            dialog.setTitle(R.string.wantToDelete)
            dialog.setMessage(work.work_name.subText(0, 30))
            dialog.setIcon(R.drawable.ic_delete_outline)

            dialog.setPositiveButton(R.string.okayText){ s, d-> // s = string d = Dialog Interface
                viewModel.delete(work.work_id)
            }

            dialog.setNegativeButton(R.string.noText){ s, d-> // s = string d = Dialog Interface
            }
            dialog.create().show()
        }
    }

    override fun getItemCount(): Int {
        return workList.size
    }
}