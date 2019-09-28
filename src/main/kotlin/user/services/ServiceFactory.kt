package user.services

import UserServiceInterface
import user.repositories.RepositoryFactory

class ServiceFactory {
    fun createUserService(): UserServiceInterface {
        val userRepository = RepositoryFactory.createUserRepository()

        return UserService(userRepository)
    }


}