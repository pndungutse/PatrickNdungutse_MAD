package com.example.finalprojectgroup.util

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.example.finalprojectgroup.model.Route
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.text.DecimalFormat
import java.time.LocalDateTime

class RouteDatabase {
    //Firestore instance
    private val db = Firebase.firestore

    //recipe collection
    private val routeRef = db.collection("routess")

    var routes = mutableStateListOf<Route>()
    var route = {}

    suspend fun getRoutes() {
        try {
            routeRef.addSnapshotListener { docSnapShot, error ->
                if (docSnapShot != null) {
                    //clear list to avoid duplicates
                    routes.clear()
                    for (doc in docSnapShot) {
                        //add to list
                        routes.add(doc.toObject())
                        Log.d("get", doc.getId())
                    }
                    Log.d("get", routes.size.toString())
                } else
                    if (error != null) {
                        Log.e("get", "listener error", error)
                    }
            }
        } catch (error: FirebaseFirestoreException) {
            Log.e("get", "listener error", error)
        }
    }

    suspend fun addRoute(route: Route){
        routeRef.add(route)
            .addOnSuccessListener { documentReference ->
                Log.d("add", "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.e("add", "Error adding document", e)
            }
    }

    suspend fun deleteRoute(id: String){
        routeRef.document(id).delete()
            .addOnSuccessListener {
                Log.d("delete", "DocumentSnapshot successfully deleted")
            }
            .addOnFailureListener { e ->
                Log.e("delete", "Error deleting document", e)
            }
    }

    suspend fun updateRoute(current: String){

        val mFormat = DecimalFormat("00")
        val hours = mFormat.format(java.lang.Double.valueOf(LocalDateTime.now().hour.toDouble()))
        val minutes = mFormat.format(java.lang.Double.valueOf(LocalDateTime.now().minute.toDouble()))
        val seconds = mFormat.format(java.lang.Double.valueOf(LocalDateTime.now().second.toDouble()))

        val current_time = ""+LocalDateTime.now().dayOfMonth+"/"+LocalDateTime.now().month+"/"+LocalDateTime.now().year+" "+hours+":"+minutes+":"+seconds+""
        val data = hashMapOf(
            "from" to "Town",
            "dest" to "CMU",
            "current" to current,
            "current_time" to current_time,
            "departure_time" to "8:00 AM"

        )

        routeRef.document("xLJHl0YkkIGdesxTUaWy").set(data)
            .addOnSuccessListener {
                Log.d("update", "DocumentSnapshot successfully updated")
            }
            .addOnFailureListener { e ->
                Log.e("update", "Error updating document", e)
            }
    }

    suspend fun getRoute(id: String){
        val docRef = routeRef.document(id)
        docRef.get()
            .addOnSuccessListener { document ->
//                Log.d("document", "DocumentSnapshot data: ${document.data}")
                if (document != null) {
                    Log.d("document", "DocumentSnapshot data: ${document.data}")
                    route = {document.data}

                } else {
                    Log.d("document", "No such document")
                }
            }
            .addOnFailureListener { e ->
                Log.e("document", "Error while getting document", e)
            }
    }
}