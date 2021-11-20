package application.ports.out

interface FileProvider {
    fun find(host: String, name: String): ByteArray
    fun findHostedHash(uri: String?): String
}