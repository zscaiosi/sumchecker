package org.cezsecurity.adapters.gateways

import org.cezsecurity.application.ports.out.FileProvider

class RemoteFileProvider: FileProvider {
    override fun find(host: String, name: String): ByteArray {
        throw NotImplementedError("")
    }
}