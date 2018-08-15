package i_introduction._3_Default_Arguments

import util.JavaCode
import util.TODO
import util.doc2

fun todoTask3(): Nothing = TODO(
    """
        Task 3.
        Several overloaded 'foo' functions in the class 'JavaCode3' can be replaced with one function in Kotlin.
        Change the declaration of the function 'foo' in a way that makes the code using 'foo' compile.
        You have to add 'foo' parameters and implement its body.
        Uncomment the commented code and make it compile.
    """,
    documentation = doc2(),
    references = { name: String -> JavaCode3().foo(name); foo(name) })

fun foo(name: String, number: Int = JavaCode3().defaultNumber, toUpperCase: Boolean = false): String = JavaCode3().foo(name, number, toUpperCase)


class JavaCode3 : JavaCode() {
    val defaultNumber = 42

    @JvmOverloads
    fun foo(name: String, number: Int = defaultNumber, toUpperCase: Boolean = false): String {
        return (if (toUpperCase) name.toUpperCase() else name) + number
    }

    fun foo(name: String, toUpperCase: Boolean): String {
        return foo(name, defaultNumber, toUpperCase)
    }
}

fun task3(): String {
    //todoTask3()
    return (foo("a") +
            foo("b", number = 1) +
            foo("c", toUpperCase = true) +
            foo(name = "d", number = 2, toUpperCase = true))
}