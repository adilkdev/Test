package com.app.test.user

class UserService(private val userRepo: UserRepo) {

    fun loginUser(email: String, password: String): String {
        return when(userRepo.loginUser(email, password)) {
            LOGIN_STATUS.INVALID_USER -> "User does not exist"
            LOGIN_STATUS.INVALID_PASSWORD -> "Invalid password"
            LOGIN_STATUS.SUCCESS -> "Logged in successfully"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown error has occurred"
        }
    }

}