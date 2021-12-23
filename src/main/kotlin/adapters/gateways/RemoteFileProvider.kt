package adapters.gateways

import application.ports.out.FileProvider

class RemoteFileProvider: FileProvider {
    override fun find(host: String, name: String): ByteArray {
        throw NotImplementedError("")
    }
}