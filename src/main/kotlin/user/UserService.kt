package user

import UserServiceInterface
import com.google.inject.Inject
import utils.Responses.Response

class UserService @Inject constructor(override val repository: UserRepository) : UserServiceInterface {
    override fun getAll(): List<String> {
        return repository.findAll()
    }

    override fun create(user: User): Response {
        return repository.save(user)
    }
}
