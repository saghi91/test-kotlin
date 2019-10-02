package user.repositories

import dbUtils.SessionFactory

class RepositoryFactory {
    companion object {
        @JvmStatic
        fun createUserRepository(): UserRepositoryInterface {
            return UserCassandraRepository(SessionFactory.getSession())
        }
    }
}
