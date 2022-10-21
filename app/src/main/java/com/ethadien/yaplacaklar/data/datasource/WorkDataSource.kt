package com.ethadien.yaplacaklar.data.datasource

import com.ethadien.yaplacaklar.data.entity.Work
import com.ethadien.yaplacaklar.room.WorkDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WorkDataSource(var workDao: WorkDao) {

    suspend fun save(work_name :String){
        val newWork = Work(0, work_name)
        workDao.save(newWork)
    }

    suspend fun update(work_id : Int, work_name:String){
        val updatedWork = Work(work_id, work_name)
        workDao.update(updatedWork)
    }

    suspend fun delete(work_id : Int){
        val workToDelete = Work(work_id,"")
        workDao.delete(workToDelete)
    }

    suspend fun search(searchText : String) : List<Work> =
        withContext(Dispatchers.IO){
        workDao.search(searchText)
    }

    suspend fun loadWorks() : List<Work> =
        withContext(Dispatchers.IO){
            workDao.loadWorks()
    }

}