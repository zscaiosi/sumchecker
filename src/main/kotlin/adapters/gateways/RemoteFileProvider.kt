package adapters.gateways

import application.ports.out.FileProvider

class RemoteFileProvider: FileProvider {
    override fun find(host: String, name: String): ByteArray {
        throw NotImplementedError("")
    }

    override fun findHostedHash(uri: String?): String {
        throw NotImplementedError("")
    }
}