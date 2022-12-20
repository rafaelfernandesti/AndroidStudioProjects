package com.example.localdatabaseexemplo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_word")
class Word(
    @PrimaryKey @ColumnInfo(name = "word") val word: String
)
