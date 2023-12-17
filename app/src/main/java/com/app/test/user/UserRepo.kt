package com.app.test.user

class UserRepo {

    val users = listOf(
        User(1, "John", "john@gmail.com","12345"),
        User(1, "Ross", "ross@gmail.com","12345"),
        User(1, "Emily", "emily@gmail.com","12345"),
    )

    fun loginUser(email: String, password: String) : LOGIN_STATUS {
        // fetch from db is simulated here
        val users = users.filter { user -> user.email == email }
        return if (users.size == 1) {
            if(users[0].password == password) LOGIN_STATUS.SUCCESS
            else LOGIN_STATUS.INVALID_PASSWORD
        }
        else LOGIN_STATUS.INVALID_USER
    }

}