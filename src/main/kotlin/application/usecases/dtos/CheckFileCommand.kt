package application.usecases.dtos

import domain.enums.CheckSumAlgorithms

data class CheckFileCommand(
    val uri: String,
    val algorithm: CheckSumAlgorithms,
    val expectedHash: String?
)