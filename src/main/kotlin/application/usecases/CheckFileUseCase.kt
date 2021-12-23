package application.usecases

import application.ports.out.FileProvider
import application.usecases.dtos.CheckFileCommand
import application.usecases.dtos.CheckFileResult
import java.lang.Exception

class CheckFileUseCase(val fileProvider: FileProvider) : UseCase<CheckFileCommand, CheckFileResult> {
    override fun handleCommand(command: CheckFileCommand): CheckFileResult {
        try {
            val rawFile = fileProvider.find("", "")
            throw NotImplementedError("")
        } catch (e: Exception) {
            return CheckFileResult(
                null,
                "",
                ""
            )
        }
    }
}