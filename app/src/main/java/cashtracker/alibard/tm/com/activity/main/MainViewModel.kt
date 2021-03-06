package cashtracker.alibard.tm.com.activity.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import cashtracker.alibard.tm.com.model.User
import com.google.firebase.auth.FirebaseAuth


class MainViewModel : ViewModel() {
    var data: MutableLiveData<User> = MutableLiveData()

    init {


    }

    fun fillUser() {
        var ss =
        data.postValue(User(FirebaseAuth.getInstance().currentUser?.displayName ?: "None",
                FirebaseAuth.getInstance().currentUser?.email?:"example@mail.con",
                getUserPhoto()))

    }

    private fun getUserPhoto(): String {
        return  if(!FirebaseAuth.getInstance().currentUser?.photoUrl.toString().isNullOrBlank()){
            if(FirebaseAuth.getInstance().currentUser?.photoUrl.toString().isNotEmpty()) {
                FirebaseAuth.getInstance().currentUser?.photoUrl.toString()
            }else{
                "http://2.bp.blogspot.com/-wW9hEXOAl5g/VPv1J8b76fI/AAAAAAAAEFY/Qy6xOr-M80k/s1600/ANDROID.png"
            }
        }else{
            "http://2.bp.blogspot.com/-wW9hEXOAl5g/VPv1J8b76fI/AAAAAAAAEFY/Qy6xOr-M80k/s1600/ANDROID.png"
        }
    }

    fun getUser(): LiveData<User> = data
}