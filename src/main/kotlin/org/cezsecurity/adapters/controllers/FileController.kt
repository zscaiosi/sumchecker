package org.cezsecurity.adapters.controllers

import org.cezsecurity.application.usecases.UseCase
import org.cezsecurity.application.usecases.dtos.CheckFileCommand
import org.cezsecurity.application.usecases.dtos.CheckFileResult

class FileController(val checkFileUseCase: UseCase<CheckFileCommand, CheckFileResult>) {

    fun check(uri: String): Boolean {
        throw NotImplementedError("")
    }
}