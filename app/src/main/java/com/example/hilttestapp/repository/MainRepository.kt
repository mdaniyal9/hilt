package com.example.hilttestapp.repository

import com.example.hilttestapp.retrofit.BlogRetrofit
import javax.inject.Inject

class MainRepository
@Inject
constructor(
    private val retrofit: BlogRetrofit
){
}