package com.ethadien.yaplacaklar.utils


import android.view.View

import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gate(view : View, nav_id:Int){
    findNavController(view).navigate(nav_id)
}

fun Navigation.gate(view : View, nav_id:NavDirections){
    findNavController(view).navigate(nav_id)
}

fun String.subText(firstIndex : Int, lastIndex : Int) : String{
    if (length < lastIndex){
        return "${substring(0, length)}"
    }else{
        return "${substring(0, lastIndex)}..."
    }
}