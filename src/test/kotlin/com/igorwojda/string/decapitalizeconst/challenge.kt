package com.igorwojda.string.decapitalizeconst

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun decapitalizeConst(str: String): String {
    return str.split("_").mapIndexed { index, s ->
        if(index == 0) {
            s.toLowerCase()
        } else {
            s.toLowerCase().capitalize()
        }
    }.joinToString("")
}

private class Test {
    @Test
    fun `"FOOBAR" return null`() {
        decapitalizeConst("FOOBAR") shouldBeEqualTo "foobar"
    }

    @Test
    fun `"FOO_BAR" return "fooBar"`() {
        decapitalizeConst("FOO_BAR") shouldBeEqualTo "fooBar"
    }

    @Test
    fun `"FOO_BAR_BAZ" return "fooBarBaz"`() {
        decapitalizeConst("FOO_BAR_BAZ") shouldBeEqualTo "fooBarBaz"
    }

    @Test
    fun `"__F_BAR" return "fBar"`() {
        decapitalizeConst("__F_BAR") shouldBeEqualTo "fBar"
    }

    @Test
    fun `"F_BAR" return "fBar"`() {
        decapitalizeConst("F_BAR") shouldBeEqualTo "fBar"
    }

    @Test
    fun `empty string return empty string`() {
        decapitalizeConst("") shouldBeEqualTo ""
    }
}
