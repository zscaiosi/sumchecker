package org.cezsecurity.domain.factories

import org.cezsecurity.domain.MD5Checker
import org.cezsecurity.domain.enums.CheckSumAlgorithms

class MD5Checker : SumCheckerFactory() {
    private lateinit var md5Checker: MD5Checker

    override fun buildSumChecker(algorithm: CheckSumAlgorithms): MD5Checker =
        if (this::md5Checker.isInitialized) {
            md5Checker
        } else {
            md5Checker = MD5Checker()
            md5Checker
        }
}