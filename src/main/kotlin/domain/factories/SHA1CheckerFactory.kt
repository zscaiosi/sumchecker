package domain.factories

import domain.SHA1Checker
import domain.enums.CheckSumAlgorithms

class SHA1CheckerFactory : SumCheckerFactory() {
    private lateinit var sha1Checker: SHA1Checker

    override fun buildSumChecker(algorithm: CheckSumAlgorithms): SHA1Checker =
        if (this::sha1Checker.isInitialized) {
            sha1Checker
        } else {
            sha1Checker = SHA1Checker()
            sha1Checker
        }
}