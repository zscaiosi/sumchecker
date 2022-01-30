package application.usecases

import BaseTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.cezsecurity.application.exceptions.UseCaseException
import org.cezsecurity.application.ports.out.FileProvider
import org.cezsecurity.application.usecases.CheckFileUseCase
import org.cezsecurity.application.usecases.UseCase
import org.cezsecurity.application.usecases.dtos.CheckFileCommand
import org.cezsecurity.application.usecases.dtos.CheckFileResult
import org.cezsecurity.domain.enums.CheckSumAlgorithms
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

private class CheckFileUseCaseTest: BaseTest() {
    companion object {
        const val FILE_URI = "./test_file.txt"
        const val SHA256_HASH = "3dd7c3b49753b368b9bca013c38c658063709cb6a8650a3d08aed51ab61555a1"
    }
    @MockK
    private lateinit var fileProvider: FileProvider

    private lateinit var useCase: UseCase<CheckFileCommand, CheckFileResult>

    @BeforeAll
    fun setup() {
        MockKAnnotations.init(this)
        useCase = CheckFileUseCase(fileProvider)
    }

    @Test
    fun `it check checks a file correctly for SHA256`() {
        every { fileProvider.find(FILE_URI) } returns File(FILE_URI).readBytes()

        val result = useCase.handleCommand(setupSuccessfullCommand())

        verify { fileProvider.find(FILE_URI) }

        assertTrue { result.resultHash.checkSum.equals(SHA256_HASH, ignoreCase = true) }
    }

    @Test
    fun `it throws Exception because file does not exist`() {
        every { fileProvider.find(FILE_URI) } returns ByteArray(0)

        assertFailsWith(UseCaseException::class) {
            val result = useCase.handleCommand(setupSuccessfullCommand())
        }

        verify { fileProvider.find(FILE_URI) }
    }

    private fun setupSuccessfullCommand() =
        CheckFileCommand(
            FILE_URI,
            CheckSumAlgorithms.SHA256,
            SHA256_HASH
        )
}