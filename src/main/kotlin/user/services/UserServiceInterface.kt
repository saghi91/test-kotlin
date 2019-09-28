import user.User
import user.repositories.UserRepository
import utils.Responses.Response

interface UserServiceInterface {
    val repository: UserRepository
    fun getAll(): List<String>
    fun create(user: User): Response
}