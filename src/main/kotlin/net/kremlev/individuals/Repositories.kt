package net.kremlev.individuals

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : CrudRepository<City, Long> {
    fun findByName(name: String): City?
    fun findAllBy(): Iterable<City>
}

@Repository
interface WomanRepository: CrudRepository<Woman, Long> {
    fun findAllByName(name: String): Iterable<Woman>
    fun findAllByAge(age: Long): Iterable<Woman>
}

@Repository
interface UserRepository: CrudRepository<User, Long> {
    fun findByUsername(username: String): User
}

