package user

import dbUtils.SessionFactory

class RepositoryFactory {
    companion object {
        @JvmStatic
        fun createUserRepository(): UserRepository {
            return UserRepository(SessionFactory.getSession())
        }
    }
}