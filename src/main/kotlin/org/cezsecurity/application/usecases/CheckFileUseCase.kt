package org.cezsecurity.application.usecases

import org.cezsecurity.application.ports.out.FileProvider
import org.cezsecurity.application.usecases.dtos.CheckFileCommand
import org.cezsecurity.application.usecases.dtos.CheckFileResult
import org.cezsecurity.application.usecases.dtos.CheckSumHash
import java.lang.Exception

class CheckFileUseCase(val fileProvider: FileProvider) : UseCase<CheckFileCommand, CheckFileResult> {
    override fun handleCommand(command: CheckFileCommand): CheckFileResult {
        try {
            throw NotImplementedError("")
        } catch (e: Exception) {
            return CheckFileResult(
                null,
                CheckSumHash(command.algorithm)
            )
        }
    }
}