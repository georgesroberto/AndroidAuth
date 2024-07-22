package com.georges.myapp.data

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(username: String, password: String) {
        val user = User(username = username, password = password)
        userDao.insert(user)
    }

    suspend fun loginUser(username: String, password: String): Boolean {
        return userDao.getUser(username, password) != null
    }

//    suspend fun getUser(username: String): User? {
//        return userDao.getUserByUsername(username)
//    }
}
