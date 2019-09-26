package user

import java.time.Instant
import java.util.*

data class User(
    val user_id: UUID?,
    val name: String?,
    val password: String?,
    val age: Int,
    val creation_date: Instant?)

