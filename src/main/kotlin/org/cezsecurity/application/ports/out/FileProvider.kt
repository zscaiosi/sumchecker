package org.cezsecurity.application.ports.out

interface FileProvider {
    fun find(uri: String): ByteArray
}