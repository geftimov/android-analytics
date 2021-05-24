package com.theappbusiness.sample.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class FakeLoggedInUser(
    val userId: String,
    val displayName: String
)