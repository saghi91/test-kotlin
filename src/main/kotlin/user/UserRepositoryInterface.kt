package user

import utils.Responses.Response

interface UserRepositoryInterface {
    fun save(user: User): Response
    fun findAll(): List<String>
}