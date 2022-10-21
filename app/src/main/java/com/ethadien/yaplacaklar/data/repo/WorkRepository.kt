package com.ethadien.yaplacaklar.data.repo

import com.ethadien.yaplacaklar.data.datasource.WorkDataSource
import com.ethadien.yaplacaklar.data.entity.Work

class WorkRepository(var workDataS : WorkDataSource) {

    suspend fun save(work_name:String) = workDataS.save(work_name)

    suspend fun update(work_id: Int, work_name:String) = workDataS.update(work_id, work_name)

    suspend fun delete(work_id :Int) = workDataS.delete(work_id)

    suspend fun loadWorks() : List<Work> = workDataS.loadWorks()

    suspend fun search(searchText:String) : List<Work> = workDataS.search(searchText)
}