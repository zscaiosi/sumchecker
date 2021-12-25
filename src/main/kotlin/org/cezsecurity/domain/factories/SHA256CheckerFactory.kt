package org.cezsecurity.domain.factories

import org.cezsecurity.domain.SHA256Checker
import org.cezsecurity.domain.enums.CheckSumAlgorithms

class SHA256CheckerFactory : SumCheckerFactory() {
    private lateinit var sha256Checker: SHA256Checker

    override fun buildSumChecker(): SHA256Checker =
        if (this::sha256Checker.isInitialized) {
            sha256Checker
        } else {
            sha256Checker = SHA256Checker()
            sha256Checker
        }
}