package com.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.auth.User
import java.lang.IllegalArgumentException

class UserProfileViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val userId : String = savedStateHandle["uid"] ?:
        throw IllegalArgumentException("missing user id")//connecting the view model the fragment

    //val user : User = TODO()// without LiveData class to notify the fragment class when data updated
    /*To incorporate the LiveData component into our app, we change
    the field type in the UserProfileViewModel to LiveData<User>
    * Now, the UserProfileFragment is informed when the data is updated.
    * Furthermore, because this LiveData field is lifecycle aware,
    * it automatically cleans up references after they're no longer needed.
    * */

    val user : LiveData<User> = TODO()
}