package domain.factories

import domain.SumChecker
import domain.enums.CheckSumAlgorithms

abstract class SumCheckerFactory {
    abstract fun buildSumChecker(algorithm: CheckSumAlgorithms): SumChecker
}