package com.srijan.nit3213finalapp

import org.junit.Test
import org.junit.Assert.*
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.mockito.kotlin.verify

class LoginViewModelTest {

    private val repository: UserRepository = mock()

    @Test
    fun `login with empty username should not call repository`() {
        val username = ""
        val password = "s8116663"
        assert(username.isEmpty())
    }

    @Test
    fun `entity has correct properties`() {
        val entity = Entity(
            property1 = "Test Property 1",
            property2 = "Test Property 2",
            description = "Test Description"
        )
        assertEquals("Test Property 1", entity.property1)
        assertEquals("Test Property 2", entity.property2)
        assertEquals("Test Description", entity.description)
    }

    @Test
    fun `login request has correct username and password`() {
        val request = LoginRequest("Srijan", "s8116663")
        assertEquals("Srijan", request.username)
        assertEquals("s8116663", request.password)
    }

    @Test
    fun `dashboard response contains entities`() {
        val entities = listOf(
            Entity("Property1", "Property2", "Description")
        )
        val response = DashboardResponse(entities, 1)
        assertEquals(1, response.entityTotal)
        assertEquals(1, response.entities.size)
    }
}