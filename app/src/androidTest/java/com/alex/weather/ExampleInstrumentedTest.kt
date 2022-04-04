package com.alex.weather

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.test.annotation.UiThreadTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.alex.weather", appContext.packageName)
    }


    @Test
    @UiThreadTest
    fun test() {
        val commitData =
            "@My Very First Commit@ \$by AdiR\$ #s. f.# (#Med.#) This fixes most important bugs #2020-10-10# @Weather App@"

        println(processCommitData(commitData))
    }

    private fun processCommitData(commitData: String): SpannableStringBuilder {
        val spannableString = SpannableStringBuilder(commitData)

        spannableString.transformToBold()
        spannableString.transformToItalic()
        spannableString.removeCharacters()

        return spannableString
    }

    fun SpannableStringBuilder.transformToBold() {
        val matcherBold: Matcher = Pattern.compile("@(.*?)@").matcher(this)

        var selectionStart: Int
        var selectionEnd: Int
        var selection: String?

        println("BOLD:")
        while (matcherBold.find()) {
            selection = matcherBold.group(1)
            selectionStart = this.indexOf(selection!!)
            selectionEnd = selectionStart + selection.length

            println(selection)

            this.setSpan(
                StyleSpan(Typeface.BOLD),
                selectionStart,
                selectionEnd,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }

    fun SpannableStringBuilder.transformToItalic() {
        val matcherItalic: Matcher = Pattern.compile("\\\$(.*?)\\\$").matcher(this)

        var selectionStart: Int
        var selectionEnd: Int
        var selection: String?

        println("ITALIC:")
        while (matcherItalic.find()) {
            selection = matcherItalic.group(1)
            selectionStart = this.indexOf(selection!!)
            selectionEnd = selectionStart + selection.length

            println(selection)

            this.setSpan(
                StyleSpan(Typeface.ITALIC),
                selectionStart,
                selectionEnd,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }

    fun SpannableStringBuilder.removeCharacters() {
        val matcherRemove: Matcher = Pattern.compile("#(.*?)#").matcher(this)

        var selectionStart: Int
        var selectionEnd: Int
        var selection: String?

        //Remove
        println("REMOVE:")
        while (matcherRemove.find()) {
            selection = matcherRemove.group(1)
            selectionStart = this.indexOf(selection!!)
            selectionEnd = selectionStart + selection.length

            println(selection)
            this.delete(selectionStart, selectionEnd)
        }

        println("After deletion: $this")
    }

}