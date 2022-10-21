package com.ethadien.yaplacaklar.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "works")
data class Work( // keşke isimlendirmeyi task yapsaydım
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "work_id") @NotNull var work_id : Int,
    @ColumnInfo(name = "work_name") @NotNull var work_name : String
) : Serializable {}
