package user.repositories

import user.User
import utils.Responses.Response

interface UserRepositoryInterface {
    fun save(user: User): Response
    fun findAll(): List<String>
}