package org.cezsecurity.application.usecases

import org.cezsecurity.application.exceptions.UseCaseException
import org.cezsecurity.application.ports.out.FileProvider
import org.cezsecurity.application.usecases.dtos.CheckFileCommand
import org.cezsecurity.application.usecases.dtos.CheckFileResult
import org.cezsecurity.application.usecases.dtos.CheckSumHash
import org.cezsecurity.domain.SumChecker
import org.cezsecurity.domain.enums.CheckSumAlgorithms
import org.cezsecurity.domain.enums.CheckSumAlgorithms.SHA256
import org.cezsecurity.domain.enums.CheckSumAlgorithms.SHA1
import org.cezsecurity.domain.enums.CheckSumAlgorithms.MD5
import org.cezsecurity.domain.factories.MD5CheckerFactory
import org.cezsecurity.domain.factories.SHA1CheckerFactory
import org.cezsecurity.domain.factories.SHA256CheckerFactory
import java.io.IOException
import kotlin.Exception

class CheckFileUseCase(val fileProvider: FileProvider) : UseCase<CheckFileCommand, CheckFileResult> {
    override fun handleCommand(command: CheckFileCommand): CheckFileResult {
        try {
            val file = fileProvider.find(command.uri)
            if (file.isEmpty()) throw UseCaseException("File could not be found")

            val checker = setupBusinessRule(command.algorithm)
            return CheckFileResult(
                file,
                CheckSumHash(
                    command.algorithm,
                    checker.calculateSum(file)
                )
            )
        } catch (e: IOException) {
            println(e.message)

            throw UseCaseException("Failed checking file because ${e.message}")
        }
    }

    private fun setupBusinessRule(algorithm: CheckSumAlgorithms): SumChecker =
        when (algorithm) {
            SHA256 -> SHA256CheckerFactory().buildSumChecker()
            SHA1 -> SHA1CheckerFactory().buildSumChecker()
            MD5 -> MD5CheckerFactory().buildSumChecker()
        }
}