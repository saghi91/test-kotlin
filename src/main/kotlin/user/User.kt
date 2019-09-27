package user

import java.time.Instant
import java.util.*

data class User(
    val user_id: UUID = UUID.randomUUID(),
    val name: String = "",
    val password: String = "",
    val age: Int = -1,
    val creation_date: Instant = Instant.now())

