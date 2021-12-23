package domain

import domain.enums.CheckSumAlgorithms

data class UnderCheckFile(
    val uri: String,
    val sumChecker: SumChecker,
    val supposedSum: String,
    val content: ByteArray?
) {
    fun isValidFile(): Boolean {
        if (this.content == null) return false

        return this.sumChecker.isValidSum(this.content, this.supposedSum)
    }
}
