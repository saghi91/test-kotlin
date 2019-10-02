package user.services

import UserServiceInterface
import com.google.inject.Inject
import user.User
import user.repositories.UserRepositoryInterface
import utils.Responses.Response

class UserService @Inject constructor(private val repository: UserRepositoryInterface) : UserServiceInterface {
    override fun getAll(): List<String> {
        return repository.findAll()
    }

    override fun create(user: User): Response {
        return repository.save(user)
    }
}
