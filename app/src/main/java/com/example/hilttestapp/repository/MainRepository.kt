package com.example.hilttestapp.repository

import com.example.hilttestapp.model.Blog
import com.example.hilttestapp.retrofit.BlogRetrofit
import com.example.hilttestapp.retrofit.NetworMapper
import com.example.hilttestapp.room.BlogDao
import com.example.hilttestapp.room.CacheMapper
import com.example.hilttestapp.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class MainRepository

constructor(
    private val blogdao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networMapper: NetworMapper
){
    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkBlogs = blogRetrofit.get()
            val blogs = networMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs)
            {
                blogdao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs = blogdao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        }catch (e: Exception)
        {
            emit(DataState.Error(e))
        }
    }
}