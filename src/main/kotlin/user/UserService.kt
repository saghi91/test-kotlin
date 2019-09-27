package user

import com.google.inject.Inject

class UserService @Inject constructor(val repository: UserRepository) {
    fun getAll(): List<String> {
        return repository.findAll()
    }

    fun create(user: User) {
        return repository.save(user)
    }
}
