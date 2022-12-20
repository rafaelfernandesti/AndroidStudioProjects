package com.example.localdatabaseexemplo

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository): ViewModel() {
    val todasAsPalavras: LiveData<List<Word>> = repository.todasAsPalavras.asLiveData()

    //função para nova corotina
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}
class WordViewModelFactory(private val repository: WordRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom((WordViewModel::class.java))){
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw java.lang.IllegalArgumentException("Classe ViewModel desconhecida")
    }
}