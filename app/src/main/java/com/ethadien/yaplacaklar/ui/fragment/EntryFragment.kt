package com.ethadien.yaplacaklar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ethadien.yaplacaklar.R
import com.ethadien.yaplacaklar.databinding.FragmentEntryBinding
import com.ethadien.yaplacaklar.ui.viewmodel.EntryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EntryFragment : Fragment() {
    private lateinit var binding : FragmentEntryBinding
    private lateinit var viewModel : EntryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : EntryViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_entry, container, false)
        binding.entryFragment = this

        return binding.root
    }

    fun saveButton(work_name:String){
        viewModel.save(work_name)

    }


}