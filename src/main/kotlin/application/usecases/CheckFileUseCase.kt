package application.usecases

import application.ports.out.FileProvider
import application.usecases.dtos.CheckFileCommand
import application.usecases.dtos.CheckFileResult

class CheckFileUseCase(fileProvider: FileProvider) : UseCase<CheckFileCommand, CheckFileResult> {
    override fun handleCommand(command: CheckFileCommand): CheckFileResult {
        throw NotImplementedError("")
    }
}