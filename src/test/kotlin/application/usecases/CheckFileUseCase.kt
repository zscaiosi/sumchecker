package application.usecases

import BaseTest
import application.usecases.dtos.CheckFileCommand
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CheckFileUseCaseTest: BaseTest() {
    @BeforeAll
    fun setup() {
        println("Starting tests...")
    }

    @Test
    fun `it throws NotImplementedException`() {
        assertThrows<NotImplementedError> {
            CheckFileUseCase().handleCommand(CheckFileCommand(""))
        }
    }
}