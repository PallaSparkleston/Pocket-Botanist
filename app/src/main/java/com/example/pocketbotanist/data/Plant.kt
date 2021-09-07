package com.example.pocketbotanist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Plant(@PrimaryKey val id: UUID = UUID.randomUUID(),
                 var title: String = "",
                 var isOwned: Boolean = false,
                 var indoor: String = "Indoor",
                 var water: String = "Low",
                 var light: String = "Low",
                 var description: String = "Placeholder"
)



