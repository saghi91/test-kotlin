import user.User
import user.repositories.UserRepository
import utils.Responses.Response

interface UserServiceInterface {
    fun getAll(): List<String>
    fun create(user: User): Response
}