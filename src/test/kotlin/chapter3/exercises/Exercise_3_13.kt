package chapter3.exercises

import chapter10.exercises.ex6.foldRight
import chapter3.Cons
import chapter3.List
import chapter3.List.Companion.empty
import chapter3.solutions.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

// tag::init[]
fun <A> append(a1: List<A>, a2: List<A>): List<A> = foldRight(a1, a2){ a, acc ->  Cons(a, acc) }
// end::init[]

fun <A> appendL(a1: List<A>, a2: List<A>): List<A> = foldLeft(foldLeft(a1, empty<A>()){ acc, a -> Cons(a, acc) }, a2){ acc, a ->  Cons(a, acc) }

class Exercise_3_13 : WordSpec({
    "list append" should {
        "append two lists to each other using foldRight" {
            append(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }

    "list appendL" should {
        "append two lists to each other using foldLeft" {
            appendL(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }
})
