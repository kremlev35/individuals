package net.kremlev.individuals

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class City(
        @Id @GeneratedValue var id: Long,
        @Column(nullable = false, unique = true) var name: String
)

@Entity
class Woman(
        @Id @GeneratedValue var id: Long,
        @Column(nullable = false) var addedAt: LocalDateTime = LocalDateTime.now(),
        @Column(nullable = false) var name: String,
        @Column(nullable = false) var age: Long,
        var description: String?,
        @Column(nullable = false, unique = true) var phoneNumber: String
)

@Entity
class User(
        @Id @GeneratedValue var id: Long,
        @Column(nullable = false, unique = true) var username: String,
        @Column(nullable = false) var password: String
)