package com.example.hilttestapp.retrofit

import com.example.hilttestapp.model.Blog
import com.example.hilttestapp.util.EntityMapper
import javax.inject.Inject

class NetworMapper
@Inject
constructor(): EntityMapper<BlogNetworkEntity, Blog>{
    override fun mapfromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogNetworkEntity>): List<Blog>
    {
        return entities.map { mapfromEntity(it)}
    }
}