package application.usecases

import BaseTest
import application.ports.out.FileProvider
import application.usecases.dtos.CheckFileCommand
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CheckFileUseCaseTest: BaseTest() {
    private lateinit var fileProvider: FileProvider

    @BeforeAll
    fun setup() {
        println("Starting tests...")
        fileProvider = mockk()
    }

    @Test
    fun `it throws NotImplementedException`() {
        every {
            fileProvider.find("", "")
        } returns ByteArray(0)

        assertThrows<NotImplementedError> {
            CheckFileUseCase(fileProvider).handleCommand(CheckFileCommand(""))
        }

        verify(exactly = 1) {
            fileProvider.find("", "")
        }
    }
}