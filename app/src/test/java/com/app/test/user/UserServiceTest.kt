package com.app.test.user

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepo: UserRepo

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepo.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @Test
    fun testUserService_returns_invalid_password() {
        val userService = UserService(userRepo)
        val status = userService.loginUser("abc@gmail.com", "123")
        Assert.assertEquals("Invalid password", status)
    }

}