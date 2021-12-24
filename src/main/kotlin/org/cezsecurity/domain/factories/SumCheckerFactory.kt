package org.cezsecurity.domain.factories

import org.cezsecurity.domain.SumChecker
import org.cezsecurity.domain.enums.CheckSumAlgorithms

abstract class SumCheckerFactory {
    abstract fun buildSumChecker(algorithm: CheckSumAlgorithms): SumChecker
}