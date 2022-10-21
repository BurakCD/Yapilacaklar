package com.ethadien.yaplacaklar.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ethadien.yaplacaklar.R
import com.ethadien.yaplacaklar.databinding.FragmentDetailsBinding
import com.ethadien.yaplacaklar.ui.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding : FragmentDetailsBinding
    private lateinit var viewModel : DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetailsViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.detailsFragment = this

        val bundle : DetailsFragmentArgs by navArgs()
        val workArg = bundle.work
        binding.workInstance = workArg

        return binding.root
    }

    fun updateButton(work_id : Int, work_name : String){
        viewModel.update(work_id, work_name)
    }

}