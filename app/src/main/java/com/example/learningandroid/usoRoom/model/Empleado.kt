package com.example.learningandroid.usoRoom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Empleado(
    @PrimaryKey val NSS : String,
    @ColumnInfo( name = "nombreC" ) val name : String
)
