package support

private val HEX_CHARS = "0123456789ABCDEF".toCharArray()

fun ByteArray.toHexString(): String {
    val result = StringBuffer()

    this.forEach { byte ->
        val octet = byte.toInt()
        val firstIndex = (octet and 0xF0).ushr(4)
        val secondIndex = octet and 0x0F
        result.append(HEX_CHARS[firstIndex])
        result.append(HEX_CHARS[secondIndex])
    }

    return result.toString()
}