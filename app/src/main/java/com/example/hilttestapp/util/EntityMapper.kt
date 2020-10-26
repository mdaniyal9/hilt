package com.example.hilttestapp.util

interface EntityMapper<Entity, DomainModel> {

    fun mapfromEntity(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel): Entity
}