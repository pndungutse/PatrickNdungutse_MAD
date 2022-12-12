package com.example.finalprojectgroup.model
import com.google.firebase.firestore.DocumentId
data class Route(@DocumentId val id: String, val from: String, val dest:String, val current:String, val current_time:String, val departure_time:String) {
    constructor(): this( "", "","", "", "", ""){}
}
