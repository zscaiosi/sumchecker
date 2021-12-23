package application.usecases.dtos

import domain.enums.CheckSumAlgorithms

data class CheckFileResult(
    val data: ByteArray?,
    val resultHash: CheckSumHash
)

data class CheckSumHash(
    val algorithm: CheckSumAlgorithms,
    val checkSum: String? = null
)