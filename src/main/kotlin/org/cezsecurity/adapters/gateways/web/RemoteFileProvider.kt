package org.cezsecurity.adapters.gateways.web

import org.cezsecurity.application.ports.out.FileProvider
import org.cezsecurity.adapters.gateways.enums.ValidProtocols
import java.net.URL


class RemoteFileProvider: FileProvider {
    override fun find(uri: String): ByteArray {
        if (!isURIValid(uri)) throw IllegalArgumentException("PROTOCOL_NAME")

        return URL(uri).openStream().readAllBytes()
    }

    private fun isURIValid(uri: String) =
        ValidProtocols.values().any { protocol -> protocol.name.equals(uri.split(':')[0], ignoreCase = true) }
}
