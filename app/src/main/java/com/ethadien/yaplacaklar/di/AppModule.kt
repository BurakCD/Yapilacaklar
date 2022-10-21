package com.ethadien.yaplacaklar.di

import android.content.Context
import androidx.room.Room
import com.ethadien.yaplacaklar.data.datasource.WorkDataSource
import com.ethadien.yaplacaklar.data.repo.WorkRepository
import com.ethadien.yaplacaklar.room.DatabaseTool
import com.ethadien.yaplacaklar.room.WorkDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideWorkRepo(workDataS : WorkDataSource) : WorkRepository{
        return WorkRepository(workDataS)
    }

    @Provides
    @Singleton
    fun provideWorkDataS(workDao: WorkDao) : WorkDataSource{
        return WorkDataSource(workDao)
    }

    @Provides
    @Singleton
    fun provideWorkDao(@ApplicationContext context: Context) : WorkDao{
        val databaseTool = Room.databaseBuilder(context, DatabaseTool::class.java, "works.sqlite")
            .createFromAsset("works.sqlite").build()
        return databaseTool.getWorkDao()
    }
}