package com.ethadien.yaplacaklar.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ethadien.yaplacaklar.data.repo.WorkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(var workRepository : WorkRepository) : ViewModel() {

    fun update(work_id:Int, work_name:String){
        CoroutineScope(Dispatchers.Main).launch {
            workRepository.update(work_id, work_name)
        }
    }
}