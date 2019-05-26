package com.masfaris.myzone.api

import com.masfaris.myzone.model.UserModel
import io.reactivex.Observable
import retrofit2.http.GET

interface GetData {

    @GET("users")
    fun getData() : Observable<ArrayList<UserModel>>
}