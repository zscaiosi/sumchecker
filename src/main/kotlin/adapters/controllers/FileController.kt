package adapters.controllers

import application.usecases.UseCase
import application.usecases.dtos.CheckFileCommand
import application.usecases.dtos.CheckFileResult

class FileController(val checkFileUseCase: UseCase<CheckFileCommand, CheckFileResult>) {

    fun check(uri: String): Boolean {
        throw NotImplementedError("")
    }
}