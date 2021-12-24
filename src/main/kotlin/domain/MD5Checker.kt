package domain

import domain.enums.CheckSumAlgorithms
import support.toHexString
import java.security.MessageDigest

class MD5Checker : SumChecker {
    override fun calculateSum(content: ByteArray): String =
        if (content.isEmpty()) {
            throw IllegalArgumentException("EMPTY BYTE ARRAY")
        } else {
            getDigestFromContent(content)
        }

    override fun isValidSum(content: ByteArray, underCheckSum: String): Boolean {
        if (content.isEmpty() || underCheckSum.isEmpty()) {
            throw IllegalArgumentException("INVALID INPUTS")
        } else {
            return underCheckSum.equals(getDigestFromContent(content), ignoreCase = true)
        }
    }

    private fun getDigestFromContent(content: ByteArray): String {
        val messageDigest = MessageDigest.getInstance(CheckSumAlgorithms.MD5.description)

        messageDigest.update(content)

        return messageDigest.digest().toHexString()
    }
}