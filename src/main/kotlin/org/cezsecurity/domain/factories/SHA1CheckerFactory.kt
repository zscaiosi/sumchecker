package org.cezsecurity.domain.factories

import org.cezsecurity.domain.SHA1Checker
import org.cezsecurity.domain.enums.CheckSumAlgorithms

class SHA1CheckerFactory : SumCheckerFactory() {
    private lateinit var sha1Checker: SHA1Checker

    override fun buildSumChecker(): SHA1Checker =
        if (this::sha1Checker.isInitialized) {
            sha1Checker
        } else {
            sha1Checker = SHA1Checker()
            sha1Checker
        }
}