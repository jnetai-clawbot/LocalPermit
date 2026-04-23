package com.jnetai.localpermit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(tableName = "permits", indices = [Index("permitNumber")])
data class Permit(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val permitNumber: String,
    val title: String,
    val type: String = "Building",
    val status: String = "Applied",
    val address: String = "",
    val applicationDate: String = "",
    val expiryDate: String = "",
    val fee: Double = 0.0,
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "requirements", indices = [Index("permitId")])
data class Requirement(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val permitId: Long,
    val title: String,
    val description: String = "",
    val isCompleted: Boolean = false,
    val dueDate: String = "",
    val completedAt: Long = 0,
    val orderIndex: Int = 0
)

@Entity(tableName = "deadlines", indices = [Index("date")])
data class Deadline(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val permitId: Long,
    val title: String,
    val date: String = "",
    val type: String = "Filing",
    val isCompleted: Boolean = false,
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
)