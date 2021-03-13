package chapter5.exercises

import chapter3.List
import chapter4.Some
import chapter5.Stream
import chapter5.solutions.take
import chapter5.solutions.toList
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

/**
 * Re-enable the tests by removing the `!` prefix!
 */
class Exercise_5_12 : WordSpec({

    //tag::fibs[]
    fun fibs(): Stream<Int> = unfold(0 to 1){ x -> Some(x.first to (x.second to x.second + x.first)) }
    //end::fibs[]

    //tag::from[]
    fun from(n: Int): Stream<Int> =
        unfold(n){ x -> Some(x to x + 1)}
    //end::from[]

    //tag::constant[]
    fun <A> constant(n: A): Stream<A> =
        unfold(n){ Some(it to it) }
    //end::constant[]

    //tag::ones[]
    fun ones(): Stream<Int> = constant(1)
    //end::ones[]

    "fibs" should {
        "return a Stream of fibonacci sequence numbers" {
            fibs().take(10).toList() shouldBe
                List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
        }
    }

    "from" should {
        "return a Stream of ever incrementing numbers" {
            from(5).take(5).toList() shouldBe List.of(5, 6, 7, 8, 9)
        }
    }

    "constants" should {
        "return an infinite stream of a given value" {
            constant(1).take(5).toList() shouldBe
                List.of(1, 1, 1, 1, 1)
        }
    }

    "ones" should {
        "return an infinite stream of 1s" {
            ones().take(5).toList() shouldBe List.of(1, 1, 1, 1, 1)
        }
    }
})
