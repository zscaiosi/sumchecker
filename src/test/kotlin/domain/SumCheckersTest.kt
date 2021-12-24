package domain

import BaseTest
import org.cezsecurity.domain.SumChecker
import org.cezsecurity.domain.SHA256Checker
import org.cezsecurity.domain.SHA1Checker
import org.cezsecurity.domain.MD5Checker
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import java.io.File


private class SumCheckersTest : BaseTest() {
    lateinit var sha256Checker: SumChecker
    lateinit var sha1Checker: SumChecker
    lateinit var md5Checker: SumChecker
    lateinit var fileBytes: ByteArray

    @BeforeAll
    fun setup() {
        sha256Checker = SHA256Checker()
        sha1Checker = SHA1Checker()
        md5Checker = MD5Checker()
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

    @Test
    fun `outputs SHA1 sum`() {
        val output = sha1Checker.calculateSum(fileBytes)
        assertTrue {  output.equals("c5e179efb7100cbca08692eeade961406d0610b7", ignoreCase = true) }
    }

    @Test
    fun `calculates correct SHA1 sum`() {
        assertTrue { sha1Checker.isValidSum(fileBytes, "c5e179efb7100cbca08692eeade961406d0610b7") }
    }

    @Test
    fun `outputs MD5 sum`() {
        val output = md5Checker.calculateSum(fileBytes)
        assertTrue {  output.equals("27a695da0f22624bee5db50145a4fb76", ignoreCase = true) }
    }

    @Test
    fun `calculates correct MD5 sum`() {
        assertTrue { md5Checker.isValidSum(fileBytes, "27a695da0f22624bee5db50145a4fb76") }
    }
}