package domain

import domain.enums.CheckSumAlgorithms
import support.toHexString
import java.security.MessageDigest

class SHA1Checker : SumChecker {
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
        val messageDigest = MessageDigest.getInstance(CheckSumAlgorithms.SHA1.description)

        messageDigest.update(content)

        return messageDigest.digest().toHexString()
    }
}