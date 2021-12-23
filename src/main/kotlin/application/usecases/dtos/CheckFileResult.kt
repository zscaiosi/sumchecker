package application.usecases.dtos

import domain.enums.CheckSumAlgorithms

data class CheckFileResult(
    val data: ByteArray?,
    val resultHash: CheckSumHash?,
    val inputHash: CheckSumHash
) {
    val isValid: Boolean
        get() = this.resultHash.equals(this.inputHash)
}

data class CheckSumHash(
    val algorithm: CheckSumAlgorithms,
    val checkSum: String
)