package com.example.localdatabaseexemplo

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDAO: WordDAO) {
    val todasAsPalavras: Flow<List<Word>> = wordDAO.getPalavrasEmOrdemAlfabetica()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word:Word){
        wordDAO.insert(word)
    }
}