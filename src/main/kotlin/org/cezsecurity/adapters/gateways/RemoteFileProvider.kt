package org.cezsecurity.adapters.gateways

import org.cezsecurity.application.ports.out.FileProvider

class RemoteFileProvider: FileProvider {
    override fun find(uri: String): ByteArray {
        throw NotImplementedError("NOT_IMPLEMENTED")
    }
}
