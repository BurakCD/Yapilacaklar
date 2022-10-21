package com.ethadien.yaplacaklar.room

import androidx.room.*
import com.ethadien.yaplacaklar.data.entity.Work

@Dao
interface WorkDao {

    @Query("SELECT * FROM works")
    suspend fun loadWorks() : List<Work>

    @Insert()
    suspend fun save(work: Work)

    @Update
    suspend fun update(work: Work)

    @Delete
    suspend fun delete(work: Work)

    @Query("SELECT * FROM works WHERE work_name like '%' || :searchText || '%'")
    suspend fun search(searchText : String) : List<Work>
}