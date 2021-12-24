package org.cezsecurity.application.usecases.dtos

import org.cezsecurity.domain.enums.CheckSumAlgorithms

data class CheckFileCommand(
    val uri: String,
    val algorithm: CheckSumAlgorithms,
    val expectedHash: String?
)