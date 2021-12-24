package adapters.controllers

import BaseTest
import org.cezsecurity.application.usecases.UseCase
import org.cezsecurity.application.usecases.dtos.CheckFileCommand
import org.cezsecurity.application.usecases.dtos.CheckFileResult
import org.cezsecurity.adapters.controllers.FileController
import org.junit.jupiter.api.*;
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