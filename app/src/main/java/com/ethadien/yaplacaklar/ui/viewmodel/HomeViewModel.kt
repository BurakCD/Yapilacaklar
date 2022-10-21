package com.ethadien.yaplacaklar.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ethadien.yaplacaklar.data.entity.Work
import com.ethadien.yaplacaklar.data.repo.WorkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (var workRepository : WorkRepository) : ViewModel() {

    var workList = MutableLiveData<List<Work>>()

    init {
        loadWorks()
    }

    fun loadWorks(){
        CoroutineScope(Dispatchers.Main).launch {
            workList.value = workRepository.loadWorks()
        }
    }

    fun search(searchText:String){
        CoroutineScope(Dispatchers.Main).launch {
            workList.value = workRepository.search(searchText)
        }
    }

    fun delete(work_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            workRepository.delete(work_id)
            loadWorks()
        }
    }
}