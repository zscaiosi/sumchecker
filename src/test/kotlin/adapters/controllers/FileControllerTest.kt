package adapters.controllers

import BaseTest
import org.junit.jupiter.api.*;
import application.usecases.UseCase
import application.usecases.dtos.CheckFileCommand
import application.usecases.dtos.CheckFileResult
import io.mockk.mockk

class FileControllerTest: BaseTest() {
    private lateinit var checkFileUseCase: UseCase<CheckFileCommand, CheckFileResult>
    @BeforeAll
    fun setup() {
        println("Starting tests...")
        checkFileUseCase = mockk()
    }

    @Test
    fun `it throws NotImplementedException`() {
        assertThrows<NotImplementedError> {
            FileController(checkFileUseCase).check("example.pdf")
        }
    }
}