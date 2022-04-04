package com.alex.weather

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import org.junit.Test
import java.util.regex.Matcher
import java.util.regex.Pattern


class CommitsUnitTest {

    @Test
    fun test() {
        //GIVEN
        val commitData =
            "@My Very First Commit@ \$by AdiR\$ #s. f.# (#Med.#) This fixes most important bugs #2020-10-10# @Weather App@"

        println(processCommitData(commitData))
    }

    private fun processCommitData(commitData: String): SpannableString {
        val spannableString = SpannableString(commitData)
        val matcher: Matcher = Pattern.compile("@(.*?)@").matcher(commitData)

        while (matcher.find()) {
            val selection = matcher.group(1)
            val selectionStart: Int = commitData.indexOf(selection!!) - 1
            val selectionEnd: Int = selectionStart + selection.length

            val boldSpan = StyleSpan(Typeface.BOLD)
            spannableString.setSpan(
                boldSpan,
                selectionStart,
                selectionEnd,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        return spannableString
    }

}