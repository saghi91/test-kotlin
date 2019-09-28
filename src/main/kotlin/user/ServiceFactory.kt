package user

import dbUtils.SessionFactory
import UserServiceInterface

class ServiceFactory {
    fun createUserService(): UserServiceInterface {
        val userRepository = createUserRepository()

        return UserService(userRepository)
    }

    private fun createUserRepository(): UserRepository {
        return UserRepository(SessionFactory.getSession())
    }
}