package adapters.gateways.web

import BaseTest
import org.cezsecurity.adapters.gateways.web.RemoteFileProvider
import org.cezsecurity.application.ports.out.FileProvider
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.IOException
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class RemoteFileProviderTest: BaseTest() {
    companion object {
        const val FILE_URI = "https://github.com/digininja/DVWA/blob/master/about.php"
    }

    private lateinit var remoteFileProvider: FileProvider

    @BeforeAll
    fun setup() {
        remoteFileProvider = RemoteFileProvider()
    }

    @Test
    fun `it returns a byte array from a resource`() {
        val byteArray = remoteFileProvider.find(FILE_URI)

        assertTrue { byteArray.isNotEmpty() }
    }

    @Test
    fun `it throws and exception when invalid protocol`() {
        assertFailsWith(IllegalArgumentException::class) {
            remoteFileProvider.find(FILE_URI.replace("https", "http", true))
        }
    }
}