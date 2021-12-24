package com.kmm.playground.appcomponents.data.repository

import com.kmm.playground.appcomponents.data.model.User
import org.koin.core.component.KoinComponent

class UserRepository: KoinComponent {
    fun getLoggedInUser(): User {
        return User("123", "Marl","Brill")
    }

    fun getUsers(): List<User> {
        return listOf(
            User("123", "Marl","Brill"),
            User("456", "Farl", "Skrill")
        )
    }
}
