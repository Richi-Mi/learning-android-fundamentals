package com.example.learningandroid.usoRoom.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "departamento",
    foreignKeys = [
        ForeignKey(
            entity = Empleado::class,
            parentColumns = ["NSS"],
            childColumns = ["NSS"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Departamento(
    @PrimaryKey( autoGenerate = true ) val no : Int = 0,
    val nombre : String,
    val NSS : String,
    val años_dig : Int
)