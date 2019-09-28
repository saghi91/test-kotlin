package user

import dbUtils.SessionFactory
import UserServiceInterface

class ServiceFactory {
    fun createUserService(): UserServiceInterface {
        val userRepository = RepositoryFactory.createUserRepository()

        return UserService(userRepository)
    }


}