package com.example.hilttestapp.room

import com.example.hilttestapp.model.Blog
import com.example.hilttestapp.retrofit.BlogNetworkEntity
import com.example.hilttestapp.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<BlogCacheEntity, Blog>
{
    override fun mapfromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogCacheEntity>): List<Blog>
    {
        return entities.map { mapfromEntity(it)}
    }
}