package org.cezsecurity.application.usecases.dtos

import org.cezsecurity.domain.enums.CheckSumAlgorithms

data class CheckFileResult(
    val data: ByteArray?,
    val resultHash: CheckSumHash
)

data class CheckSumHash(
    val algorithm: CheckSumAlgorithms,
    val checkSum: String? = null
)