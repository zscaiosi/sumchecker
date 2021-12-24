package org.cezsecurity.application.usecases

interface UseCase<Command, Result> {
    fun handleCommand(command: Command): Result
}