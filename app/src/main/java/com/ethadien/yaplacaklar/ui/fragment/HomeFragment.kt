package com.ethadien.yaplacaklar.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.ethadien.yaplacaklar.R
import com.ethadien.yaplacaklar.databinding.FragmentHomeBinding
import com.ethadien.yaplacaklar.ui.adapter.WorkAdapter
import com.ethadien.yaplacaklar.ui.viewmodel.HomeViewModel
import com.ethadien.yaplacaklar.utils.gate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.fragmentInstance = this

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)

        viewModel.workList.observe(viewLifecycleOwner){
            val adapter = WorkAdapter(requireContext(), it, viewModel)
            binding.workAdapter = adapter
        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.searchAction)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                /*when(menuItem.itemId){
                    R.id.searchAction -> {
                        viewModel.loadWorks()
                        return true
                    }
                    else -> return false
                }*/
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }
    fun fabButton(view: View){

        Navigation.gate(view, R.id.home_to_entry)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadWorks()
    }

    override fun onQueryTextSubmit(p0: String): Boolean {
        viewModel.search(p0)
        return true
    }

    override fun onQueryTextChange(p0: String): Boolean {
        viewModel.search(p0)
        return true
    }
}