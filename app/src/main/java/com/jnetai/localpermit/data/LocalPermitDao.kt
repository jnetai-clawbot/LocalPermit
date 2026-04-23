package com.jnetai.localpermit.data

import androidx.room.*
import com.jnetai.localpermit.model.Permit
import com.jnetai.localpermit.model.Requirement
import com.jnetai.localpermit.model.Deadline

@Dao
interface LocalPermitDao {
    @Query("SELECT * FROM permits ORDER BY createdAt DESC") suspend fun getAllPermits(): List<Permit>
    @Query("SELECT * FROM permits WHERE id = :id") suspend fun getPermit(id: Long): Permit?
    @Insert suspend fun insertPermit(permit: Permit): Long
    @Update suspend fun updatePermit(permit: Permit)
    @Delete suspend fun deletePermit(permit: Permit)

    @Query("SELECT * FROM requirements WHERE permitId = :permitId ORDER BY orderIndex") suspend fun getRequirementsForPermit(permitId: Long): List<Requirement>
    @Insert suspend fun insertRequirement(requirement: Requirement): Long
    @Update suspend fun updateRequirement(requirement: Requirement)
    @Delete suspend fun deleteRequirement(requirement: Requirement)

    @Query("SELECT * FROM deadlines ORDER BY date ASC") suspend fun getAllDeadlines(): List<Deadline>
    @Query("SELECT * FROM deadlines WHERE permitId = :permitId") suspend fun getDeadlinesForPermit(permitId: Long): List<Deadline>
    @Insert suspend fun insertDeadline(deadline: Deadline): Long
    @Update suspend fun updateDeadline(deadline: Deadline)
    @Delete suspend fun deleteDeadline(deadline: Deadline)
}