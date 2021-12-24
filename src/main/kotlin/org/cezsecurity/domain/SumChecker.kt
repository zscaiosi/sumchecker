package org.cezsecurity.domain

interface SumChecker {
    fun calculateSum(content: ByteArray): String
    fun isValidSum(content: ByteArray, underCheckSum: String): Boolean
}