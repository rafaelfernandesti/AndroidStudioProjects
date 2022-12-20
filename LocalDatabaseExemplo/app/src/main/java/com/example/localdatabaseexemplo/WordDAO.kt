package com.example.localdatabaseexemplo

import android.R
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDAO {
    @Query("SELECT * FROM tb_word ORDER BY word ASC")
    fun getPalavrasEmOrdemAlfabetica(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM tb_word")
    suspend fun apagarTudo()

}