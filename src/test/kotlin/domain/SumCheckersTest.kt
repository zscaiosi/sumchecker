package domain

import BaseTest
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import java.io.File


private class SumCheckersTest : BaseTest() {
    lateinit var sha256Checker: SumChecker
    lateinit var fileBytes: ByteArray

    @BeforeAll
    fun setup() {
        sha256Checker = SHA256Checker()
        val file = File("./test_file.txt")
        fileBytes = file.readBytes()
    }

    @Test
    fun `outputs SHA256 sum`() {
        val output = sha256Checker.calculateSum(fileBytes)
        assertTrue {  output.equals("3dd7c3b49753b368b9bca013c38c658063709cb6a8650a3d08aed51ab61555a1", ignoreCase = true) }
    }

    @Test
    fun `calculates correct SHA256 sum`() {
        assertTrue { sha256Checker.isValidSum(fileBytes, "3dd7c3b49753b368b9bca013c38c658063709cb6a8650a3d08aed51ab61555a1") }
    }
}